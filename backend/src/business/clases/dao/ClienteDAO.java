package business.clases.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import javax.jdo.Transaction;

import business.clases.*;

public class ClienteDAO {

    public ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        try{
            PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
            Transaction transaction = persistentManager.currentTransaction();
    
            try {
                transaction.begin();
    
                @SuppressWarnings("unchecked")
                Query<Cliente> clientesQuery = persistentManager.newQuery("SELECT FROM " + Cliente.class.getName());
    
                for (Cliente c : clientesQuery.executeList()){
                    clientes.add(c);
                }
    
            } catch (Exception ex) {
                // TODO: handle exception
                System.err.println("* Exception executing a query: " + ex.getMessage());
            }finally{
                if(transaction.isActive()){
                    transaction.rollback();
                }
                persistentManager.close();
            }
    
        } catch (Exception ex) {
            // TODO: handle exception
            System.err.println("* Exception: " + ex.getMessage());
        }
        return clientes;
    }

    public boolean actualizarCliente(Cliente clienteAntiguo, Cliente clienteNuevo) {
        boolean funciona = false;
        try {
            PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
            Transaction transaction = persistentManager.currentTransaction();
    
            try {
                transaction.begin();
    
                // Buscar el cliente antiguo por su DNI en la base de datos
                Query<Cliente> query = persistentManager.newQuery(Cliente.class);
                query.setFilter("dni == dniParam");
                query.declareParameters("String dniParam");
                List<Cliente> resultados = (List<Cliente>) query.execute(clienteAntiguo.getDni());
    
                if (resultados.size() == 1) {
                    Cliente clientePersistente = resultados.get(0);
    
                    // Actualizar la información del cliente persistente con los datos del cliente nuevo
                    clientePersistente.setNombre(clienteNuevo.getNombre());
                    clientePersistente.setApellido(clienteNuevo.getApellido());
                    clientePersistente.setContrasenya(clienteNuevo.getContrasenya());
                    clientePersistente.setEmail(clienteNuevo.getEmail());
                    clientePersistente.setFecNac(clienteNuevo.getFecNac());
                    clientePersistente.setUsuario(clienteNuevo.getUsuario());
                    funciona = true;
                    // Actualiza otros campos según corresponda
                } else {
                    // Manejar el caso en el que no se encuentra el cliente antiguo en la base de datos
                    System.err.println("No se encontró el cliente antiguo en la base de datos.");
                }
                
                transaction.commit();
            } catch (Exception ex) {
                // Manejar la excepción
                System.err.println("* Exception executing a query: " + ex.getMessage());
                if (transaction.isActive()) {
                    transaction.rollback();
                }
            } finally {
                persistentManager.close();
            }
    
        } catch (Exception ex) {
            // Manejar la excepción
            System.err.println("* Exception: " + ex.getMessage());
        }
        return funciona;
    }
    

    public void setCliente(Cliente a){
        
        try {
            
            PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();
            

            try {
                transaction.begin();
                persistentManager.makePersistent(a);
                System.out.println("Cliente insertado: "+a.getNombre());
                transaction.commit();
            } catch (Exception ex) {
                // TODO: handle exception
                System.err.println("Exception inserting data into db: " + ex.getMessage());
            }finally{
                if(transaction.isActive()){
                    transaction.rollback();
                }
                persistentManager.close();
            }

        } catch (Exception ex) {
            // TODO: handle exception
            System.err.println("* Exception: " + ex.getMessage());
        }
    }
}

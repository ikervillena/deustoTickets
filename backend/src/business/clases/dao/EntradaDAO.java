package business.clases.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import business.clases.*;

public class EntradaDAO {

    public ArrayList<Entrada> getEntrada(){
        ArrayList<Entrada> entradas = new ArrayList<>();
        try{
            PersistenceManager persistentManager = FactoryDAO.getPersistenceManager();
			Transaction transaction = persistentManager.currentTransaction();

            try {
                transaction.begin();

                @SuppressWarnings("unchecked")
                Query<Entrada> entradasQuery = persistentManager.newQuery("SELECT FROM " + Entrada.class.getName());
                for (Entrada entrada : entradasQuery.executeList()){
                    entradas.add(entrada);
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
        return entradas;
    }

    public void setEntrada(Entrada a){
        try {
            PersistenceManager persistentManager = FactoryDAO.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();

            try {
                transaction.begin();
                persistentManager.makePersistent(a);
                System.out.println("Entrada insertada: "+a.getNombre());
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

    public boolean utilizarEntrada(Entrada e){
        boolean funciona = false;
        try {
            PersistenceManager persistentManager = FactoryDAO.getPersistenceManager();
            Transaction transaction = persistentManager.currentTransaction();
    
            try {
                transaction.begin();
    
                // Buscar la entrada por su clave primaria (qr)
                Query<Entrada> query = persistentManager.newQuery(Entrada.class);
                query.setFilter("qr == qrParam");
                query.declareParameters("String qrParam");
                List<Entrada> resultados = (List<Entrada>) query.execute(e.getQr());
    
                if (resultados.size() == 1) {
                    Entrada entrada = resultados.get(0);
    
                    // Actualizar el campo "utilizada" a true
                    entrada.setUtilizada(true);
                    funciona = true;
                } else {
                    // Manejar el caso en el que no se encuentra la entrada en la base de datos
                    System.err.println("No se encontró la entrada en la base de datos.");
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
}

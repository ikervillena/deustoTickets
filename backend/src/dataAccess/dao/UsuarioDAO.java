package dataAccess.dao;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import business.clases.*;

public class UsuarioDAO {
    
    public ArrayList<Usuario> getUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try{
            PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
			Transaction transaction = persistentManager.currentTransaction();

            try {
                transaction.begin();

                @SuppressWarnings("unchecked")
                Query<Usuario> usuariosQuery = persistentManager.newQuery("SELECT * FROM usuario");

                for (Usuario usuario : usuariosQuery.executeList()){
                    usuarios.add(usuario);
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
        return usuarios;
    }

    public void setUsuario(Usuario a){
        try {
            PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();

            try {
                transaction.begin();
                persistentManager.makePersistent(a);
                System.out.println("Usuario insertado: "+a.getNombre());
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

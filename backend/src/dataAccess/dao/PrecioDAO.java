package dataAccess.dao;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import business.clases.*;

public class PrecioDAO {

    public ArrayList<Precio> getPrecios(){
        ArrayList<Precio> precios = new ArrayList<>();
        try{
            PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
			Transaction transaction = persistentManager.currentTransaction();

            try {
                transaction.begin();

                @SuppressWarnings("unchecked")
                Query<Precio> preciosQuery = persistentManager.newQuery("SELECT FROM " + Precio.class.getName());

                for (Precio precio : preciosQuery.executeList()){
                    precios.add(precio);
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
        return precios;
    }

    public void setPrecio(Precio a){
        try {
            PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();

            try {
                transaction.begin();
                persistentManager.makePersistent(a);
                System.out.println("Precio insertado: "+a.getNombre());
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

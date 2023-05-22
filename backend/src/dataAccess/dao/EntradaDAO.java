package dataAccess.dao;

import java.util.ArrayList;

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
            PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
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
            PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
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
}
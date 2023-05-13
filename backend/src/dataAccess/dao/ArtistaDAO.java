package dataAccess.dao;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import business.clases.*;

public class ArtistaDAO {

    public ArrayList<Artista> getArtistas(){
        ArrayList<Artista> artistas = new ArrayList<>();
        try{
            PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
			Transaction transaction = persistentManager.currentTransaction();

            try {
                transaction.begin();

                @SuppressWarnings("unchecked")
                Query<Artista> artistasQuery = persistentManager.newQuery("SELECT FROM " + Artista.class.getName());

                for (Artista artista : artistasQuery.executeList()){
                    artistas.add(artista);
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
        return artistas;
    }

    public void setArtista(Artista a){
        try {
            PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();

            try {
                transaction.begin();
                persistentManager.makePersistent(a);
                System.out.println("Artista insertado: "+a.getNombre());
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
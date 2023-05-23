package business.clases.dao;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import javax.jdo.Transaction;

import business.clases.Staff;

public class StaffDAO {

    public ArrayList<Staff> getStaff(){
        ArrayList<Staff> listaStaff = new ArrayList<>();
        try{
            PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
            Transaction transaction = persistentManager.currentTransaction();
    
            try {
                transaction.begin();
    
                @SuppressWarnings("unchecked")
                Query<Staff> staffQuery = persistentManager.newQuery("SELECT FROM " + Staff.class.getName());
    
                for (Staff s : staffQuery.executeList()){
                    listaStaff.add(s);
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
        return listaStaff;
    }

}
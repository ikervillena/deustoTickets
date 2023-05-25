package business.clases.dao;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.JDOHelper;

public class FactoryDAO {
    
    public static PersistenceManager getPersistenceManager() throws Exception{
        PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
        return persistentManager;
    }

}

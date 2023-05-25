package dataAccess.rmi.client;

import dataAccess.rmi.server.IRemoteFacadeStaff;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// Esta clase implementa el patron de diseño "Service Locator"
// Tambien implementa el patron de diseño "Singleton", por medio de "Eager Initialization"
public class ServiceLocator {

    //Referencia a Remote Facade
    private IRemoteFacadeStaff service;
    private static final ServiceLocator INSTANCE = new ServiceLocator();

    private ServiceLocator() {}

    public static ServiceLocator getInstance() {
        return INSTANCE;
    }

    public void setService(String ip, String port, String serviceName) {
        //Activate Security Manager. It is needed for RMI.
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        //Get Remote Facade reference using RMIRegistry (IP + Port) and the service name.
        try {
            String URL = "//" + ip + ":" + port + "/" + serviceName;

            Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(port))));
            //stubServer = (IServer) java.rmi.Naming.lookup(name);
            this.service = (IRemoteFacadeStaff) registry.lookup(URL);

        } catch (Exception ex) {
            System.err.println("# Error locating remote facade: " + ex);
        }
    }

    public IRemoteFacadeStaff getService() {
        return this.service;
    }

}

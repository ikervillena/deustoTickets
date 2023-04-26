package dataAccess.rmi.client;

import dataAccess.rmi.server.IRemoteFacadeStaff;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//Esta clase implementa el patron de diseño "Service Locator"
public class ServiceLocator {

    //Referencia a Remote Facade
    private IRemoteFacadeStaff service;

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
            System.out.println("* Message coming from the server: '" + service.sayHello() + "'");

        } catch (Exception ex) {
            System.err.println("# Error locating remote facade: " + ex);
        }
    }

    public IRemoteFacadeStaff getService() {
        return this.service;
    }

}

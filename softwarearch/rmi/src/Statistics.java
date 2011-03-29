import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.Vector;

public interface Statistics extends Remote {
    public Double getAverage( Vector numbers ) throws java.rmi.RemoteException;
}

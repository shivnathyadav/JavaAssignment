package Assignment3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class PingTest{

    public ArrayList<Long> timeTaken = new ArrayList<Long>();

    public void pingTime (String ipAddress) throws UnknownHostException {
        long start = System.nanoTime();
        InetAddress ping = InetAddress.getByName(ipAddress);
        long stop = System.nanoTime();
        long time = (stop - start);
        timeTaken.add(time);
    }

    public void getTimes(int n){
        Scanner scan = new Scanner(System.in);
        String[] ip = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter an IP address : ");
            ip[i] = scan.next();
            try {
                pingTime(ip[i]);
            }
            catch (UnknownHostException e){
                System.out.println("Enter valid IP address!");
            }
        }
    }
    //Driver code
    public static void main (String[] args) {
        PingTest a3 = new PingTest();
        a3.getTimes(5);
        Collections.sort(a3.timeTaken);
        long medianTime = a3.timeTaken.get(a3.timeTaken.size()/2);
        System.out.println(a3.timeTaken);
        System.out.println(medianTime);
    }

}

/* Ping any host and calculate median Time for Pinging */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.Collections;

public class Ping {
    public static float findMedianPingTime(String command,int pingCount)  {
        ArrayList<Float> times=new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));

            String line = null;
            int flag = 1;
            while ((line = input.readLine()) != null && pingCount-- >= 0) {
                if (line.contains("time=")) {
                    int index = line.indexOf("time=");
                    String timeInMs = line.substring(index + 5);
                    float time=Float.parseFloat(timeInMs.substring(0,timeInMs.length()-3));
                    times.add(time);
                }
            }
        }
        catch (Exception e){
            System.out.println("exception caught");
            e.printStackTrace();
        }
        Collections.sort(times);
        if(times.size()>0){
            if((times.size() & 1 )==1)
                return times.get((times.size()/2)+1);
            else
                return times.get(((times.size()/2)+(times.size()/2)+1)/2);
        }
        return (float)0.00;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int pingCount=5;
        System.out.print("Enter url/ipaddress to Ping : ");
        String UrlorIp=sc.next();
        System.out.println(findMedianPingTime("ping -c "+pingCount+" "+UrlorIp,pingCount));
    }
}


import java.io.File;
import java.util.*;
import edu.duke.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    public void testLogAnalyzer() {
        LogAnalyzer analyzer=new LogAnalyzer();
        analyzer.readFile("/home/zadmin/Downloads/LogEntry/short-test_log");
        analyzer.printAll();
    }
    public void testUniqueIp(){
        LogAnalyzer analyzer=new LogAnalyzer();
        analyzer.readFile("/home/zadmin/Downloads/LogEntry/short-test_log");
        System.out.println("There are "+analyzer.countUniqueIPs()+" Unique Ip's");
        System.out.println("Unique Ip visits on a day for Sep 30 are "+analyzer.uniqueIPVisitsOnDay("Sep 30"));
        System.out.println("Count of Ips in Range of 200 and 300 are "+analyzer.countUniqueIPsInRange(200,300));

    }
}
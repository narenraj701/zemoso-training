
import edu.duke.*;

import java.util.ArrayList;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        records = new ArrayList<>();
    }

    public void readFile(String filename) {
        FileResource fr = new FileResource(filename);
        for (String line : fr.lines()) {
            LogEntry temp = WebLogParser.parseEntry(line);
            records.add(temp);
        }
    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }

    public int countUniqueIPs() {
        ArrayList<String> uniqueIps = new ArrayList<>();
        for (LogEntry le : records) {
            if (!uniqueIps.contains(le.getIpAddress()))
                uniqueIps.add(le.getIpAddress());
        }
        return uniqueIps.size();
    }

    public int uniqueIPVisitsOnDay(String date) {
        int count = 0;
        for (LogEntry le : records) {
            int index = le.getAccessTime().toString().indexOf(date);
            if (index != -1)
                count++;
        }
        return count;
    }

    public int countUniqueIPsInRange(int start, int end) {
        int count = 0;
        for (LogEntry le : records) {
            if (le.getStatusCode() >= start && le.getStatusCode() <= end)
                count++;
        }
        return count;
    }
}

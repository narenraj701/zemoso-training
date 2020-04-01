
/*Java Code to Parse a CSV File*/
import edu.duke.*;
import org.apache.commons.csv.*;

public class csvParse{
    public void readFood() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record : parser){
            System.out.print(record.get("Name") + " ");
            System.out.print(record.get("Favorite Color") + " ");
            System.out.println(record.get("Favorite Food"));
        }
    }

    public static void main(String[] args) {
        csvParse obj=new csvParse();
        obj.readFood();
    }
}


/**
 * Reads a chosen CSV file of country exports and prints each country that exports coffee.
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class whichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfInterest) {
        //for each row in the CSV File
        for (CSVRecord record : parser) {
	//Look at the "Exports" column
            String exports = record.get("Exports");
	//Check if it contains exportOfInterest            
	if (exports.contains("gold") ) {
                String country = record.get("Country");
		//If so, write down the "Country" from that row
                System.out.println(country);
            }

        }
    }

    public void whoExportsCoffee() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
    }

    public static void main(String[] args) {
        whichCountriesExport obj=new whichCountriesExport();
        obj.whoExportsCoffee();
    }
}

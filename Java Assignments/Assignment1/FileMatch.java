/* input-regular expression
   output-Absolute path of FileNames that matches regular Expressions are printed */
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileMatch {
    public  static void getFileNames(String pattern,File f){
        if(f.isDirectory()){
            File files[]=f.listFiles();
            for(File file:files){
                if(file.isDirectory())
                    getFileNames(pattern,file);
                else {
                    if (file.getName().matches(pattern))
                        System.out.println("Files Absolute Path is " + file.getAbsolutePath());
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        File dir=new File("/home");
        while(1==1){
            System.out.print("Enter a Regular expression to search: ");
            String pattern=sc.next();
            getFileNames(pattern,dir);
        }
    }
}


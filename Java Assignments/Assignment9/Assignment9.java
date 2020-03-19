/*String and Type Information

Using the documentation for java.util.regex.Pattern as a resource, 
write and test a regular expression that checks a sentence to see that it begins
 with a capital letter and ends with a period. */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment9 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String s=scanner.nextLine();
		String regex="^[A-Z].*[.]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher=pattern.matcher(s);
		if(matcher.matches())
			System.out.println("Sentence starts with Capital letter and ends with '.'");
		else
			System.out.println("Sentence does not start with Capital letter or ends with '.'");
		

	}

}


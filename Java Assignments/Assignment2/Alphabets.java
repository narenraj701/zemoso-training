import java.util.Arrays;
import java.util.Scanner;
/* Time Complexity      -  in terms of big O -->O(len(input))
    Space complexity    -  in terms of big O -->O(26) or O(1)
 */
public class Alphabets {
    public static boolean checkAllAlphabets(String s) {
        boolean alphabets[] = new boolean[26];
        Arrays.fill(alphabets, false);
        for (int i = 0; i < s.length(); i++)
            alphabets[Character.toLowerCase(s.charAt(i)) - 'a'] = true;
        for (int i = 0; i < 26; i++)
            if (alphabets[i] == false)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter a String: ");
            String input = sc.next();
            if (checkAllAlphabets(input))
                System.out.println("All alphabets are present in the String");
            else
                System.out.println("All alphabets are not present in the String");
        }
    }
}


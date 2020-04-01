/* Given signupDate and Current Date print the allowable ranges for submission window  */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


class KYC
{
    public static int[] getDate(String str)
    {
        String [] s=new String[3];
        s=str.split("-");
        int arr[]=new int[3];
        arr[0]=Integer.parseInt(s[0]);
        arr[1]=Integer.parseInt(s[1]);
        arr[2]=Integer.parseInt(s[2]);

        return arr;
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        int t = Integer.parseInt(br.readLine());
        LocalDate c1;
        LocalDate c2;
        while(t>0)
        {
            t--;
            String input[] = br.readLine().split(" ");

            int SignupDate[] = getDate(input[0]);
            int CurrentDate[] = getDate(input[1]);
            try {
                c1 = LocalDate.of(SignupDate[2], SignupDate[1], SignupDate[0]);

                c2 = LocalDate.of(CurrentDate[2], CurrentDate[1], CurrentDate[0]);
            }
            catch (Exception e){
                System.out.println("Invalid Input ");
                continue;
            }
            if(c1.isAfter(c2))
            {
                System.out.println("No ranges");
                continue;
            }

            c1 = LocalDate.of( CurrentDate[2], SignupDate[1],SignupDate[0]);
            LocalDate currDate = c2;

            c1=c1.minusDays(30);
            System.out.print(formatter.format(c1));

            c1=c1.plusDays(60);
            if(c1.isAfter(currDate))
                System.out.println(" "+formatter.format(currDate));
            else
                System.out.println(" "+formatter.format(c1));
        }
    }

}


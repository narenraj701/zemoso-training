/* Given signupDate and Current Date print the allowable ranges for submission window  */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class KYC
{
   
    public static void setDate(Calendar c,int date,int month,int year)
    {
        c.set(Calendar.DATE,date);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.YEAR,year);
    }

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
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int t = Integer.parseInt(br.readLine());
        while(t>=0)
        {
            String input[] = br.readLine().split(" ");

            int SignupDate[] = getDate(input[0]);
            int CurrentDate[] = getDate(input[1]);

            Calendar c1 = Calendar.getInstance();
            setDate(c1, SignupDate[0], SignupDate[1]-1, SignupDate[2]);

            Calendar c2 = Calendar.getInstance();
            setDate(c2,CurrentDate[0],CurrentDate[1]-1,CurrentDate[2]);
            
            if(c1.getTime().after(c2.getTime()))
            {
                System.out.println("No ranges");
                continue;
            }

            c1.set(Calendar.YEAR, CurrentDate[2]);
            Date currDate = c2.getTime();

            c1.add(Calendar.DATE,-30);
            System.out.print(df.format(c1.getTime()));

            c1.add(Calendar.DATE,60);
            if(c1.getTime().after(currDate))
                System.out.println(" "+df.format(currDate));
            else
                System.out.println(" "+df.format(c1.getTime()));
        }
    }

}

package Assignment4;

import java.util.*;
import java.text.*;
class RangeOfKyc{
    public static void main(String args[])throws ParseException {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        Calendar myCal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sc.nextLine();
        while(tests-->0) {
            String dt[] = sc.nextLine().split(" ");

            Date aniversary = sdf.parse(dt[0]);

            Date today = sdf.parse(dt[1]); //For extracting Current year from present date

            myCal.setTime(today);

            int presentYear = myCal.get(Calendar.YEAR); //For setting the calendar object to point to the aniversary in the current year

            myCal.setTime(aniversary);

            myCal.set(Calendar.YEAR,presentYear);

            Date presentAniversary = myCal.getTime(); //Calculating the maximum possible date for KYC

            myCal.add(Calendar.DATE,30);

            Date maxDate = myCal.getTime(); //Calulating the minimum possible date for KYC

            myCal.add(Calendar.DATE,-60);//Date at this point is 30 days ahead, so bringing it 60 days back would mean 30 days before the actual aniversary

            Date minDate = myCal.getTime();

            if(today.compareTo(minDate)<=0) {//Check if a range is obtainable from today
                System.out.println("No range");
            }
            else {
                System.out.println(sdf.format(minDate) + " " + (today.compareTo(maxDate) > 0 ? sdf.format(maxDate) : sdf.format(today))); // backtrace date if needed
            }
        }
    }
}
import java.util.Scanner;
class LeapYear{
public static void main(String []args)
{
 Scanner sc=new Scanner(System.in);
 System.out.print("Enter the year : ");
 int y=sc.nextInt();
 if(y%400==0)
 {
  System.out.println("It is a Leap Year");
 }
 else if(y%100==0)
 {
  System.out.println("It is not a Leap Year");
 }
 else if(y%4==0)
 {
  System.out.println("It is a Leap Year");
 }
 else
 {
  System.out.println("It is not a Leap Year");
 }
 
}
}
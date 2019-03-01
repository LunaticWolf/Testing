import java.util.Scanner;
class Bonus1{
public static void main(String []args)
{
 Scanner sc=new Scanner(System.in);
 System.out.print("Enter Employee id : ");
 int num1=sc.nextInt();
 System.out.print("Enter experience : ");
 int experience=sc.nextInt();
 System.out.print("Enter Salary : ");
 double sal=sc.nextInt();
 double bonus=0;
 if(experience>3)
 {
  bonus=sal*(150.0f/100);
 }
  System.out.println("Bonus of "+num1+" is "+bonus);
 
}
}
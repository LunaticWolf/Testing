import java.util.Scanner;
class Bonus{
public static void main(String []args)
{
 Scanner sc=new Scanner(System.in);
 System.out.print("Enter Employee id : ");
 int num1=sc.nextInt();
 System.out.print("Enter Salary : ");
 float num2=sc.nextInt();
 double bonus=0.72*num2;
 System.out.println("Bonus of "+num1+" is "+bonus);
}
}
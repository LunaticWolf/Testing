import java.util.Scanner;
class Add{
public static void main(String []args)
{
 Scanner sc=new Scanner(System.in);
 System.out.print("Enter first number : ");
 int num1=sc.nextInt();
 System.out.print("Enter second number : ");
 int num2=sc.nextInt();
 int sum=num1+num2;
 System.out.println("Addition of "+num1+" "+num2+" is "+sum);
}
}
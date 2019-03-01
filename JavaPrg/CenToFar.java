import java.util.Scanner;
class CenToFar{
public static void main(String []args)
{
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter the temperature in Centigrade");
 float t=sc.nextFloat();
 float far=(t*(9/5))+32; 
 System.out.println("Temperature in Fahrenheit is "+far);
}
}
 
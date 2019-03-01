import java.util.Scanner;
class Amstrong{
public static void main(String []args)
{
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter the number");
 int num=sc.nextInt();
 int temp=num;
 int a1=num%10;
 num=num/10;
 int a2=num%10;
 num=num/10;
 int a3=num%10;
 int s=(a1*a1*a1)+(a2*a2*a2)+(a3*a3*a3);
 if(temp==s)
 {
   System.out.println("The number is amstrong");
 }
 else
 {
  System.out.println("The number is not amstrong");
 }
}
}


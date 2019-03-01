import java.util.Scanner;
class Demo1{
public static void main(String []args)
{
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter yes or no");
 String choice=sc.next();
 switch(choice)
 {
  case "yes" :
  case "YES" : System.out.println("Your choice is correct");
               break;
  case "no"  : 
  case "NO"  : System.out.println("Your choice is incorrect");
               break;
  default    : System.out.println("Invalid choice");
    }
}
}          

 
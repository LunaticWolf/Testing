import java.util.Scanner;
class Max
{
  public static void main(String []args)
 {
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter the value of n");
   int n=sc.nextInt();
   int[] arr=new int[n];
   for(int i=0;i<n;i++)
   {
    System.out.println("Enter arr["+i+"]:");
    arr[i]=sc.nextInt();
   }
   int max=arr[0];
   for(int i=0;i<arr.length;i++)
   { 
     
     if(arr[i]>max)
     {
       max=arr[i];
     }
   }
   System.out.println("Maximum element is "+max);
 }
}
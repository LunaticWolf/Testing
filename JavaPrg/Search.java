import java.util.Scanner;
class Search
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
   System.out.println("Enter element to be searched");
   int k=sc.nextInt();
   int flag=0;
    int p=0;
   for(int i=0;i<arr.length;i++)
   {
    if(k==arr[i])
    {
      flag=1;
      p=i;
      break;
    }
  }
if(flag==1)
{
 System.out.println("Element Found at Position "+p);
}
else if(flag==0)
{
  System.out.println("Element Not Found");
}
}
}
 
   
   
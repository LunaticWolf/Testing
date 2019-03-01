import java,util.scanner;
class LinearSearch
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
   for(int i=0;i<n;i++)
   {
    if(k==arr[i])
    {
      flag=1;
      int p=i;
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
 
   
   
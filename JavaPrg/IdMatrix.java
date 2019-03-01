import java.util.Scanner;
class IdMatrix
{
 public static void main(String []args)
{
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter the number of rows");
 int r=sc.nextInt();
 System.out.println("Enter the number of columns");
 int c=sc.nextInt();
 int c1=0;
 int c2=0;
 int arr[][]=new int[r][c];
  System.out.println("Enter elements");
  for(int i=0;i<r;i++)
  {
   for(int j=0;j<c;j++)
   {
     arr[i][j]=sc.nextInt();
    }
   }
   if(r==c)
  {
   for(int i=0;i<r;i++)
  {
   for(int j=0;j<c;j++)
   {
    
     if(i==j)
     {
       if(arr[i][j]==1)
       { 
         c1++;
       }
      }
     if(i!=j)
     {
       if(arr[i][j]==0)
       { 
         c2++;
       }
      }
    }
   }
  } 
 if((c1==r)&&(c2==(r*c)-c))
 {
   System.out.println("Yes");
 }
 else
 {
   System.out.println("No");
 }
}
}  
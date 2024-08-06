import java.util.Scanner;
public class arrayAll{
	
	//display the array
  public static void display(int MyFirstArray[]){
	  for(int i=0;i<MyFirstArray.length;i++){
		  System.out.print(MyFirstArray[i]+" ");
	  }
  }
  
     //check number
  public static int binarySearch(int arr[],int l,int h,int x){
	  	if(l<=h)
		{
			int mid=l+(h-l)/2;
			if(arr[mid]==x)
			{
				return mid;
			}
			if(arr[mid]<x)
			{
				return binarySearch(arr,mid+1,arr.length,x);
			}
			if(arr[mid]>x)
			{
				return binarySearch(arr,l,mid-1,x);
			}
		}
		return -1;
  }
  
  // insertion sort
  
  public static void insert(int arr[]){
	  for(int i=1;i<arr.length;i++){
		  for(int j=i;j<arr.length;j++){
			  if(arr[j]<arr[j-1]){
				  int temp=arr[j];
				  arr[j]=arr[j-1];
				  arr[j-1]=temp;
			  }
			  else
				  break;
		  }
	  }
  }
	
	
	
	//insert sort decending order
	public static void insertDesc(int arr[]){
		for(int i=1;i<arr.length;i++){
			for(int j=i;j<arr.length;j++){
				if(arr[j-1]<arr[j]){
					int temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
				else{
					break;
				}
			}
		}
	}
	//reverse the array
	public static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            // Swap the elements at start and end
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            // Move the pointers towards the center
            start++;
            end--;
        }
    }

	
	public static void main(String[] args){
	  Scanner sc=new Scanner(System.in);
      
	  System.out.println("enter the elements of the array");
	  int arr[]=new int[4];
	  
	  for(int i=0;i<arr.length;i++){
		  arr[i]=sc.nextInt();
	  }
	  display(arr);
	   arrayAll ob=new arrayAll();
	   
	   System.out.println("enter the number to find");
	   int y=sc.nextInt();
	  int result=ob.binarySearch(arr,0,arr.length,y);
	  
	  if(result==-1)
	  {
		  System.out.println(y+" is NOT present is in the array");
	  }
	  else{
		  System.out.println(y+" is present is in the array");
	  }
	  
      System.out.println();
System.out.println("sorted array below");
insert(arr);
display(arr);	 
       
      	   System.out.println();
		   System.out.println();
		   insertDesc(arr);
		   display(arr);
		   
		   reverseArray(arr);
		   display(arr);
	}
}
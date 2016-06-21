import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SXI140530MergeSortImpl3 {
	
	public static int x;
	public static int m=10;
	
	//This is the MergeSort function
	static int MergeSort(int A[],int B[],int p,int r) {
		// TODO Auto-generated constructor stub
		int q,h1=0,h2;
		if (p < r){
			if(r-p > m){
			q= (p+r)/2;
			h1 = MergeSort(A,B,p,q);
			h2 = MergeSort(A,B,q+1,r);
			/*if (h1!= h2){
				System.out.println("Please enter the number of elements as a power of 2 for sorting.");
				System.exit(1);
			}*/
			
			if (h1%2 == 1)
				Merge(B,A,p,q,r);
			else
				Merge(A,B,p,q,r);
			
			return h1+1;	
		}
			 else {  
				 // Insertion sort
				 if(h1%2==0){
		    		for(int i=p, j=i; i<r; j=++i) {
		    		    int ai = A[i+1];
		    		    while(ai < A[j]) {
		    			A[j+1] = A[j];
		    			if (j-- == p) {
		    			    break;
		    			}
		    		    }
		    		    A[j+1] = ai;
		    		}
		    	
		        }
				 else{
					 for(int i=p, j=i; i<r; j=++i) {
			    		    int ai = B[i+1];
			    		    while(ai < B[j]) {
			    			B[j+1] = B[j];
			    			if (j-- == p) {
			    			    break;
			    			}
			    		    }
			    		    B[j+1] = ai;
			    		}
					 
				 }
				 return h1;
			 }
				 
		}
		else return 0;
	}
	
	//Merge Function
	public static void Merge(int src[], int dest[], int p, int q, int r){
		int i=p,j=q+1;
		for (int k=p; k <= r; k++){
			if ((j>r) || (i<=q && src[i] <= src[j]))
				dest[k] = src[i++];
			else
				dest[k] = src[j++];
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter No of elements");
		   //Random r=new Random();
		int i,j;
		int n=Integer.parseInt(br.readLine());
		
		long starttime = System.currentTimeMillis();
		
		int a[]=new int [n];
		int temp[]=new int[n];
		
		for(i=0;i<n;i++){
		   a[i] = (n-i);
				   //r.nextInt(Integer.MAX_VALUE); 
		}
		
		//determine m such that it works for all powers of 2.
		
		x=n;
		while(x>m+1)
		{
			x=x/2;
		}
		if(x==m+1)
			m++;
		   
		//sorting using merge sort
		   
		int ret = MergeSort(a,temp,0,n-1);
		
		for(i=0;i<n;i++)
		{
			if (a[i]==0){
				System.out.print(i+" ");
				break;
			}
		}
		if (ret%2==0){
			for(j=0;j<n-1;j++)
				if(a[j]>a[j+1]){
					System.out.println("Sorting failed at " + j);
					System.exit(1);
				}
		}
		else{
			for (j=0;j<n-1;j++)
				if(temp[j]>temp[j+1]){
					System.out.println("Sorting failed at " + j);
					System.exit(1);
				}
		}
		
		
		   
		System.out.println("Sorting successful.");
		   
		long endtime = System.currentTimeMillis();
		System.out.println("Time Taken in milliseconds:" + (endtime-starttime));
	}
}

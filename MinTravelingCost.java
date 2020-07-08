import java.util.Arrays;
import java.util.Scanner;

public class MinTravelingCost {

	static long findMinCost(long price[],int n)
	{
		//Arranging Villagers in order of increment of cost
		Arrays.sort(price);
		long total = 0;
		//Getting Minimum price of second last most costly person
		for(int i = n-1; i>1; i = i-2) {
			if(i == 2) {
				total = total + (price[2] + price[0]);
			}
			//Getting prices by sailing by both the first and second 
			//least costing person and selecting minimum of them
			else {
				long first_price = price[i] + price[0] + 2 * price[1];
				long second_price = price[i] + price[i - 1] + 2 * price[0];
				total = total + (Math.min(first_price, second_price));
			}
		}
		//Checking if there only one person is remained, then adding his cost
		//otherwise adding the least costing person
		if (n==1) {
			total = total + price[0];
		}
		else {
			total = total + price[1];
		}
		
		return total;
	}
	public static void main(String[] args) {
		
		int t;
		Scanner sc =  new Scanner(System.in);
		t = sc.nextInt();
	    
		while(t-- > 0) {
			int n = sc.nextInt();
			long a[] = new long[n];
			
			//getting costs of all villagers of sailing 
			for(int i=0 ; i<n; i++) {
				a[i]=sc.nextInt();
			}
			//calling the method findMinCost 
			System.out.println(findMinCost(a, n));
		}
	}
}

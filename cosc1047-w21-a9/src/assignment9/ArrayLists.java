package assignment9;
/*
@author Sahara Karima Mosin Rahimani
This program prompts the user to enter positive integers.
It only prompts the user once, and it accepts and stores them in an ArrayList 
until a negative number is entered.
With the ArrayList it performs the following tasks:

1. It prints the values, sum, average, min, max, 
and range of the integers in the ArrayList.

2. It prompts the user and ask if they want to replace any values in the ArrayList.
If they do, it collects the number they want to replace and It also asks by which number 
it should be replaced, and then it replaces all occurrences of the previous value 
with the new value, while keeping the order of the numbers in the ArrayList and 
prints the number of values replaced. 

3. It prompts the user and ask if they want to delete a specific element from the
ArrayList. If they do, it prompts the user for an index. If the index is valid,
it will delete the value at that index. 

4. If any changes were made to the data in tasks 2. or 3.
it will re-print the values in the array, the sum, average,
min, max, and range.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayLists {
	public static void main(String[] args) {
		
		int sum=0;
		double avg=0;
		int range=0;
		int max=0;
		int min=0;
		int replace=0;
		int countReplaced=0;
		int delete=0;
		String answerRep="";
		String answerDel="";
		ArrayList<Integer> numbers=new ArrayList<>();

		Scanner keyboard=new Scanner(System.in);

		System.out.println("Please enter positive integers:");
		int input=keyboard.nextInt();
		while(input>=0) {
			numbers.add(input);
			input =keyboard.nextInt();
		}

		System.out.println(numbers);
		
		max=numbers.get(0);
		min=numbers.get(0);

		for (int i = 0; i < numbers.size(); i++) {
			sum=sum+numbers.get(i);

			if(max<numbers.get(i)) {

				max=numbers.get(i);

			}if(min>numbers.get(i)) {

				min=numbers.get(i);

			}
		} 

		avg=(double)sum/numbers.size();
		range=max-min;

		System.out.println("Sum:"+sum);
		System.out.println("avg:"+avg);
		System.out.println("range:"+range);
		System.out.println("max:"+max);
		System.out.println("min:"+min);
		keyboard.nextLine();

		System.out.println("do you want to replace any values in the ArrayList?");
		answerRep=keyboard.nextLine();

		if(answerRep.equals("yes")) {

			System.out.println("which one?");
			replace=keyboard.nextInt();

			System.out.println("by what?");
			int by=keyboard.nextInt();

			for(int i=0;i<numbers.size();i++) {

				if(numbers.get(i)==replace) {

					countReplaced++;
					numbers.set(i,by);
				}
			}
		}

		System.out.println("Number of replaced numbers: "+countReplaced);
		keyboard.nextLine();

		System.out.println("do you want to delete any specific data points from the ArrayList.");
		answerDel=keyboard.nextLine();

		if(answerDel.equals("yes")) {
			System.out.println("Enter an Index:");
			delete=keyboard.nextInt();

			if(delete>=0 && delete<numbers.size()) {
				numbers.remove(delete);
			}else {
				System.out.println("Index not valid!");
			}

		}

		sum=0;
		max=numbers.get(0);
		min=numbers.get(0);
		avg=0;
		range=0;

		if(answerRep.equals("yes") || answerDel.equals("yes")) {
			System.out.println(numbers);
			for (int i = 0; i < numbers.size(); i++) {

				sum=sum+numbers.get(i);
				if(max<numbers.get(i)) {
					max=numbers.get(i);
				}if(min>numbers.get(i)) {
					min=numbers.get(i);
				}
			} 
			avg=(double)sum/numbers.size();
			range=max-min;
			System.out.println("Sum:"+sum);
			System.out.println("avg:"+avg);
			System.out.println("range:"+range);
			System.out.println("max:"+max);
			System.out.println("min:"+min);
		}
		keyboard.close();
	}
}


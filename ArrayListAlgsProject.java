
import java.util.ArrayList;

/**
 * This class is a submission to the Array Algs to ArrayList Algs Project.
 * MILCS
 * @author Daniel B)
 */
public class ArrayListAlgsProject
{
	//3, 14, 159, 2, 65, 358, 9, 79, 323, 8, 46, 264, 3, 38, 327
	public static ArrayList<Integer> arrayList = generateRandomArrayList(100, 100, 0);
	
	public static long time = System.currentTimeMillis();
	
	/**
	 * The main method. Runs all the methods so you can check if they're working properly through the console.
	 * @param args
	 */
	public static void main(String args[])
	{
		
		ArrayList<Integer> copyArrayList = copyArrayList(arrayList);
		
		System.out.println("Original Array List: " + copyArrayList);
		/*
		//1. Return the smallest number in the array.
		System.out.println("1.");
		
		System.out.println(smallest(arrayList));
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//2. Return the index of the smallest number in the array.
		System.out.println("2.");
		
		System.out.println(indexOfSmallest(arrayList));
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//3. Return the average of all numbers in the array.
		System.out.println("3.");
		
		System.out.println(average(arrayList));
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//4. Return true if all numbers in the array are even, and return false otherwise.
		System.out.println("4.");
		
		System.out.println(allEven(arrayList));
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//5. If the array ever has two consecutive 5's, change them to 0's. 
		System.out.println("5.");
		
		copyArrayList = copyArrayList(arrayList);
		neighbor5to0(copyArrayList);
		System.out.println(arrayList);
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//6. Return true if any number shows up three times in a row, and return false otherwise. 
		System.out.println("6.");
		
		copyArrayList = new ArrayList<Integer>();
		copyArrayList.add(5);
		copyArrayList.add(3);
		copyArrayList.add(3);
		copyArrayList.add(5);
		System.out.println(threeInARow(copyArrayList));
		
		copyArrayList = new ArrayList<Integer>();
		copyArrayList.add(3);
		copyArrayList.add(3);
		copyArrayList.add(3);
		copyArrayList.add(5);
		System.out.println(threeInARow(copyArrayList));
		
		copyArrayList = new ArrayList<Integer>();
		copyArrayList.add(5);
		copyArrayList.add(3);
		copyArrayList.add(3);
		copyArrayList.add(3);
		System.out.println(threeInARow(copyArrayList));
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//7. Pass an array of ints and an int to be searched for. Return how many times that int shows up in the array.
		System.out.println("7.");
		
		System.out.println(countOf(3, arrayList));
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//8. Alter an array so that is the backwards version of the array initially passed. 
		System.out.println("8.");
		
		copyArrayList = copyArrayList(arrayList);
		reverse(copyArrayList);
		System.out.println(copyArrayList);
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//9. Shift all elements in an array to the right.
		System.out.println("9.");
		
		copyArrayList = copyArrayList(arrayList);
		shift(copyArrayList);
		System.out.println(copyArrayList);
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		*/
		//10. Use either selection sort or insertion sort to sort an array. 
		System.out.println("10.");
		int[] stats;
		
		System.out.print("Selection Sort: ");
		copyArrayList = copyArrayList(arrayList);
		time = System.currentTimeMillis();
		stats = selectionSort(copyArrayList);
		System.out.println(copyArrayList);
		System.out.println("Time: " + (System.currentTimeMillis() - time) + "ms");
		System.out.println("Checks: " + stats[0]);
		System.out.println("Switches: " + stats[1]);
		
		System.out.print("Insertion Sort: ");
		copyArrayList = copyArrayList(arrayList);
		time = System.currentTimeMillis();
		stats = insertionSort(copyArrayList);
		System.out.println(copyArrayList);
		System.out.println("Time: " + (System.currentTimeMillis() - time) + "ms");
		System.out.println("Checks: " + stats[0]);
		System.out.println("Switches: " + stats[1]);
		
		System.out.print("Bubble Sort: ");
		copyArrayList = copyArrayList(arrayList);
		time = System.currentTimeMillis();
		stats = bubbleSort(copyArrayList);
		System.out.println(copyArrayList);
		System.out.println("Time: " + (System.currentTimeMillis() - time) + "ms");
		System.out.println("Checks: " + stats[0]);
		System.out.println("Switches: " + stats[1]);
		
		System.out.print("Merge Sort: ");
		copyArrayList = copyArrayList(arrayList);
		time = System.currentTimeMillis();
		stats = mergeSort(copyArrayList);
		System.out.println(copyArrayList);
		System.out.println("Time: " + (System.currentTimeMillis() - time) + "ms");
		System.out.println("Checks: " + stats[0]);
		System.out.println("Switches: " + stats[1]);
		
		System.out.print("Quick Sort: ");
		copyArrayList = copyArrayList(arrayList);
		time = System.currentTimeMillis();
		stats = quickSort(copyArrayList);
		System.out.println(copyArrayList);
		System.out.println("Time: " + (System.currentTimeMillis() - time) + "ms");
		System.out.println("Checks: " + stats[0]);
		System.out.println("Switches: " + stats[1]);
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		
		
		
	}

	/**
	 * 1. Return the smallest number in the ArrayList. 
	 */
	public static int smallest(ArrayList<Integer> arrayList)
	{
		
		//Set smallest to 0 for the case of a size of 0.
		int smallest = 0;
		
		//Length check.
		if (arrayList.size() > 0)
			smallest = arrayList.get(0);
		
		for (int number : arrayList)
			//Changes smallest to the current number if smallest is actually bigger.
			if (smallest > number)
				smallest = number;
		
		//Returns the smallest element of the array.
		return smallest;
		
	}

	/**
	 * 2. Return the index of the smallest number in the ArrayList. 
	 */
	public static int indexOfSmallest(ArrayList<Integer> arrayList)
	{
		
		//Length check.
		if (arrayList.size() > 0)
		{	
			
			//Initializes smallest as the first element in the array.
			int smallest = arrayList.get(0);
			//Initializes the index of the smallest element to the first index of the array.
			int index = 0;
			
			//Iterates through the array.
			for (int i = 1; i < arrayList.size(); i++)
			{
				
				//Changes smallest and index to the current number and its index respectively if the current number is smaller.
				if (arrayList.get(i) < smallest)
				{
					
					smallest = arrayList.get(i);
					index = i;
					
				}
				
			}
			
			//Returns the smallest number's index.
			return index;
			
		}
		
		//Returns -1 if there are no elements in the array.
		return -1;
		
	}
		
	/**
	 * 3. Return the average of all numbers in the ArrayList. 
	 */
	public static int average(ArrayList<Integer> arrayList)
	{
		
			//Initializes sum as zero.
			int sum = 0;
			
			//Iterates through each number in the array.
			for (int number : arrayList)	
				//Adds the current number to sum.
				sum += number;
			
			//Returns the sum of all the numbers in the array divided by the number of elements in the array.
			return sum / arrayList.size();
		
	}
	
	/**
	 * 4. Return true if all numbers in the ArrayList are even, and return false otherwise.
	 */
	public static boolean allEven(ArrayList<Integer> arrayList)
	{
		
		//Iterates through each number in the array.
		for (int number : arrayList)
			//Determines if the number is even by checking if it can be divided by 2 without a reminder. Returns false if the number is not even.
			if (number % 2 > 0)
				return false;
		
		//This part is reached only if all the numbers if have been determined to be true. Returns true, meaning all the numbers in the array are even.
		return true;
		
	}
	
	/**
	 * 5. If the ArrayList ever has two consecutive 5's, change them to 0's. 
	 * (For example, passing {4, 5, 5, 2, 1} changes the array to {4, 0, 0, 2, 1} ).
	 */
	public static void neighbor5to0(ArrayList<Integer> array)
	{
		
		//Iterates through the array, except for the last element.
		for (int i = 0; i < array.size() - 1; i++)
			//Checks if the current element and the element after it are both 5.
			if (array.get(i) == 5 && array.get(i + 1) == 5)
				//Turns both the current element and the element after it to 0 if they were both 5 beforehand.
				array.set(i, array.set(i + 1, 0) - 5);
		
		
	}
	
	/**
	 * 6. Return true if any number shows up three times in a row, and return false otherwise. 
	 * Maybe not the best way to do this method but it's kinda funny with a for each.
	 */
	public static boolean threeInARow(ArrayList<Integer> array)
	{
		
		//Length check.
		if (array.size() > 2)
		{
			
			//Keeps track of how many of the same number occured in a row.
			int count = 1;
			
			//Initializes the previous number as a number that is not the first element in the array.
			int previous = array.get(0) + 1;
			for (int number : array)
			{
						
				//Increments the count if the previous number is the same as the current number.
				if (previous == number)
					count++;
				//Otherwise resets the count back to 1.
				else
					count = 1;
				
				
				//Returns true if three of the same number ever occurs.
				if (count == 3)
					return true;
				
				//Sets the previous number to the current number.
				previous = number;
				
			}
			
		}
		
		//If no three-in=a-rows pop up, then this will return false.
		return false;
		
	}
		
	/**
	 * 7. Pass an ArrayList of ints and an int to be searched for. Return how many times that int shows up in the ArrayList. 
	 * (For example, passing ( {4, 5, 5, 2, 1} , 5) returns 2 because 5 shows up twice)
	 * I just realized I switched the order of the parameters. Oh well, it doesn't matter that much does it?
	 */
	public static int countOf(int searched, ArrayList<Integer> array)
	{
		
		//Keeps track of the number of times searched appears in the array.
		int count = 0;
		
		//Iterates through each number in the array.
		for (int number : array)
			//If the current number is the searched number, count is incremented.
			if (number == searched)
				count++;
		
		//Returns how many times the number searched for appeared in the array.
		return count;
		
	}
	
	/**
	 * 8. Alter an ArrayList so that is the backwards version of the ArrayList initially passed. 
	 * (For example, passing {4, 5, 5, 2, 1} changes the array to {1, 2, 5, 5, 4})
	 */
	public static void reverse(ArrayList<Integer> arrayList)
	{
		
		//Length check.
		if (arrayList.size() > 1)	
			//Mirrors the ArrayList, in a sense. Basically, the whole ArraList pivots around the last element.
			for (int i = arrayList.size() - 2; i >= 0; i--)
				arrayList.add(arrayList.remove(i));
		
	}
	
	/**
	 * 9. Shift all elements in an array to the right. 
	 * (For example, passing {4, 5, 5, 2, 1} changes the array to {1, 4, 5, 5, 2})
	 */
	public static void shift(ArrayList<Integer> arrayList)
	{
		
		//Beautiful.
		arrayList.add(0, arrayList.remove(arrayList.size() - 1));
		
	}
	
	/*
	 * 10. Use either selection sort or insertion sort to sort an array. 
	 * (For example, passing {4, 5, 5, 2, 1} changes the array to {1, 2, 4, 5, 5})
	 * Imma do both cause why not.
	 * I'll also do bubble, quick, and merge, cause why not.
	 * I'll also keep track of the iterations, cause I'm curious.
	 */
	
	/**
	 * Selection Sort. Starts at the first number, switches it with the minimum if it is not the minimum already, then moves on to the next and repeats.
	 * @param array - The array to be sorted.
	 * @return The number of checks and switches that occurred.
	 */
	public static int[] selectionSort(ArrayList<Integer> arrayList)
	{
		
		//Keeps track of how many comparisons and switches the algorithm made.
		int checks = 0;
		int switches = 0;
		
		//Iterates through each number except for the last one.
		for (int i = 0; i < arrayList.size() - 1; i++)
		{
				
			//Sets the default minimum and its index as the current iteration.
			int min = arrayList.get(i);
			int indexOfMin = i;
			
			//Increments checks.
			checks++;
			//Iterates through the rest of the numbers to find the true minimum. Increments checks after each iteration.
			for (int j = i + 1; j < arrayList.size(); j++, checks++)
			{
				
				//Sets min and indexOfMin to the current number and its index respectively if the current number is smaller than min.
				if (arrayList.get(j) < min)
				{
					
					min = arrayList.get(j);
					indexOfMin = j;
					
				}
				
			}
			
			//Checks if the min was not the original that was set.
			if (min != arrayList.get(i))
			{
				
				//Switches in the case that the initial minimum was not the true minimum.
				arrayList.set(i, arrayList.set(indexOfMin, arrayList.get(i)));
				
				//Increments switches.
				switches++;
				
			}
			
		}
		
		//Returns the number of checks and switches that occurred.
		return new int[] {checks, switches};
		
	}

	/**
	 * Insertion Sort. Goes to the first element out of place, and inserts it to the left where it is supposed to be.
	 * I thought this would be harder to implement than selection, but it was surprisingly simple. Just wish I could make it more efficient.
	 * @param array - The array to be sorted.
	 * @return Number of checks and switches that occurred. 
	 */
	public static int[] insertionSort(ArrayList<Integer> arrayList)
	{
		
		//Keeps track of how many comparisons and switches the algorithm made.
		int checks = 0;
		int switches = 0;
		
		//Iterates through each number except for the first one.
		for (int i = 1; i < arrayList.size(); i++)
		{
			
			//Increments checks.
			checks++;
			//Iterates backwards from index i until the current number no longer has to be moved backwards or the it reaches the beginning.
			for (int j = i; j > 0 && arrayList.get(j) < arrayList.get(j - 1); j--)
			{
				
				//Switches the element with the one before it.
				arrayList.set(j, arrayList.set(j - 1, arrayList.get(j)));
				
				//Increments checks and switches.
				checks++;
				switches++;
				
				
			}
			
		}
		
		//Returns the number of checks and switches that occurred.
		return new int[] {checks, switches};
		
	}
	
	/**
	 * Bubble Sort. Goes through the whole array, switching numbers that are next to each other, until the highest numbers "bubble" to the top.
	 * @param array - The array to be sorted.
	 * @return The number of checks and switches that occurred.
	 */
	public static int[] bubbleSort(ArrayList<Integer> array)
	{
		
		//Keeps track of how many comparisons and switches the algorithm made.
		int checks = 0;
		int switches = 0;
		
		//Sets the sorted boolean to false to makes sure that the while loop iterates at least once.
		boolean sorted = false;
		//Iterates until the array is sorted. (No switches occur through a whole iteration.
		while (!sorted)
		{
			 
			//Sets sorted to true until a switch occurs.
			sorted = true;
			
			//Increments checks.
			checks++;
			//Iterates through each number of the array except the first one.
			for (int i = 1; i < array.size(); i++, checks++)
			{
				 
				//Checks if the current number is less than the number before it.
				if (array.get(i) < array.get(i - 1))
				{
					
					//Swaps the current number and the one before it.
					array.set(i, array.set(i - 1, array.get(i)));
					
					//Increments switches.
					switches++;
					
					//Sets sorted to false so the while loop iterates again.
					sorted = false;
					 
				}
				 
			}
			 
		}
		
		//Returns the number of checks and switches that occurred.
		return new int[] {checks, switches};
		
	}
	
	/**
	 * Merge Sort. Splits up an ArrayList into groups of two, then merges those groups of two with each other, then those groups with each other, etc.
	 * Based on what I've heard from Keola and you, I should be doing quick sort first as it's easier, but I guess I just hate myself.
	 * Ok I almost got it like 3rd try after some bug fixing but why are there two 327's now and one less 3? You know what I'mma work with a shorter array first.
	 * Nevermind I just forgot to increment.
	 * Ok apparently you can't just implement insertion sort inside merge sort and expect it to be efficient so I looked up how merging works and now know to just compare the two arrays' first values.
	 * How do I even define a switch in this algorithm?
	 * @param array - The array to be sorted.
	 * @return The amount of checks and switches that occurred..
	 */
	public static int[] mergeSort(ArrayList<Integer> arrayList)
	{
		
		//Keeps track of how many comparisons and switches the algorithm made.
		int checks = 0;
		int switches = 0;
		
		//Creates a new ArrayList to split the original.
		ArrayList<Integer> split = new ArrayList<Integer>();
		
		while (split.size() < arrayList.size())
			split.add(0, arrayList.remove(arrayList.size() - 1));
		

		//Recursively mergeSorts until each the original holds at most 1 element.
		if (arrayList.size() > 1)
		{
			
			int[] stats = mergeSort(arrayList);
			
			//Adds the checks and switches of the recursive merge sorts to the main merge sort stats.
			checks += stats[0];
			switches += stats[1];
			
		}
		//Recursively mergeSorts until the split holds at most 1 element.
		if (split.size() > 1)
		{
			
			int[] stats = mergeSort(split);
			
			//Adds the checks and switches of the recursive merge sorts to the main merge sort stats.
			checks += stats[0];
			switches += stats[1];
			
		}
		
		//Keeps track of what index of the original we are looking at, starting with the initial.
		int index = 0;
		
		
		//This was pretty fun to think about in terms of ArrayLists. I ended up with this pretty cool cut down version for ArrayLists.
		
		
		//Iterates there are no more elements in the split.
		while (split.size() > 0)
		{
		
			//Checks if there are any elements of the original to check.
			if (index < arrayList.size())
			{
				
				//Increments checks.
				checks++;
				
				//Pops the split element back into the original at the index, then increments the index variable and switches variable.
				if (split.get(0) < arrayList.get(index))
				{
					
					arrayList.add(index++, split.remove(0));
					switches++;
					
				}
				//Otherwise just increments the index variable.
				else
					index++;
				
				
			}
			else
				/* Alternate solution.
				 * arrayList.addAll(split);
				 * split.removeAll();
				 */
				//Adds the rest of the split elements to the original.
				arrayList.add(split.remove(0));
			
		}
		
		//Returns the number of checks and switches that occurred.
		return new int[] {checks, switches};
		
	}

	/**
	 * Quick Sort. Picks a number (the pivot), sorts the rest into two sides that are less than or greater than that number, then recursively does that to the two sides.
	 * Wait why is this so much harder than merge sort.
	 * Nevermind it's just cause I counted the pivot when setting lesser and greater count instead of excluding it God that wasted so much time.
	 * @param array - The array to be sorted.
	 * @return The amount of checks and switches that occurred.
	 */
	public static int[] quickSort(ArrayList<Integer> arrayList)
	{
		
		//Keeps track of how many comparisons and switches the algorithm made.
		int checks = 0;
		int switches = 0;
		
		//Removes the pivot from the original.
		int pivot = arrayList.remove(0);
		
		//Creates an ArrayList that will store numbers less than the pivot.
		ArrayList<Integer> lesserArrayList = new ArrayList<Integer>();
		
		//Iterates through each element in the ArrayList, incrementing checks each iteration.
		for (int i = 0; i < arrayList.size(); i++, checks++)
		{
			
			//Increments switches and pops the current number to lesserArrayList if the number is less than the pivot.
			if (arrayList.get(i) < pivot)
			{
				
				lesserArrayList.add(arrayList.remove(i--));
				switches++;
			
			}
			
		}
		
		//Recursively quickSorts until each the lesserArrayList only holds at most 1 element.
		if (lesserArrayList.size() > 1)
		{
			
			int[] stats = quickSort(lesserArrayList);
			
			//Adds the checks and switches of the recursive quick sorts to the main quick sort stats.
			checks += stats[0];
			switches += stats[1];
			
		}
		//Recursively quickSorts until the original only holds at most 1 element.
		if (arrayList.size() > 1)
		{
			
			int[] stats = quickSort(arrayList);
			
			//Adds the checks and switches of the recursive quick sorts to the main quick sort stats.
			checks += stats[0];
			switches += stats[1];
			
		}
		
		//Fills in the missing pivot value.
		arrayList.add(0, pivot);
		
		
		/* Alternate solution.
		 * arrayList.addAll(0, lesserArrayList);
		 * lesserArrayList.removeAll();
		 */
		
		//Iterates through each number in lesserArrayList, popping each one back into the original.
		while (lesserArrayList.size() > 0)
			arrayList.add(0, lesserArrayList.remove(lesserArrayList.size() - 1));
		
		//Returns the number of checks and switches that occurred.
		return new int[] {checks, switches};
				
	}
	
	/**
	 * Method to make a copy of an int array easily.
	 * @param array - The array to be copied.
	 * @return A copy of the passed array.
	 */
	public static ArrayList<Integer> copyArrayList(ArrayList<Integer> arrayList)
	{
		
		ArrayList<Integer> copyArrayList= new ArrayList<Integer>(arrayList);
		
		//Returns the copy.
		return copyArrayList;
		
	}
	
	/**
	 * 
	 * @param elements
	 * @param range
	 * @param min
	 * @return
	 */
	public static ArrayList<Integer> generateRandomArrayList(int elements, int range, int min)
	{
		
		ArrayList<Integer> peepee = new ArrayList<Integer>();
		
		for(int i = 0; i < elements; i++)
		{
			
			peepee.add((int)(Math.random() * range) + min);
			
		}
		
		return peepee;
		
	}
	
}

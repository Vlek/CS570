// Program: SortingAlgorithms.java
// Purpose: Display the sequence of changes that occur for four different sorting methods: Bubble, Selection, Insertion,
//			and Merge. Each one use the starting array of integers: { 9, 0, 11, 10, 5, 8, 6, 7}.
//
// Author: Derek McCammond
// Date: 11/08/2017

public class SortingAlgorithms {
	public static void main(String[] args) {
		int[] numbers = {9, 0, 11, 10, 5, 8, 6, 7};
		
		bubbleSort(numbers);
		selectionSort(numbers);
		insertionSort(numbers);
		mergeSort(numbers);
	}
	
	private static void bubbleSort(int[] numbers) {
		int[] nums = numbers;
		boolean isNotSorted = true;
		int temp, pass = 1;
		
		int[] result = new int[nums.length];
		System.arraycopy(nums, 0, result, 0, nums.length);
		
		printHeader("Bubble", result);
		
		// While it's the case that we have previously done a sort, then there could still be potential sorting left
		// to do. It's only when we have gone through the entire list without sorting once that we can be sure that
		// we are finally finished and can exit out of this while-loop.
		while (isNotSorted) {
			// Every single time through, we're going to set our flag to false. This way we only go again if we hit
			// numbers in our for-loop that must we switched.
			isNotSorted = false;
			
			// Because we're going to be looking at pairs of numbers, we're going to want to iterate over the array
			// minus the last index as we will be looking at i and i + 1 during each iteration.
			for (int i = 0; i < result.length - 1; i++) {
				
				// If it's the case that we found a pair that needs to be switched, switch them.
				if (result[i] > result[i + 1]) {					
					// We have hit numbers that needed switching. We'll check again to be sure this wasn't the last.
					// I normally wouldn't care whether my flag is false, I'd just have it make it true every time, but
					// because we want to make sure that we only give out our pass numbers at the start of an actual
					// pass, we gotta be cognizant of this.
					if (!isNotSorted) {
						System.out.format("Pass #%d:%n", pass);
						pass++;
						isNotSorted = true;
					}
					
					System.out.format("Switching %d with %d%n", result[i], result[i + 1]);
					
					temp = result[i];
					result[i] = result[i + 1];
					result[i + 1] = temp;
				}
			}
		}
		
		printFooter(result);
 	}
	
	private static void selectionSort(int[] nums) {
		int temp, min;
		
		int[] result = new int[nums.length];
		System.arraycopy(nums, 0, result, 0, nums.length);
		
		printHeader("Selection", nums);
		
		// The nested for-loop structure is largely modeled after the Week 5 slides, page 61
		// For the outer loop, we're going to specify that we're iterating over the entire array minus the last
		// index because this sorting method is forward looking, meaning that it compares an initial value with
		// ones further down the array. If there are no more numbers present after our current value, then we 
		// don't care to check anymore.
		for (int i = 0; i < result.length - 1; i++) {
			
			// The value at the current index we are checking will act as a starting point. If this remains the
			// smallest value after checking the rest of the array, we will skip the switch so that our output
			// isn't confusing and it doesn't do unnecessary switching.
			min = i;
			
			// For this inner for-loop, we're going to look at all of the numbers after i up to and including
			// the last index of the array for a smaller number. If we find one, then we will make min equal
			// to the index of that number to do our switching later.
			for (int j = i + 1; j < result.length; j++) {
				if (result[j] < result[min]) {
					min = j;
				}
			}
			
			// As stated earlier, we're going to make sure that we found another number we need to switch with before
			// doing any actual switching. Min is the index of the smallest value found in the remaining portion of
			// the array. i is the current starting index. If they're different, then we need to do some switching.
			if (min != i) {
				System.out.format("Switching %d with %d%n", result[i], result[min]);
				
				temp = result[min];
				result[min] = result[i];
				result[i] = temp;		
			}
		}
		
		printFooter(result);
	}
	
	private static void insertionSort(int[] nums) {
		int key, p;
		
		int[] result = new int[nums.length];
		System.arraycopy(nums, 0, result, 0, nums.length);
		
		printHeader("Insertion", nums);
		
		// This nested for-loop structure was taken from the week 5 slides, page 64
		// This method will look at the second index first and then move through the remaining array to check whether
		// there is a number to the left of the currently checked one that's smaller than the one we are sorting.
		for (int i = 1; i < result.length; i++) {
			key = result[i];
			p = i;
			
			// While it's the case that we haven't hit the end of the array we're sorting and the number is larger
			// than the one we're currently working with, move that left number to the current p index. This is okay
			// because we've saved the value of the currently checked number in key so we do not have to worry about
			// overwriting values. We use the short circuited "and" operator in order to make sure that we haven't
			// hit the end of the array before checking key against an index smaller than p which would cause an 
			// index out of bounds error otherwise.
			while (p > 0 && result[p-1] > key) {
				result[p] = result[p-1];
				p--;
			}
			
			// If it's the case that we performed a move, then we need to make sure to set the last index we looked
			// at to the value we were testing to iterate backwards through our array and also let the user know.
			if (key != result[i]) {
				result[p] = key;
				System.out.format("Moving %d to the left %d time(s). ", key, i - p);
			} else {
				System.out.format("%d is in the right place. ", key);
			}
			
			System.out.format("The first %d elements are now sorted.%n", i + 1);
		}
		
		printFooter(result);
	}
	
	// This sort method's code was modeled after the week 5 slides, page 68-69
	/* I prototyped my own version in python first before attempting to do it in Java:
		#! /usr/bin/python3
		def merge(a, b):
			# Because I'll know how big a and b are, I can make result equal to their length
			# so it will always fit my needs perfectly.
		    result = []
		    while len(a) or len(b):
		        if len(a) and len(b):
		            if a[0] < b[0]:
		                temp = a.pop(0)
		            else:
		                temp = b.pop(0)
		            result.append(temp)
		        else:
		            if len(a):
		                result.extend(a)
		                a = []
		            else:
		                result.extend(b)
		                b = []
		    return result
		
		# In this case, I went with a recursive break and merge. It felt like the most straight forward way. I know
		# it's probably really terrible processing-wise, but it reads well.
		def mergeSort(x):
			# We know how big x is, so our result will be initialized to reflect its length
		    result = []
		    
		    #Our recursive base-case. When we have one thing, we have a "sorted" list.
		    if len(x) == 1:
		        result.append(x[0])
		        
		    # Otherwise, in this case, we are going to break what we have down into two. This will recursively break
		    # as necessary. Our second list is going to be slightly longer than our first, but I didn't think that
		    # that was any cause for concern. So long as, for an odd length case, they were broken up in as equal
		    # portions as possible.
		    else:
		        middle = len(x) // 2
		        result.extend(merge(mergeSort(x[0:middle]), mergeSort(x[middle:])))
		    return result
	 */
	
	// Because we need something to call our header and footer prints, I have this veneer instead of simply having
	// main call our recursive function itself.
	private static void mergeSort(int[] nums) {
		printHeader("Merge", nums);
		
		printFooter(mergeSortRecur(nums));
	}
	
	// Much like in my python version, I have used a recursive structure for the breaking down of the list to be
	// sorted. Once the pieces are all broken down, they will propogate back up and be merged together.
	private static int[] mergeSortRecur(int[] nums) {
		int[] result = new int[nums.length];

		// Our recursive base-case. If it's the case that we received an array of length 1, then we can return it back.
		if (nums.length == 1) {
			result[0] = nums[0];
			System.out.println("Sorted: " + result[0]);
			
		// Otherwise, we get our cut lines, place the pieces into their own arrays (arrayA and arrayB), and finally
		// recursively handle both of them before merging them into result to be returned.
		} else {
			int middle = nums.length / 2;
			int toEnd = nums.length - middle;
			
			int[] arrayA = new int[middle];
			int[] arrayB = new int[toEnd];
			
			System.arraycopy(nums, 0, arrayA, 0, middle);
			System.arraycopy(nums, middle, arrayB, 0, toEnd);
			
			result = merge(mergeSortRecur(arrayA), mergeSortRecur(arrayB));
			System.out.print("Merged: ");
			printArray(result);
		}
		return result;
	}
	
	// This method is used to merge two arrays of integers by comparing the first index of both to see which is smaller.
	// If we have exhausted one and there are still indexes left of the other, then we will force-feed the rest to the
	// result array and return it.
	private static int[] merge(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		
		int aIndex = 0, bIndex = 0, rIndex = 0;
		
		// Unlike in Python, arrays in Java do not have a "count". We have to keep track using our aIndex and bIndex
		// variables. We will use those to see whether we've hit the end of both of our arrays to make sure we have
		// completely merged everything. rIndex will be used as our index of our result array that we're currently
		// trying to fill.
		while (aIndex < a.length || bIndex < b.length) {
			// What we're doing here is seeing whether both arrays have something left to offer. If they do, then we
			// will compare the values of the indexes we're checking against to see which is smaller. If there is only
			// one array with stuff left, then we will just force-feed it into our result array and be done with it.
			if (aIndex < a.length && bIndex < b.length) {
				if (a[aIndex] < b[bIndex]) {
					result[rIndex] = a[aIndex];
					aIndex++;
				} else {
					result[rIndex] = b[bIndex];
					bIndex++;
				}
				rIndex++;
			} else {
				if (aIndex < a.length) {
					System.arraycopy(a, aIndex, result, rIndex, a.length - aIndex);
					aIndex = a.length;
				} else {
					System.arraycopy(b, bIndex, result, rIndex, b.length - bIndex);
					bIndex = b.length;
				}
			}
		}
		
		return result;
	}
	
	// This helper method prints out arrays of numbers in a way that makes them easier to read.
	private static void printArray(int[] nums) {		
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
	
	// For each of our methods, we state what method is being used as well as what our starting array is
	private static void printHeader(String sortType, int[] nums) {
		System.out.format("%s Sort Method:%n", sortType);
		System.out.print("Starting with array: ");
		printArray(nums);
	}
	
	// Finally, we declare that we're finished sorting and showcase the result
	private static void printFooter(int[] nums) {
		System.out.print("Finished product: ");
		printArray(nums);
		System.out.println();
	}
}

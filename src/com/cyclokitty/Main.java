package com.cyclokitty;

// import Arrays to print out array nicely
import java.util.Arrays;
// import Random to create random numbers in the arrays
import java.util.Random;
// import Scanner to get input from a user
import java.util.Scanner;

// the main class in this project
public class Main {
    // the compiler looks for "main" to begin
    public static void main(String[] args) {
        // this comment means this section tests out the methods for the randomly created array
        // randomly created list:
        // initializes the array "list" with the makeRandomList method that requires a length number
        int[] list = makeRandomList(5);
        // this prints out the random list using our listPrinter array (or else you just get the address
            // in the heap for the array
        System.out.println(listPrinter(list));
        // this prints the sum in our random list
        System.out.println(sumAllElements(list));
        // this prints the largest element in our random list
        System.out.println(findLargest(list));
        // this prints the smallest index (and the first) in our random list
        System.out.println(findSmallestIndex(list));
        // printing out the randomly shuffled list
        System.out.println(listPrinter(randomShuffling(list)));
        // printing out the shifted element list
        System.out.println(listPrinter(shiftElements(list, 2)));

        // this is how I separate sections so there isn't a solid block of results
        System.out.println("**********");

        // this comment means this section tests out the methods for the user input created array
        // user input list:
        // initializes the array "list" with the makeList method that requires a length number
        int[] userList = makeList(5);
        // this prints out the array "userList" (or else you get the address where it lives in the heap
        System.out.println(listPrinter(userList));
        // prints the sum of our userList array
        System.out.println(sumAllElements(userList));
        // prints out the largest element in the userList
        System.out.println(findLargest(userList));
        // this prints the smallest index (and first) of the largest number in the userList array
        System.out.println(findSmallestIndex(userList));
        // this prints out the randomly shuffled userList array
        System.out.println(listPrinter(randomShuffling(userList)));
        // prints out the userList array after it is shifted according to the shiftingNum param
        System.out.println(listPrinter(shiftElements(userList, 2)));

        // this is how I separate sections so there isn't a solid block of results
        System.out.println("**********");

        // this is the answer to the bonus question. I decided to println descriptive statements for the results
            // so it was easier to follow and test out.
        bonusMark();
    }

    // this method initialing arrays with input values. It returns an array.
    public static int[] makeList(int arrayLength) {
        // initializing the array with a length chosen by user
        int[] data = new int[arrayLength];
        // using Scanner class to collect the user input integers
        Scanner scan = new Scanner(System.in);
        // instructing the user
        System.out.println("Please enter your favourite integers.");
        // initializing the variable count to 0. We'll use it to keep track of integers entered by the user
        int count = 0;
        // while loop making sure we collect no more than the arrayLength specified
        while (count < data.length) {
            // Reminding the user what we want from them
            System.out.print("Enter number: ");
            // assigning the user's number to variable input
            String input = scan.nextLine();
            // assigning the input to the next place in the array and turning it from a string to an integer
            data[count] = Integer.parseInt(input);
            // advancing the while by 1 or else we get caught in an endless loop
            count++;
        }
        // once we've collected and assigned the user's input we return the array
        return data;
    }

    // initializing arrays with random values. It returns an array.
    public static int[] makeRandomList(int arrayLength) {
        // we initialize a Random constructor so we can use it's methods to create random integers
        Random rand = new Random();
        // initialize an array with a length chosen by the user
        int[] data = new int[arrayLength];
        // a for loop that'll loop thru the array that is currently filled with 0s.
        for (int i = 0; i < data.length; i++) {
            // a new random integer (from a range of 1 to 100)
            int newNum = rand.nextInt(100) + 1;
            // assigning the integer to the current index in the array
            data[i] = newNum;
        }
        // once the random array is completed we return it
        return data;
    }

    // printing arrays. this returns a String of the array
    public static String listPrinter(int[] array) {
        // I could have printed out each int in the array but wanted a more natural looking, horizontal arrangement
        // the Arrays.toString() does that really nicely
        return Arrays.toString(array);
    }

    // summing all elements and return the final sum
    public static int sumAllElements(int[] array) {
        // initializing total and assigning 0 to it
        int total = 0;
        // for loop to loop thru the integers in the array
        for (int i = 0; i < array.length; i++) {
            // each integer is added to the result in total
            total += array[i];
        }
        // returning the total
        return total;
    }

    // finding the largest element and returning that element
    public static int findLargest(int[] array) {
        // initialize largest and assign 0. Use this to compare to other numbers in the array
        int largest = 0;
        // our for loop to loop thru the elements
        for (int i = 0; i < array.length; i++) {
            // if the current element is larger than the value in largest
            if (array[i] > largest) {
                // we assign that value to largest
                largest = array[i];
            }
        }
        // once thru the loop we return the value in largest variable
        return largest;
    }

    // finding the smallest index of the largest element and returning that element
    public static int findSmallestIndex(int[] array) {
        // we initialize largest variable
        // since we already made a method that finds the largest element, we don't repeat the same blocks of code
        // instead we assign largest to the method findLargest(array) and let it do the work
        int largest = findLargest(array);
        // now that we have the largest number we use a for loop to go thru the contents of the array
        for (int i = 0; i < array.length; i++) {
            // if the current integer in the array is equal to the value in largest
            if (array[i] == largest) {
                // we return that index. Since we only want the first one, we return that index to exit the method
                return i;
            }
        }
        // since we have to return something, -1 means something in our code has failed. -1 will let us know we have
        // made an error in logic
        return -1;
    }

    // random shuffling and returns the newly shuffled array
    public static int[] randomShuffling(int[] array) {
        // we initialze the variables index and temp
        int index, temp;
        // we want to have a randomly selected number to shift elements in the array so we initialize the random constructor
        Random random = new Random();
        // unlike the earlier for loops, we are going backwards
        for (int i = array.length - 1; i > 0; i--) {
            // the index variable will be a random number from 0 to array.length + 1
            index = random.nextInt(i + 1);
            // temp will hold the array at index = to random int
            temp = array[index];
            // then we make the array at the random index = the current index
            array[index] = array[i];
            // then the current index will get the temp value
            array[i] = temp;
        }
        // we return the array
        return array;
    }

    // shifting elements in the array according to a number chosen by the user and returns that shuffled array
    public static int[] shiftElements(int[] array, int shiftingNum) {
        // we initialize the variables index and temp
        int index, temp;
        // we loop backwards thru the array and make sure we reach the 0 index
        for (int i = array.length - 1; i >= 0; i--) {
            // the index equals the shiftingNum parameter
            index = shiftingNum;
            // we hold the value of the array[index] in the temp variable
            temp = array[index];
            // we assign array[index] the value of the current index
            array[index] = array[i];
            // and then assign the temp value to the current idnex
            array[i] = temp;
        }
        // return the shifted array
        return array;
    }

    // the bonus question that asks us to create an array from 100 random ints
    public static void bonusMark() {
        // since we already have a method that can create an array filled with random ints, we initialize a new
        // int[] array with the method makeRandomList(100)
        int[] list = makeRandomList(100);
        // initialize a counter variable with 0. We will count the number of ints in the random list above the average
        int counter = 0;
        // initialize a total variable with 0.
        int total = 0;
        // we loop thru the array
        for (int i = 0; i < list.length; i++) {
            // we add the current element and assign that new value to total
            total += list[i];
        }
        // initialize variable average and assign it the value of total divided by the length of list
        int average = total / list.length;
        // now we loop thru the array and compare
        for (int i = 0; i < list.length; i++) {
            // we compare the current element and find out if it is greater than the average
            if (list[i] > average) {
                // if the current element is greater than the average then we add 1 to the counter variable
                counter++;
            }
        }
        // we give information to the user about our random list
        System.out.println("This is the list we randomly created: ");
        // here we print the random list using our listPrinter method
        System.out.println(listPrinter(list));
        // we give the user the average in our random list
        System.out.println("The average is " + average);
        // and finally give the user how many elements in our random list are greater than the average
        System.out.println("The number of ints in our random list that are above the average is: " + counter);
    }

}
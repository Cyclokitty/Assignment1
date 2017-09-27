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

    public static int findLargest(int[] array) {
        int largest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        return largest;
    }

    public static int findSmallestIndex(int[] array) {
        int largest = findLargest(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == largest) {
                return i;
            }
        }
        return -1;
    }

    public static int[] randomShuffling(int[] array) {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }


    public static int[] shiftElements(int[] array, int shiftingNum) {
        int index, temp;
        for (int i = array.length - 1; i >= 0; i--) {
            index = shiftingNum;
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;}
        return array;
    }

    public static void bonusMark() {
        int[] list = makeRandomList(100);
        int counter = 0;
        int total = 0;
        for (int i = 0; i < list.length; i++) {
            total += list[i];
        }
        int average = total / list.length;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > average) {
                counter++;
            }
        }
        System.out.println("This is the list we randomly created: ");
        System.out.println(listPrinter(list));
        System.out.println("The average is " + average);
        System.out.println("The number of ints in our random list that is above the average is: " + counter);
    }

}
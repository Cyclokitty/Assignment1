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
        int[] userList = makeList(5);
        System.out.println(listPrinter(userList));
        System.out.println(sumAllElements(userList));
        System.out.println(findLargest(userList));
        System.out.println(findSmallestIndex(userList));
        System.out.println(listPrinter(randomShuffling(userList)));
        System.out.println(listPrinter(shiftElements(userList, 2)));

        System.out.println("**********");

        bonusMark();
    }

    public static int[] makeList(int arrayLength) {
        int[] data = new int[arrayLength];
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your ten favourite integers.");
        int count = 0;
        while (count < data.length) {
            System.out.print("Enter number: ");
            String input = scan.nextLine();
            data[count] = Integer.parseInt(input);
            count++;
        }
        return data;
    }

    public static int[] makeRandomList(int arrayLength) {
        Random rand = new Random();
        int[] data = new int[arrayLength];
        for (int i = 0; i < data.length; i++) {
            int newNum = rand.nextInt(100) + 1;
            data[i] = newNum;
        }
        return data;
    }

    public static String listPrinter(int[] array) {
        return Arrays.toString(array);
    }

    public static int sumAllElements(int[] array) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
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
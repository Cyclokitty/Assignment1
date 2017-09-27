package com.cyclokitty;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // randomly created list:
        int[] list = makeRandomList(5);
        System.out.println(listPrinter(list));
        System.out.println(sumAllElements(list));
        System.out.println(findLargest(list));
        System.out.println(findSmallestIndex(list));
        System.out.println(listPrinter(randomShuffling(list)));
        System.out.println(listPrinter(shiftElements(list, 2)));

        System.out.println("**********");

        // user input list:
        int[] userList = makeList(5);
        System.out.println(listPrinter(userList));
        System.out.println(sumAllElements(userList));
        System.out.println(findLargest(userList));
        System.out.println(findSmallestIndex(userList));
        System.out.println(listPrinter(randomShuffling(userList)));
        System.out.println(listPrinter(shiftElements(userList, 2)));
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

}
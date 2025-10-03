package SAA;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySumAvg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = input.nextInt();
        int[] my_array1 = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            my_array1[i] = input.nextInt();
        }
        System.out.println("Original array: " + Arrays.toString(my_array1));
        Arrays.sort(my_array1);
        System.out.println("Sorted array: " + Arrays.toString(my_array1));
        int sum = 0;
        for (int num : my_array1) {
            sum += num;
        }
        double average = (double) sum / my_array1.length;
        System.out.println("Sum of elements = " + sum);
        System.out.println("Average value = " + average);

        input.close();
    }
}
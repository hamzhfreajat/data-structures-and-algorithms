/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.InsertionSort;

public class App {


    public static void main(String[] args) {
        int[] arr = {8,4,23,42,16,15};

        int[] arr1 = insertionSort(arr);
        for (int i = 0 ; i<arr.length; i++){
            System.out.println(arr1[i]);
        }

    }

    public static int[] insertionSort(int[] arr){
        for (int i = 1 ; i < arr.length ; i++){
            int j = i-1;
            int temp = arr[i];
            while (j >= 0 && temp < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = temp ;
        }
        return arr;
    }
}
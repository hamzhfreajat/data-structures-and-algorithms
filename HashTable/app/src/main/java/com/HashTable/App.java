/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.HashTable;

import com.HashTable.structure.HashMap;

import java.util.Hashtable;

public class App {

    public static void main(String[] args) {
        HashMap<String , String> hashMap = new HashMap<>();
        hashMap.put("hamzh" , "java developer");
        hashMap.put("hamzh" , "java develop");
        hashMap.put("ahmad" , "java developer");
        hashMap.put("mohammed" , "java developer");
        hashMap.put("Ibrahem" , "java developer");
        hashMap.put("JAVA" , "hello evry one");
        hashMap.put("Amman" , "hello evry one" );


        System.out.println(hashMap.keys());
        System.out.println(hashMap.contains("hazh"));
        System.out.println(hashMap.getSize());
        System.out.println(hashMap.print("Ibrahem"));

    }
}
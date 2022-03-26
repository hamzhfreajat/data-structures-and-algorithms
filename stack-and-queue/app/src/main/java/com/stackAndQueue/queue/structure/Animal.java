package com.stackAndQueue.queue.structure;

public class Animal {
     private String animalType ;
     private String name ;

     public Animal(String animalType) {
          this.animalType = animalType;
     }

     @Override
     public String toString() {
          return animalType ;
     }
}

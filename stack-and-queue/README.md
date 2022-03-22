# Stacks and Queues
- Stack is a container of objects that are inserted and removed according to the last-in first-out (LIFO) principle.
- Queue is a container of objects (a linear collection) that are inserted and removed according to the first-in first-out (FIFO) principle.

## Challenge
Make Stack and Queue class from scratch the make methods that make a user can manipulate with data . 

## Approach & Efficiency
- My approach in stack is to make a top pointer thats point to the last element then I can change the data from top . 
- My approach in queue is to make first and last pointer then we can manipulate with data . 

## API
### Stack 
- Push 

    A method let a user insert any value to the stack 
- Pop

  A method let a user delete the first value in the stack . 

- Peek

    A method that let the user know what the first value in the stack .

- empty 
    Check if the stack is empty 

### Queue
- enqueue

  A method let a user insert any value to the Queue
- dequeue

  A method let a user delete the first value in the Queue .

- Peek

  A method that let the user know what the first value in the Queue .

- empty

  Check if the stack is empty 


## Code Challenge 11 

### Challenge Summary
Build queue using two stack 

#### Whiteboard Process
![Whiteboard Process](./app/src/main/resources/Whiteboard.png)

#### Approach & Efficiency
Reverse stack one in stack two then we can use Stack class to manipulate Queue . 

#### Solution
Put this code in App java file  

    PseudoQueue<Integer> queue  = new PseudoQueue<>();
    queue.enqueue(1);
    queue.enqueue(2);
    System.out.println(queue.enqueue(3));
    System.out.println(queue.dequeue());


## Code Challenge 12 
# Challenge Summary
Create a function that do queue for just cat and dog object (First-in, First out Animal Shelter).

## Whiteboard Process
![Whiteboard Process](./app/src/main/resources/Whiteboard-2.png)

## Approach & Efficiency
Make two pointer then remove the value by make previous node points to the next .

## Solution
Put this code in App java file to run the code and see how its work : 

        Animal cat = new Cat("cat");
        Animal dog = new Dog("dog");
        AnimalShelter animalShelter = new AnimalShelter();
        System.out.println(animalShelter.enqueue(cat));
        System.out.println( animalShelter.enqueue(dog));
        System.out.println( animalShelter.enqueue(dog));
        System.out.println( animalShelter.enqueue(dog));
        System.out.println( animalShelter.enqueue(dog));
        System.out.println(animalShelter.dequeue("cat"));
        System.out.println(animalShelter);



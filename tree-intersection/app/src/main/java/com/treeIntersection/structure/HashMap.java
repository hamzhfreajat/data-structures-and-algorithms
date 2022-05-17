package com.treeIntersection.structure;



import com.treeIntersection.data.HashNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class HashMap<K,V> {
    private ArrayList<HashNode<K, V>> bucketArray;
    private int buckets;
    private int size;
    private final HashSet<K> keysArray  = new HashSet<>();

    public int getBuckets() {
        return buckets;
    }

    public HashMap() {
        bucketArray = new ArrayList<>();
        buckets = 10;

        for (int index = 0; index < buckets; index++) {
            bucketArray.add(null);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hashCode(K key) {
        return Objects.hashCode(key);
    }


    public int getHashed(K key) {
        int hashCode = hashCode(key);
        int arrayIndex = hashCode % buckets;

        arrayIndex = arrayIndex < 0 ? arrayIndex * -1 : arrayIndex;


        return arrayIndex;
    }

    public void set(K key, V value) {
        int index = getHashed(key);
        int hashcode = hashCode(key);



        HashNode<K, V> newNode = new HashNode<>(key, value, hashcode);
        HashNode<K, V> head = bucketArray.get(index);

        if (head == null) {
            bucketArray.set(index, newNode);
            keysArray.add(key);
            size++;
        } else {

            while (head != null) {
                if (head.getKey().equals(key) && head.getHashCode() == hashcode) {
                    head.setValue(value);
                    return;
                }
                head = head.getNext();
            }

                keysArray.add(key);
                newNode.setNext(head.getNext());
                head.setNext(newNode);
                size++;

        }

        if ((1.0 * size) / buckets >= 0.7) {
            ArrayList<HashNode<K, V> > temp = bucketArray;
            bucketArray = new ArrayList<>();
            buckets = 2 * buckets;
            size = 0;
            for (int i = 0; i < buckets; i++)
                bucketArray.add(null);

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    set(headNode.getKey(), headNode.getValue());
                    headNode = headNode.getNext();
                }
            }
        }
    }

    public HashSet<K> keys(){
       return keysArray ;
    }


    public V get(K key)
    {
        int bucketIndex = getHashed(key);
        int hashCode = hashCode(key);

        HashNode<K, V> head = bucketArray.get(bucketIndex);


        while (head != null) {
            if (head.getKey().equals(key) && head.getHashCode() == hashCode)
                return head.getValue();
            head = head.getNext();
        }

        return null;
    }

    public boolean contains(K key){
        return keysArray.contains(key);
    }


    public String print(K key) {
        int bucketIndex = getHashed(key);
        HashNode<K, V> pointer = bucketArray.get(bucketIndex);
        String out = "";
        while (pointer != null){
            out +="{ "+ pointer.getKey()+"=>" +pointer.getValue() + " } -> ";
            pointer = pointer.getNext();
        }
        out +="{ NULL }";
        return out;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "bucketArray=" + bucketArray +
                ", buckets=" + buckets +
                ", size=" + size +
                ", keysArray=" + keysArray +
                '}';
    }
}

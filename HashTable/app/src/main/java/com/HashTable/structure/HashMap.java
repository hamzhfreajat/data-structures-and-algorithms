package com.HashTable.structure;

import com.HashTable.data.HashNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    public void put(K key, V value) {
        int index = getHashed(key);
        int hashcode = hashCode(key);



        HashNode<K, V> newNode = new HashNode<>(key, value, hashcode);
        HashNode<K, V> head = bucketArray.get(index);

        if (head == null) {
            bucketArray.set(index, newNode);
            keysArray.add(key);
            size++;
        } else {

            if (keysArray.contains(key)){
                head.setValue(value);
                System.out.println("duplucate => " + key);
                return;
            }


                System.out.println("Not => " +  key);
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
                    put(headNode.getKey(), headNode.getValue());
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

    public List<List<String>> leftJoin(HashMap<String , String> right , List<List<String>> result){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < buckets; i++) {
            HashNode<K, V> head = bucketArray.get(i);
            while (head != null) {
                list = new ArrayList<>();
                list.add(head.getKey().toString());
                list.add(head.getValue().toString());
                if (right.contains(head.getKey().toString())){
                    list.add(right.get(head.getKey().toString()));
                }else {
                    list.add(null);
                }
                result.add(list);
                head = head.getNext();
            }


        }

        return result;
    }


}

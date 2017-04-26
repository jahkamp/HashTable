/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2hashtable;

import static sun.net.ftp.FtpClient.TransferType.ASCII;

/**
 *
 * @author Jared Kamp
 * CSCI 232
 * Lab 1 - HuffmanCode
 */
public class HashTable {  
    private int arraySize;
    private Tree[] hashArray;
    private int nextIndex;
    private int[] values;
    public HashTable(int in){
        //intialize
        arraySize = in;
        nextIndex = 0;
        hashArray = new Tree[arraySize];
        values = new int[1000]; //make this large enough for the demo
    }
    public void displayTree(){
        for(int i = 0; i < arraySize; i++)
        {
            System.out.println("Displaying tree at array index " + i + ".\n");
            hashArray[i].displayTree();
        }
    }
    public void showTable(){
        for(int i = 0; i < arraySize; i++)
        {
            System.out.print("1. ");
            hashArray[i].traverse(2);
        }
    }
    private int hashKey(int key){
        return (key % arraySize);
    }
    public void insert(int in){
        boolean duplicate = false;
        for(int i = 0; i < nextIndex; i++)
        {
            if(in == values[i])
                duplicate = true;
        }
        if(!duplicate)
        {
            values[nextIndex++] = in;
            int key = hashKey(in);
            if(hashArray[key]==null)
            {
                Tree newTree = new Tree();
                newTree.insert(in, in);
                hashArray[key]=newTree;
            }
            else
                hashArray[key].insert(in, in);        
        }
        else
            System.out.println(in + " is a duplicate value. Please select a different value.\n");
    }
    public Node find(int search)
    {
        return hashArray[hashKey(search)].find(search);
    }
}
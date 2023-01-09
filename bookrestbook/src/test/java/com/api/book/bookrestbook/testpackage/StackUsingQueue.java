package com.api.book.bookrestbook.testpackage;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1=new LinkedList<>();
    Queue<Integer> q2=new LinkedList<>();

    public static void main(String[] args) {
            StackUsingQueue s1=new StackUsingQueue();
            s1.insert(44);
            s1.insert(47);
            s1.insert(67);
            s1.insert(69);
            s1.insert(80);
            s1.remove();
            s1.remove();
            s1.remove();
            s1.remove();
            s1.insert(61);
            s1.insert(46);
            System.out.println(s1.q1);
            
    }   

    public void insert(int x){
        q1.add(x);
    }

    public int remove(){
        if(q1.isEmpty()){
            return -1;
        }
        while(q1.size()>1){
            q2.add(q1.remove());
        }
        int ans=q1.remove();
      
       
        q1=new LinkedList<>(q2);        
        q2.clear();


        return ans;
    }
}
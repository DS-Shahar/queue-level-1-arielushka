package main;

import java.util.Scanner;

public class test 
{

    public static void main(String[] args) 
    {
    	int[]a = {2,4,2,8,3,7};
    	int[]arr = {4,6,2,8,1,9,4,5};
    	Queue<Integer> q2 = buildTor(arr);
    	Queue<Integer> q = buildTor(a);
    	
    	//-----------------1-------------------
    	Queue<Integer> q1 = ex1(q);
    	print(q1);
    	//-----------------2-------------------
    	System.out.println(ex2(q));
    	//-----------------3-------------------
    	System.out.println(ex3(q,2));
    	//-----------------4-------------------
    	System.out.println(ex4(q,q2));
    	//-----------------5-------------------
    	System.out.println(ex5(q,2));
    	
    	
    	
    }
    public static void print(Queue<Integer> q)
    {
    	Queue<Integer> cloneQueue = ex1(q);
    	while(!cloneQueue.isEmpty())
    	{
    		int x = cloneQueue.remove();
    		System.out.print(x+" ");
    	}
    	System.out.println();
    }
    public static Queue<Integer> buildTor(int[]a)
    {
    	Queue<Integer> q = new Queue<>();
    	for(int i = 0; i<a.length;i++)
    		q.insert(a[i]);
    	return q;
    }
    public static void Recovery(Queue<Integer> q, Queue<Integer> clone)
    {
    	while(!clone.isEmpty())
    	{
    		int x = clone.remove();
    		q.insert(x);
    	}
    }
    public static Queue<Integer> ex1(Queue<Integer> q)
    {
    	Queue<Integer> newQueue = new Queue<>();
    	Queue<Integer> cloneQueue = new Queue<>();
    	
    	while(!q.isEmpty())
    	{
    		int x = q.remove();
    		newQueue.insert(x);
    		cloneQueue.insert(x);
    	}
    	while(!cloneQueue.isEmpty())
    	{
    		int x = cloneQueue.remove();
    		q.insert(x);
    	}
    	return newQueue;
    }
    public static double ex2(Queue<Integer> q)
    {
    	double sum = 0;
    	int index = 0;
    	Queue<Integer> cloneQueue = ex1(q);
    	while(!cloneQueue.isEmpty())
    	{
    		int x = cloneQueue.remove();
    		sum = sum + x;
    		index++;
    	}
    	return sum/index;
    }
    public static int ex3(Queue<Integer> q,int num)
    {
    	int counter = 0;
    	Queue<Integer> cloneQueue = ex1(q);
    	while(!cloneQueue.isEmpty())
    	{
    		int x = cloneQueue.remove();
    		if(num % x == 0)
    			counter++;
    	}
    	return counter;
    }
    public static boolean ex4(Queue<Integer> q,Queue<Integer> q2)
    {
    	boolean ok = false;
    	Queue<Integer> cloneQueue = ex1(q);
    	while(!cloneQueue.isEmpty())
    	{
    		int x = cloneQueue.remove();
    		Queue<Integer> cloneQueue2 = ex1(q2);
    		while(!cloneQueue2.isEmpty())
    		{
    			if(cloneQueue2.remove() % x == 0)
    				ok = true;
    				break;
    		}
    		if(!ok)
    			return false;
    		else
    			ok = false;
    	}
    	return true;
    }
    public static boolean ex5(Queue<Integer> q, int x)
    {
    	int index = 0;
    	Queue<Integer> cloneQueue = ex1(q);
    	while(!cloneQueue.isEmpty())
    	{
    		int num = cloneQueue.remove();
    		if(num == x)
    			index++;
    		else
        		index = 0;
    	}
    	return index >1;
    }
    
    
    
}

package com.jaba.code.leetcode.problemsolving.problems;

import estruturasdados.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MyListTest {


    @Test(expected=IndexOutOfBoundsException.class)
    public void testMyList() {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        assertTrue(4 == list.get(4));
        assertTrue(2 == list.get(1));
        assertTrue(3 == list.get(2));

        list.get(6);
    }


    @Test(expected=IndexOutOfBoundsException.class)
    public void testNegative() {
    	MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.get(-1);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testList() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        assertTrue(4 == list.get(4));
        assertTrue(2 == list.get(1));
        assertTrue(3 == list.get(2));

        list.get(6);
    }

    @Test
    public void testCapacity() {
    	MyArrayList list = new MyArrayList();
    	
    	list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        System.out.println(list.getCapacity());
        
        assertTrue(40 == list.getCapacity());
    	
    }
    
    //@Test(expected=IndexOutOfBoundsException.class)
    public void testRemove() {
    	MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.remove(0);
        list.remove(0);
        list.remove(2);
        System.out.println(list);
        list.remove(5);
        
    }
    
    //@Test(expected=IndexOutOfBoundsException.class)
    public void testRemoveVazio() {
    	MyArrayList list = new MyArrayList();
    	list.add(1);
    	list.remove(0);
        list.remove(-1);
    }
    
    //@Test
    public void testIndexPosicao() {
    	MyArrayList list = new MyArrayList();
    	list.add(1);
    	list.add(100);
    	list.add(3);
    	list.add(2);
    	
    	System.out.println(list);
    	list.add(2, 89);
    	System.out.println(list);
    	list.add(0, -1);
    	System.out.println(list);
    }
    
    


}
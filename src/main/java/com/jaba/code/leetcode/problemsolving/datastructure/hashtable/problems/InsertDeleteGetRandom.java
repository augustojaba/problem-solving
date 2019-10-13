package com.jaba.code.leetcode.problemsolving.datastructure.hashtable.problems;

import java.util.*;

public class InsertDeleteGetRandom {

    Map<Integer, Integer> mapValue;
    List<Integer> indexList;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandom() {
        this.mapValue = new HashMap<>();
        this.indexList = new ArrayList<>();

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (mapValue.containsKey(val)) {
            return false;
        }

        indexList.add(val);
        mapValue.put(val, indexList.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!mapValue.containsKey(val)) {
            return false;
        }

        int indexFound = mapValue.get(val);
        int indexLast = indexList.size() - 1;
        int lastItem = indexList.get(indexLast);

        indexList.set(indexFound, indexList.get(indexLast));
        mapValue.put(lastItem, indexFound);
        indexList.remove(indexLast);

        mapValue.remove(val);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random r = new Random();
        return indexList.get(r.nextInt(indexList.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom obj = new InsertDeleteGetRandom();

        /*System.out.println();

        System.out.println(obj.insert(1));
        System.out.println(obj.insert(10));
        System.out.println(obj.insert(20));
        System.out.println(obj.insert(30));
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());

        System.out.println();

        obj = new InsertDeleteGetRandom();

        System.out.println(obj.insert(0));
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(2));
        System.out.println(obj.remove(1));
        System.out.println(obj.getRandom());

        System.out.println();

        obj = new InsertDeleteGetRandom();*/

        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }
}

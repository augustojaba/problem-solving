package com.jaba.code.leetcode.problemsolving.datastructure.hashtable;

class MyHashMap {
    
    private static final int ITEMS_PER_BUCKET = 1000;
    private static final int BUCKETS = 1000;
    private int[][] map;
    

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[BUCKETS][];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hashPerBuckets(key);
        int hashInside = hashInsideBuckets(key);
            
        if (map[hash] == null) {
            map[hash] = hash == 0? createEmptyArray(ITEMS_PER_BUCKET + 1) : createEmptyArray(ITEMS_PER_BUCKET);
        }
        
        map[hash][hashInside] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hashPerBuckets(key);
        int hashInside = hashInsideBuckets(key);
        
        if (map[hash] != null) {
            return map[hash][hashInside];
        } else {
            return -1;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hashPerBuckets(key);
        int hashInside = hashInsideBuckets(key);
        
        if (map[hash] != null) {
            map[hash][hashInside] = -1;
        }
        
    }
    
    private int hashPerBuckets(int key) {
        return key % BUCKETS;
    }
    
    private int hashInsideBuckets(int key) {
        return key / ITEMS_PER_BUCKET;
    }
    
    private int[] createEmptyArray(int size) {
        int[] array = new int[size];
        
        for(int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        
        return array;
    }
    public static void main(String[] args) {
        MyHashMap hs = new MyHashMap();
        hs.put(1, 1);
        hs.put(2, 2);
        System.out.println(hs.get(1));
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
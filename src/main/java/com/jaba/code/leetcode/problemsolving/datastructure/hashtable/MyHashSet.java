package com.jaba.code.leetcode.problemsolving.datastructure.hashtable;

class MyHashSet {
    
    private final int BUCKETS = 1000;
	private final int ITEM_PER_BUCKETS = 1000;
    
    private boolean[][] bucketList;

    /** Initialize your data structure here. */
    public MyHashSet() {
        bucketList = new boolean[BUCKETS][];
        
    }
    
    public void add(int key) {
        int hash = hash(key);
    	
        if (bucketList[hash] == null) {
            bucketList[hash] = new boolean[hash == 0? ITEM_PER_BUCKETS + 1: ITEM_PER_BUCKETS];
        }
        
        bucketList[hash][key/BUCKETS] = true;
    }
    
    public void remove(int key) {
        int hash = hash(key);
    	
    	if (bucketList[hash] != null) {
    		bucketList[hash][key/BUCKETS] = false;
    	}
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hash(key);
    	
    	if (bucketList[hash] != null) {
    		return bucketList[hash][key/BUCKETS];
    	} else {
    		return false;
    	}
    }
    
    private int hash(int key) {
        return key % BUCKETS;
    }

    public static void main(String[] args) {
        MyHashSet hs = new MyHashSet();
        hs.add(1);

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
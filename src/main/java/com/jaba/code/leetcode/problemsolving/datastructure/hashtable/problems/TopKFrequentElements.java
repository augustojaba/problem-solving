package com.jaba.code.leetcode.problemsolving.datastructure.hashtable.problems;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Entry<Integer, Integer>> minHeap = new PriorityQueue(comparingByValue());

        for (Entry<Integer, Integer> entry: freqMap.entrySet()) {
            minHeap.add(entry);

            if(minHeap.size() > k) {
                minHeap.poll();
            }

        }

        for (Entry<Integer, Integer> entry: minHeap) {
            result.add(0, entry.getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TopKFrequentElements().topKFrequent(new int[] {1,1,1,2,2,3}, 2));
        System.out.println(new TopKFrequentElements().topKFrequent(new int[] {-1, -1}, 1));
    }
}

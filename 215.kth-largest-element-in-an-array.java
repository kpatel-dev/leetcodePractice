import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //create a maxHeap, storing up to nums.length-k elements - > because we want to keep the largest element at the top
        
        //the top of the minHeap will be the Kth largest element
        //keep the k smallest elements
        int maxHeapSize = nums.length-k+1; //because 0 is the 0th smallest element
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        
        //add all the elements to the heap
        for (int num: nums){
            maxHeap.add(num);
            
            //if the max heap size is reached, remove the current largest element
            if (maxHeap.size()>maxHeapSize){
                maxHeap.remove();
            }
        }
        
        //return the top of the heap
        return maxHeap.remove();
        
    }
    }

}
// @lc code=end


package com.chen.algorihm.dataStructure;

import java.util.Stack;

/**
 * Created by chen
 * Date : 15-12-31
 * Name : Algorihm
 */
public class DataStructure {

    /**
     * Largest rectangle in histogram
     * 直方图最大矩形覆盖
     * 给出 height = [2,1,5,6,2,3]，返回 10
     *
     * @param height : a list of integer
     * @return : the area of largest rectangle
     */
    public int largestRectangleArea(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = i == height.length ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }

        return max;

    }
}

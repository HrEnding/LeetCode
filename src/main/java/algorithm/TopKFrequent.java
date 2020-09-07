package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 提示：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * @Author: Hr_Ending
 * @Date: 2020/9/7 21:27
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        LFU lfu = new LFU();
        for (int val : nums) {
            lfu.put(val);
        }
        return lfu.getTopKFreqent(k);
    }

    private class LFU {
        HashMap<Integer, Node> cache;
        DoublyLinkedList head;
        DoublyLinkedList tail;

        public LFU() {
            cache = new HashMap<>();
            head = new DoublyLinkedList(0);
            tail = new DoublyLinkedList(0);
            head.next = tail;
            tail.prev = head;
        }

        public void put(int key) {
            Node node = cache.get(key);
            if (node == null) {
                node = new Node(key);
                DoublyLinkedList prevList = tail.prev;
                if (prevList.freq == node.freq) {
                    prevList.addToTail(node);
                } else {
                    DoublyLinkedList newList = new DoublyLinkedList(node.freq);
                    newList.addToTail(node);
                    addList(newList, prevList);
                }
            } else {
                node.freq++;
                DoublyLinkedList curList = node.curList;
                DoublyLinkedList prevList = curList.prev;
                curList.remove(node);
                if (curList.head.next == curList.tail) {
                    removeList(curList);
                }
                if (prevList.freq == node.freq) {
                    prevList.addToTail(node);
                } else {
                    DoublyLinkedList newList = new DoublyLinkedList(node.freq);
                    newList.addToTail(node);
                    addList(newList, prevList);
                }
            }
            cache.put(key, node);
        }

        public int[] getTopKFreqent(int k) {
            int[] res = new int[k];
            int cur = 0;
            Node curNode = head.next.head.next;
            while (cur < k) {
                // System.out.println(cur + ", " + curNode.key + ", " + curNode.freq + ", "+ curNode.next.key + ", " + curNode.curList.freq);
                res[cur++] = curNode.key;
                curNode = curNode.next;
                if (curNode == curNode.curList.tail) {
                    curNode = curNode.curList.next.head.next;
                }
            }
            return res;
        }

        private void addList(DoublyLinkedList newList, DoublyLinkedList prevList) {
            prevList.next.prev = newList;
            newList.next = prevList.next;
            prevList.next = newList;
            newList.prev = prevList;
        }

        private void removeList(DoublyLinkedList curList) {
            curList.next.prev = curList.prev;
            curList.prev.next = curList.next;
            curList.next = null;
            curList.prev = null;
        }
    }

    private class DoublyLinkedList {
        DoublyLinkedList prev;
        DoublyLinkedList next;
        Node head;
        Node tail;
        int freq;

        public DoublyLinkedList(int freq) {
            this.freq = freq;
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
            // from head/tail can get curList
            head.curList = this;
            tail.curList = this;
        }

        public void addToTail(Node node) {
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
            node.curList = this;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            node.curList = null;
        }
    }

    private class Node {
        int key;
        int freq;
        Node prev;
        Node next;
        DoublyLinkedList curList;

        public Node(int key) {
            this.key = key;
            this.freq = 1;
        }
    }
}

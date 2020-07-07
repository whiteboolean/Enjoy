package com.frame.lib.queue;

import java.security.Principal;

public class ArrayQueueDemo {

    public static void main(String[] args) {

    }


}


//使用数组模模拟队列 --- 编写一个ArrayQueue
class ArrayQueue {

    private int maxSize; //表示数组的最大容量
    private int front;
    private int rear;
    private int[] arr;


    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }


    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        rear++;//让rear后移
        arr[rear] = n;
    }


    //获取队列的数据，出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++;
        return arr[front];
    }


    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] =%d\n", i, arr[i]);
        }
    }


    //显示队列的头数据，这个不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front + 1];


    }

}


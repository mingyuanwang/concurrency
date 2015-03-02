package com.concurrency;

/**
 * Created by Administrator on 2015/3/2.
 */
public class TenThreads {
    private static class workerThread extends Thread {
        int max = Integer.MIN_VALUE;
        int[] ourArray;

        public workerThread(int[] ourArray) {
            this.ourArray = ourArray;
        }

        public void run() {
            for (int i = 0; i < ourArray.length; i++) {
                max = Math.max(max, ourArray[i]);
            }
        }

        public int getMax() {
            return max;
        }
    }

    public static void main(String[] args) {
        workerThread[] threads = new workerThread[10];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 10; i++) {
            threads[i]=new workerThread(null);
            threads[i].start();
        }
        try {
            for(int i=0;i<10;i++){
                threads[i].join();
                max=Math.max(max,threads[i].getMax());
            }
        }   catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("max= "+max);
    }
}


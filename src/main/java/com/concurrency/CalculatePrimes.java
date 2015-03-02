package com.concurrency;

/**
 * Created by Administrator on 2015/3/2.
 */
public class CalculatePrimes  extends Thread{
    public static final int MAX_PRIMES=1000000;
    public static final int TEN_SECOND=10000;
    public volatile boolean finished=false;

    @Override
    public void run() {
        int[] primes=new int[MAX_PRIMES];
        int count=0;
        for(int i=2;count<MAX_PRIMES;i++){
            if(finished){
                break;
            }
            boolean prime=true;
            for(int j=0;j<count;j++){
                if(i%primes[j] == 0){
                    prime=false;
                    break;
                }
            }
            if(prime){
                primes[count++]=i;
                System.out.println("Found prime: "+i);
            }
        }
    }

    public static void main(String[] args){
        CalculatePrimes calculatePrimes=new CalculatePrimes();
        calculatePrimes.start();
        try {
            Thread.sleep(TEN_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        calculatePrimes.finished=true;
        System.out.println("========== end =========");
    }
}

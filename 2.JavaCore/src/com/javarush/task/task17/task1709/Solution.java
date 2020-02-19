package com.javarush.task.task17.task1709;

/* 
Предложения
*/

public class Solution {
    public static int proposal = 0;

    public static void main(String[] args) {
        new AcceptProposal().start();
        new MakeProposal().start();
    }

    public static class MakeProposal extends Thread {
        @Override
        public void run() {
//            int thisProposal = proposal;

            while (proposal < 10) {
                System.out.println("Сделано предложение №" + (proposal + 1));
                proposal++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    public static class AcceptProposal extends Thread {
        @Override
        public void run() {
//            int thisProposal = proposal;

            while (proposal < 10) {

                    System.out.println("Принято предложение №" + proposal);
                    proposal++;


            }
        }
    }
}

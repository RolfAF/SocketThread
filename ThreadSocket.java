/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket_thread;

/**
 *
 * @author asd
 */
public class ThreadSocket implements Runnable{
    int reps;
    String str;
    public ThreadSocket(int reps, String str) {
        this.reps = reps;
        this.str = str;
    }
    public void run() {
        for(int x = 0; x < reps; x ++) {
            System.out.println(str);
            java.lang.Thread.currentThread();
            java.lang.Thread.yield();
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}

package ois.internship.util;


public class Util {

    /**
     * スレッドを一時停止
     * @param time
     */
    public void waitTimer(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

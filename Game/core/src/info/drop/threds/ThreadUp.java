package info.drop.threds;

public class ThreadUp extends Thread {

    float rectangel;

    public ThreadUp(float rectangel){
        this.rectangel = rectangel;
    }

    @Override
    public synchronized void start() {

        for (int i = 0; i < 100; i++){
            rectangel += 1;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            rectangel += 1;
        }
    }

}

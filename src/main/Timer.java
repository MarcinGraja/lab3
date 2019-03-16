package main;

public class Timer {
    private long tStart;
    public void start(){
        tStart = System.currentTimeMillis();
    }
    public double tellSeconds(){
        return (System.currentTimeMillis()-tStart) / 1000.0;
    }
    public String toString(){
        return tellSeconds()+" s";
    }
}

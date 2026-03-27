package org.cfs;

public class Petrolengine implements Engine{
    public Petrolengine() {
        System.out.println(" petrol constructor called ...");
    }

    @Override
    public int start() {
        return 1;
    }
}

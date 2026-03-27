package org.cfs;

public class dieselengine implements Engine{
    public dieselengine() {
        System.out.println(" diesel constructor is called ");
    }

    @Override
    public int start() {

        return 1;
    }
}

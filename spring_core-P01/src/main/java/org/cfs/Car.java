package org.cfs;

public class Car {
Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public Car(Engine engine) {
        System.out.println(" Car constructor is called ...");
        this.engine = engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void drive(){
    int i = engine.start();
    if(i>=1){
        System.out.println("Car start to drive ...");
    }else {
        System.out.println("ENgine not started..");
    }
}
}

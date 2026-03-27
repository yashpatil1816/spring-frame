package org.cfs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
    public static void main(String[] args) {
        System.out.println("---------------Beanfactory started-------------- ");
        // beanFactory ,,, Lazy  LOADING , bean object is created when getbean() method is calle d.

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml"); // eager loading ,, mena bean object is create when ioc start
        System.out.println("---------------Bean File  loaded -----------------");

        System.out.println("-----Request send -----");
        System.out.println("--------first cal ----------");
        Car car1= context.getBean(Car.class);
        System.out.println("--------- second call------- ");
        Car car2 = context.getBean(Car.class);

        System.out.println("same car engine (same object shared across all car ): "+(car1==car2));
        car1.drive();
    }
}

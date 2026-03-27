package org.cfs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
     ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        motor m = context.getBean(motor.class);
        m.work();

        context.close();
    }
}

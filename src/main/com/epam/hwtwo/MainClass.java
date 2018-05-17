package com.epam.hwtwo;

import com.epam.hwtwo.Entity.Horse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        System.out.println(((Horse)applicationContext.getBean("HorseEntity")).getBreed());
    }
}

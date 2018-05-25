package com.epam.hwtwo;

import com.epam.hwtwo.Services.EmulationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        ((EmulationService) applicationContext.getBean("emulationService")).startRace(50,"pinkie");
    }
}

package com.javarush.task.task33.task3309;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
public class First {

    public String[] second;

    @Override
    public String toString() {
        return "First{" +
                "second=" + Arrays.toString(second) +
                '}';
    }
}

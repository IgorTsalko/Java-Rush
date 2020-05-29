package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);

        System.out.println("\ns.i = " + s.i);
        System.out.println("s.name = " + s.name);

        System.out.println("\nf.i = " + f.i);
        System.out.println("f.name = " + f.name);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.USE_ANNOTATIONS);

//        StringWriter writer = new StringWriter();
//        mapper.writeValue(writer, one);
//
//        StringReader reader = new StringReader(writer.toString());
//
//        return mapper.readValue(reader, resultClassObject);

        return mapper.convertValue(one, resultClassObject);
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            property = "className"
    )
    @JsonSubTypes(
            @JsonSubTypes.Type(
                    value = First.class, name = "first"
            )
    )
    public static class First {
        public int i = 1;
        public String name = "FirstFirst";
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            property = "className"
    )
    @JsonSubTypes(
            @JsonSubTypes.Type(
                    value = Second.class, name = "second"
            )
    )
    public static class Second {
        public int i = 2;
        public String name = "SecondSecond";
    }
}

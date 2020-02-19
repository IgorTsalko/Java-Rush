package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in = new BufferedReader(new FileReader(reader.readLine()))
        ) {
            while (in.ready()) {
                stringBuilder.append(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document document = Jsoup.parse(stringBuilder.toString(), "", Parser.xmlParser());
        Elements elem = document.select(args[0]);
        for (Element elements : elem){
            System.out.println(elements);
        }
    }
}

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class Solution {
////    E:/Java/Files/tags.html
//    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("<" + args[0] + "\\s*.*?>\\s*.*?\\s*</" + args[0] + ">");
//        try (
//                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//                FileReader in = new FileReader(reader.readLine())
//        ) {
//            StringBuilder data = new StringBuilder();
//            while (in.ready()) {
//                data.append((char)in.read());
//            }
//
//            Matcher matcher = pattern.matcher(data);
//            while (matcher.find()) {
//                printTag(pattern, matcher.group());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void printTag(Pattern pattern, String data) {
//        Matcher matcher = pattern.matcher(data);
//        if (matcher.find()) {
//            System.out.println(matcher.group().replaceAll("\r\n", ""));
//            printTag(pattern, matcher.group().substring(1));
//        }
//    }
//}

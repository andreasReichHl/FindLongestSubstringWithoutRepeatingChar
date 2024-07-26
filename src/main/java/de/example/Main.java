package de.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String s = "aabcajkb";
        String s1 = "bbbbb";
        String s3 = "pwwkewwkea";
        String s4 = "aa";

        System.out.println(findLongestWithHashMap(s3));
        System.out.println(findLongestWithList(s3));


    }


    public static String findLongestWithHashMap(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        int textLength = text.length();
        int maxLength = 0;
        int start = 0;
        int maxStart = 0;


        for (int end = 0; end < textLength; end++) {
            char c = text.charAt(end);

            if (map.containsKey(c)) {
                start = Math.max(map.get(c) + 1, start);
            }

            map.put(c, end);

            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                maxStart = start;
            }
        }

        return "Die Antwort ist " + text.substring(maxStart, maxStart + maxLength) + ", mit der Länge von " + maxLength;
    }

    public static String findLongestWithList(String text) {
        int start =0;
        int maxLength = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            list.clear();
            for (int j = i; j < text.length(); j++) {
                char c = text.charAt(j);
                if (list.contains(c)) {
                    break;
                }else {
                    list.add(c);
                    if(list.size() > maxLength){
                        maxLength = list.size();
                        start = i;
                    }
                }
            }

        }
        return "Die Antwort ist " + text.substring(start, start + maxLength) + ", mit der Länge von " + maxLength;
    }
}

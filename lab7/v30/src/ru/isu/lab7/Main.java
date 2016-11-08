package ru.isu.lab7;

import javax.swing.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static Set<String> polindroms(String text){
        Set<String> set=new LinkedHashSet<>();
        String[] words = text.split(" ");
        for (String word : words) {
            if(polindrom(word)){
                set.add(word);
            }
        }
        return set;
    }

    static boolean polindrom(String w){
        for (int i = 0; i < w.length(); i++) {
            if(w.charAt(i)!= w.charAt(w.length()-1-i)) return false;
        }
        return true;
    }


    public static boolean allEven(String s){
        for (char c : s.toCharArray()) {
            switch(c){
                case '2':
                case '4':
                case '6':
                case '8':
                case '0':
                    continue;
                default:
                    return false;
            }
        }
        return true;
    }
}

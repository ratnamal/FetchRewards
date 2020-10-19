package com.pyramid;

import java.util.*;

public class PyramidWord {

    //checks if a input string is a pyramid word
    //Returns "true" if the input string is a pyramid word else false
    static boolean checkPyramid(String str) {

        //check if string length is 1
        if(str.length() == 1)
            return true;

        //Move each character from the input string and it's frequency to a hash map
        HashMap<Character,Integer> m = new HashMap<Character, Integer>();
        for(int i=0;i< str.length();i++) {
            if(m.containsKey(str.charAt(i))) {
                m.put(str.charAt(i), m.get(str.charAt(i)) + 1);
            }
            else {
                m.put(str.charAt(i), 1);
            }
        }

        //Sort the Hash Map based on frequencies
        List<Map.Entry<Character,Integer>> entryList = new LinkedList<Map.Entry<Character, Integer>>(m.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        //Check for increasing frequencies
        int count=2;
        for(Map.Entry<Character,Integer> map: entryList) {
            if(map.getValue()+1 == count) {
                count++;
            }
            else
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        //enter an input string
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if(checkPyramid(input))
            System.out.println("Word is a pyramid word");
        else
            System.out.println("Word is not a pyramid word");
    }
}

package com.company;

import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.regex.Pattern;

public class NineWordGridInputTestDemo {

    public static Pattern pattern = Pattern.compile("^[0-9]?[0-9]");

    public final static Map<String, List<String>> digitAndLetterMap = new HashMap() {{
        put("0", new ArrayList<>());
        put("1", new ArrayList<>());
        put("2", Arrays.asList("A", "B", "C"));
        put("3", Arrays.asList("D", "E", "F"));
        put("4", Arrays.asList("G", "H", "I"));
        put("5", Arrays.asList("J", "K", "L"));
        put("6", Arrays.asList("M", "N", "O"));
        put("7", Arrays.asList("P", "Q", "R", "S"));
        put("8", Arrays.asList("T", "U", "V"));
        put("9", Arrays.asList("W", "X", "Y", "Z"));
    }};

    public static void main(String[] args) {
        System.out.println("Please input the digits from 0 to 99：");
        Scanner scaner = new Scanner(System.in);
        String inputValue = scaner.next();
        if (inputValue == null || "".equals(inputValue.trim())
                || !pattern.matcher(inputValue).matches()) {
            System.out.println("sorry, you input string is not valid！Please input the digits from 0 to 99.");
            return;
        }

        inputValue = inputValue.trim();

        List<String> firstNumLetters = new ArrayList<>();
        List<String> secondNumLetters = new ArrayList<>();

        firstNumLetters.addAll(digitAndLetterMap.get(String.valueOf(inputValue.charAt(0))));
        if (inputValue.length() > 1) {
            secondNumLetters.addAll(digitAndLetterMap.get(String.valueOf(inputValue.charAt(1))));
        }

        String result = "";
        if (firstNumLetters.size() == 0 && secondNumLetters.size() == 0) {

        } else if (firstNumLetters.size() == 0 && secondNumLetters.size() != 0) {
            for (String letter : secondNumLetters) {
                result = StringUtils.join(secondNumLetters, " ");
            }
        } else if (firstNumLetters.size() != 0 && secondNumLetters.size() == 0) {
            for (String letter : firstNumLetters) {
                result = StringUtils.join(firstNumLetters, " ");
            }
        } else {
            StringBuffer temp = new StringBuffer();
            for (String firstLetter : firstNumLetters) {
                for (String secondLetter : secondNumLetters) {
                    temp.append(firstLetter).append(secondLetter).append(" ");
                }
            }
            result = temp.toString();
        }
        System.out.println("The result according you input digits is：" + result.toLowerCase());
    }
}

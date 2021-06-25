package com.groovy.simple.unit1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SelectedJavaFood {

    private static List<String> foodList = Arrays.asList("山西面馆",
            "羊棒骨",
            "烧烤家的面",
            "黄焖鸡米饭",
            "不吃、饿着");

    public static void main(String[] args) {

        Random random = new Random();

        System.out.println(foodList.get(random.nextInt(foodList.size())));
    }
}

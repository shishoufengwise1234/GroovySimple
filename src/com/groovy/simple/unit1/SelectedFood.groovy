package com.groovy.simple.unit1

class SelectedFood {

    private static def foodList = [
            "山西面馆",
            "羊棒骨",
            "烧烤家的面",
            "黄焖鸡米饭",
            "不吃、饿着",
    ]


    static void main(String[] args) {

        Random random = new Random()

        println(foodList[random.nextInt(foodList.size())])
    }
}

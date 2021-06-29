package com.groovy.simple.unit1

import com.sun.tools.classfile.Dependencies

class GroovyMain {


    static void main(String[] args) {

//        GroovyTestInterface testInterface = new GroovyTestClass()
//        println(testInterface.getInterfaceName())
//
//        def r = testMethod(1, "张三")
//        def r2 = testMethod(false,0.3f)
//
//        println(r)
//        println(r2)
//
//        def r3 = testNoResultMethod(false,-0.3f)
//        println(r3)
//
//        testStringMethod()
//
//        testDataMethod()
//
//        testCollectionMethod()

        testClosureMethod()

    }

    //定义方法 可以不用指定类型
    static String testMethod(type, name){
        return "type  = $type , name = $name"
    }

    //定义方法可以不指定类型 但方法修饰必须使用 def 修饰
    static def testNoResultMethod(type,name){
        return "$type" + " , $name"
    }


    static void testStringMethod() {
        //单引号对应字符串
        def s = 'I am $ Dog'
        println(s)

        //使用 $ 处理引用 和 kotlin 一致
        def f = 5.0f
        def t = "I am $f , ${String.valueOf(f).charAt(0)} Dog"
        println(t)

        //'''三引号支持随意变换'''
        def m = '''I am
                Animal
                '''

        println(m)
    }

    static void testDataMethod() {

        //类型支持随意更改 与 Java 静态类型不同
        def m = ""
        m = 0.4f

        println(m)
    }

    //集合相关
    static void testCollectionMethod() {

        //list集合
        def l = [2, false, "-1", 0.4f, System.currentTimeMillis(), null]
        //访问的索引 超过集合长度 会自动填充数据 为null ， 不会出现数组下标越界问题
        l[10] = true

        for (i in l){
            println(i)
        }

        //map
        //map 使用 key:value 方式定义 使用 , 分割 key必须是String 类型 value 为任意类型 key 可以省略 " "
        def map = ["key1":-1,key2:false]
        for (i in map) {
            println("key = ${i.getKey()} , value = ${i.getValue()}")
        }

        //range
        // 带有步长的集合
        def r = 1..4
        println( " form = ${r.from} , ${r.to} ")
        for (i in r) {
            println(i)
        }

    }

    //闭包
    static void testClosureMethod() {

        def closure = {
            String param,int args ->{
                println(param + " "+ args)
            }
                return param + " : "+args
        }
        def a = closure("张三",1)
        closure.call("李四",3)

        println(a)

        //it 为闭包内置参数
        def closureNoParam = {
            println(" it =  $it")
        }
        closureNoParam("args")

        //如果 -> 左边为空 则没有参数，it 也不存在
        def closureNon = {
            -> println("text ")
        }

        closureNon()

        def list = ["text"]

        list.each {
            println(it)
        }

        //闭包调用方式
        text(1,"2",{
            println it
        })
        text 2,"3",{
            println it
        }
        text(3,"4"){

        }

        Dependencies
    }

    //方法最后一个参数如果是闭包 则可以省略 （）
    static def text(int i,String text,Closure closure){
        def v = i + text
        closure(v)
    }

}

package com.mybinance.demo;

import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static class Product {
        String a;
        public Product(String a) {
            this.a = a;
        }

//        @Override
//        public String toString(){
//            return a;
//        }
    }
    static class Food extends Product {
        public Food(String a) {
            super(a);
        }
    }
    static class Fruit extends Food {
        public Fruit(String a) {
            super(a);
        }
    }
    static class Apple extends Fruit {
        public Apple(String a) {
            super(a);
        }
    }

    // String extends Object - true
    // List<String> extends List<Object> - false

    // ? super Fruit - means that we expect Fruit or parents
    // ? extends Fruit - means that we expect Fruit or children

    // PECS (provider - extends, consumer - super)
    // if we expect to add to collection - we use super
    // if we expect to get from collection ONLY - we use "extends"

    // ("super" allow to write to collection supered type or any child,
    // but for read from collection we need to convert to type or read to object)
    // ("extends" forbid to write to collection,
    // but resolve to read from collection to extended type or any parent)

    public static void main(String[] args) {
//        List<? extends Fruit> fruits = new ArrayList<Food>();
//
//        fruits.add(new Fruit("f1"));    // compile error
//        fruits.add(new Apple("a1"));    // compile error

//        StringBuilder sb = new StringBuilder("String num 1");

        String s = "sss";

        TreeSet<String> treeSet = new TreeSet<>();




//        String s = "string";
//        System.out.println(s.getBytes(StandardCharsets.UTF_8));
//
//        String s4 = "This is a %d string";
//
//        String s1 = String.valueOf(32);
//        for(int i =0; i< 5; i++) {
//            System.out.println(String.format(s, i));
//        }


//        fruits = new ArrayList<Fruit>(); // compile success
//        fruits = new ArrayList<Apple>(); // compile success
//        fruits = new ArrayList<Food>(); // compile error
//        fruits = new ArrayList<? super Food>(); // ошибка компиляции: тип подстановочного знака не может быть создан

//        System.out.println(fruits.get(0));
//        System.out.println(fruits.get(1));
//        Fruit object = (Fruit) fruits.get(0);    // compile success
//        Fruit object1 = (Fruit) fruits.get(1);    // compile success
    }
}

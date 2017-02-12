package com.flash.interview;

/**
 *
 */
public class OverrideTest {

    static class Fruit {

    }
    static class FruitTree {

        public void doSomething(Fruit fruit) {

        }

    }

    static class Apple extends Fruit {

    }
    static class AppleTree extends FruitTree {

        @Override
        public void doSomething(Fruit fruit){

        }


        public void doSomething(Apple apple){

        }
    }

    public static void main(String[] args) {

    }
}

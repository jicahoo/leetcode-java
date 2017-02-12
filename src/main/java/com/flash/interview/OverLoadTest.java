package com.flash.interview;


/**
 * Created by zhangj52 on 2/12/2017.
 */
public class OverLoadTest {
    static class Fruit {

    }
    static class FruitTree {

        public void doSomething(Fruit fruit) {

        }

    }

    static class Apple extends Fruit {

    }
    static class AppleTree extends FruitTree {
        public void doSomething(Fruit fruit){

        }

        public void doSomething(Apple apple){

        }
    }


}

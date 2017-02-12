package com.flash.interview;

/**
 * Finally has the final word on return what.
 *
 * If the return in the try block is reached, it transfers control to the finally block, and the function eventually
 * returns normally (not a throw).

 * If an exception occurs, but then the code reaches a return from the catch block, control is transferred to the
 * finally block and the function eventually returns normally (not a throw).
 *
 *
 * finally will be called.  The only times finally won't be called are:
 * if you call System.exit() or
 * if the JVM crashes first
 * if there is an infinite loop in the try block
 * if the power turns off
 * Created by zhangj52 on 2/12/2017.
 */
public class TryCatchFinally {
    public static void testPriorityReturn() {
        try {
            System.out.println("Normal logic.");
            throw new NullPointerException();

        } catch (Exception e) {
            System.out.println("Exception logic.");
            return;
        } finally {
            System.out.println("Finally logic.");
            return;
        }
    }

    public static int testPriorityReturnOne() {
        try {
            System.out.println("Normal logic.");
            String str = null;
            //throw new NullPointerException();
            str.length();
            return 0;

        } catch (Exception e) {
            System.out.println("Exception logic.");
            return 1;
        } finally {
            System.out.println("Finally logic.");
            return 2;
        }
    }

    public static void main(String[] args) {
        TryCatchFinally.testPriorityReturn();
        System.out.println("=============================");
        System.out.println(TryCatchFinally.testPriorityReturnOne());//Will print 2.
    }
}

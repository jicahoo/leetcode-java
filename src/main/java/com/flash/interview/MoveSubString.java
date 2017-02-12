package com.flash.interview;

/**
 * Created by zhangj52 on 2/12/2017.
 */
public class MoveSubString {
    public static String moveCharInUniqueForwardNormalWay(String original, String unique) {
        //normal method.
        int idx = original.indexOf(unique);
        if (idx == -1 || idx == 0) {
            return original;
        }
        StringBuilder sb = new StringBuilder(unique);
        sb.append(original.substring(0, idx));
        sb.append(original.substring(idx + unique.length()));
        return sb.toString();
    }

    public static void main(String[] args) {
        String original = "elephant";
        String unique = "ant";
        System.out.println(MoveSubString.moveCharInUniqueForwardNormalWay(original, unique));

        original = "abc";
        unique = "d";
        System.out.println(MoveSubString.moveCharInUniqueForwardNormalWay(original, unique));

        unique = "d";
        System.out.println(MoveSubString.moveCharInUniqueForwardNormalWay(original, unique));

        original = "elephantgirl";
        unique = "ant";
        System.out.println(MoveSubString.moveCharInUniqueForwardNormalWay(original, unique));

    }
}

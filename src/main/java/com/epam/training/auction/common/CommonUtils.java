package com.epam.training.auction.common;

/**
 * Created by Ahmed Magdy <ahmed_magdy@epam.com> on 30.10.15.
 */
public final class CommonUtils {

    private CommonUtils(){}

    public static boolean areTwoObjectsEqual(Object obj1, Object obj2){
        if (obj1 == null && obj2 == null) return true;
        if (obj1 == null || obj2 == null) return false;
        return obj1.equals(obj1);
    }

    public static int getHashCode(Object obj){
        if (obj == null) return 0;
        return obj.hashCode();
    }
}

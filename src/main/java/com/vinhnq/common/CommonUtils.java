package com.vinhnq.common;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class CommonUtils {

    public static Float fixedFloat(float f) {
        return Float.parseFloat(String.format("%.2f", f));
    }

    public static String removeZero(Object input) {
        String strTmp = "";
        if (null == input) {
            return strTmp;
        } else {
            strTmp = input.toString().trim();
            strTmp = strTmp.contains(".") ? strTmp.replaceAll("0*$", "").replaceAll("\\.$", "") : strTmp;
            return strTmp;
        }
    }

    public static Integer round(Object input) {
        String strTmp = "";
        if (null == input) {
            return 0;
        } else {
            return Math.round((Float) input);
        }
    }
    public static boolean compare(Object o1, Object o2) {
        if(null == o1 && null == o2){
            return true;
        }
        if((null != o1 && null == o2) || (null == o1 && null != o2)){
            return false;
        }
        return String.valueOf(o1).equals(String.valueOf(o2));
    }


}

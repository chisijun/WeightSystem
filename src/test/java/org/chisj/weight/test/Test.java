package org.chisj.weight.test;

import java.math.BigDecimal;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2018-10-12 13:49
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Float priceCar = 12.356f;
        // 设置位数
        int scale = 2;
        // 表示四舍五入，可以选择其他舍值方式，例如去尾，等等.
        int roundingMode = 4;
        BigDecimal bd = new BigDecimal((float) priceCar);
        bd = bd.setScale(scale, roundingMode);
        priceCar = bd.floatValue();
        System.out.println(priceCar);
    }
}

package base

import org.codehaus.groovy.runtime.GStringImpl

/*
* 变量(皆为对象类型)
*/

void testVar1() {
    // 基本类型

    int var1 = 5
    println var1.class
    // class java.lang.Integer
    double var2 = 5
    println var2.class
    // class java.lang.Double
}

void testVar2() {
    // 弱类型(动态类型)

    def var1 = 5
    println var1.class
    // class java.lang.Integer
    var1 = 5.0
    println var1.class
    // class java.math.BigDecimal
    var1 = '123'
    println var1.class
    // class java.lang.String
}
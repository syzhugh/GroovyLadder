package closure
/*
* 闭包 使用详解
*/

/*
* 作用域
*/
def cOuter = {
    println 'cOuter'
}

cOuter1 = {
    println 'cOuter1'
}

void testScope() {
    def cInner = {
        println 'cInner'
    }
    cInner.call()
    cOuter1.call()
//    cannot call cOuter
}
//    cannot call cInner

/*
* 1 实现一个阶乘
*/

int fab1(int num) {
    int result = 1;
    1.upto(num, { cNum -> result *= cNum })
    return result
}

int fab2(int num) {
    int result = 1;

    num.times {
            // start with 0
        cNum -> result *= cNum + 1
    }
    return result
}

//println fab1(5)
//println fab2(5)

/*
* 2 string
*/

void testStr1() {
    String str = '1 2 3'
    println "\n" + str.each {
        print it.multiply(2)
    }
}

//testStr1()
/*
11  22  33
1 2 3
*/

void testStr2() {
    String str = 'x1 2 3'
    def closure = { it.isNumber() }
    println str.find(closure)
    println str.findAll(closure)
    println str.any(closure)
    println str.every(closure)
    println str.collect { it.toUpperCase() }.toString()
    println str.find() {
        // 看源码,这里一定需要一个逻辑结果
        print it.isNumber().toString().concat(' ')
//        it = true
    }
}
/*
1
[1, 2, 3]
true
false
[X, 1,  , 2,  , 3]
false true false true false true null
*/

/*
* 3 data structure
*/

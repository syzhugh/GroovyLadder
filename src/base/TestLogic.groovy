package base
/*
* 逻辑控制
*/

/**
 * switch/case in groovy
 */
void testSwitch() {
    def x = 9
    def result
    switch (x) {
        case 'str':
            result = 'String'
            break
    // 包含即可 class java.util.ArrayList
        case [1, 2, '3']:
            result = 'arr'
            break
    // 这个不行 class groovy.lang.IntRange
        case 1..10:
            result = 'range'
            break
        case Integer:
            result = 'Integer'
            break
        case BigDecimal:
            result = 'BigDecimal'
            break
    }
    println result
}

void testSwitch2() {
    def x = 1
    def result

    // 避免了 instanceOf的麻烦
    switch (x.class) {
        case Integer.class:
            result = 'Integer'
            break
    }
    println result
}

/**
 * for in groovy
 */
void testFor() {
    // range
    for (i in 0..9) {
        println i
    }

    //list
    for (i in [0, 1, 2, 3, 4]) {
        println i
    }

    //map
    for (i in ['1': 'a', '2': 'b', '3': 'c']) {
        println i
        println i.key + '_' + i.value
    }

    0.upto(2) {
        println("$it" + " ")
    }

    5.downto(0) {
        println "$it"
    }

    3.times {
        // start with 0
        println("$it" + " ")
    }

    5.step(10, 2) {
        println("$it" + " ")
    }
}

testFor()
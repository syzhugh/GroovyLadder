package collection
/*
* 范围
*
* 本质是list interface Range<T extends Comparable> extends List<T>
* */

void testInfo() {
    def range = 1..20
    def r1 = 'a'..'b'
    println range.class
    println r1.class
}
/*class groovy.lang.IntRange
class groovy.lang.ObjectRange*/

void testInfo1() {
    def range = 1..20
    println range[0]
    println range.contains(15)
    println range.from
    println range.to
}
/*
1
true
1
20*/

void testTraversal() {
    def range = 1..5
    // 推荐使用闭包
    range.each {
        println it
    }

    for (i in range) {
        println i
    }
}

String testSwitch() {
    int score = 70;
    String result;
    switch (score) {
        case 0..<60:
            result = '不及格'
            break
        case 60..<70:
            result = '及格'
            break
        case 70..<85:
            result = '良好'
            break
        case 85..100:
            result = '优秀'
            break
        default:
            result = 'error'
            break
    }
    return result
}
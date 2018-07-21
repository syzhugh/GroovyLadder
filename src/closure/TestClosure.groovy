package closure
/*
* 闭包 基础讲解
*/

/*
* test1 define
*/
def closure = {
    println 'a closure'
}

def c1 = {
    println "a closure with ${it}" //default param, null if invoke with no param
}

//closure.call()
// a closure
//c1.call()
// a closure with null
//c1.call('param')
// a closure with param

/*
* test 2 param
*/
def c2 = {
        // 类型检查
    String type, int num -> println "info: ${num} ${type}"
}
//c2.call("apple", 5)
// info: 5 apple

def c3 = {
        // 不检查参数
    type, num ->
        println "info: ${num} ${type}"
        println type.class
}
//c2.call(1, 1)
//groovy.lang.MissingMethodException
//c3.call(1, 1)
//info: 3 3

/*
* test 3 return
*/
def c4 = {
    return 'c4'
}
def c5 = {
}
//println c4.call()
// c4
//println c5.call()
// null
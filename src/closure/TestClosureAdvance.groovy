package closure
/*
* 闭包 进阶讲解
*/

/*
* 1.关键变量总结
*   1)this静态指向类class,非静态指向对象
*   2)closure发生嵌套时,owner不同于this,指向外部closure
*   3)delegate被指定时,会与owner不同 this owner不可指定
* */
def closure = {
    // 代表闭包定义处的类
    println "this:" + this
    // 代表闭包定义处的类 或者 对象
    println "owner:" + owner
    // 代表任意对象 默认同owner
    println "delegate:" + delegate
}
//closure.call()
/* 结果相同
this:TestClosureAdvance@6580cfdd
owner:TestClosureAdvance@6580cfdd
delegate:TestClosureAdvance@6580cfdd
*/

class Person {
    def static innerC = {
        println "this:" + this // class Person
        println "owner:" + owner // class Person
        println "delegate:" + delegate // class Person
    }

    def static innerC1 = {
        def innerC = {
            println "this:" + this // class Person
            println "owner:" + owner // Person$__clinit__closure3@1cbbffcd
            println "delegate:" + delegate // Person$__clinit__closure3@1cbbffcd
        }
        innerC.call()
    }

    static void test() {
        def innerC = {
            println "this:" + this // class Person
            println "owner:" + owner // class Person
            println "delegate:" + delegate // class Person
        }
        innerC.call()
    }
}

class Person1 {
    def innerC = {
        println "this:" + this // Person1@4ac3c60d
        println "owner:" + owner // Person1@4ac3c60d
        println "delegate:" + delegate // Person1@4ac3c60d
    }

    def innerC1 = {
        def innerC = {
            println "this:" + this  // Person1@4ac3c60d
            println "owner:" + owner // Person1$_closure2@27ce24aa
            println "delegate:" + delegate // Person1$_closure2@27ce24aa
        }
        innerC.call()
    }

    void test() {
        def innerC = {
            println "this:" + this // Person1@4ac3c60d
            println "owner:" + owner // Person1@4ac3c60d
            println "delegate:" + delegate // Person1@4ac3c60d
        }
        innerC.call()
    }

    def innerC2 = {
        def innerC = {
            println "this:" + this  // Person1@27ce24aa
            println "owner:" + owner // Person1$_closure3@619713e5
            println "delegate:" + delegate // Person1@27ce24aa
        }
        innerC.delegate = this
        innerC.call()
    }
}

/*
* 2.委托策略
*   Closure.DELEGATE_FIRST 没有对应属性会取owner
*   Closure.DELEGATE_ONLY 没有对应属性会报错
*
*   *遗留问题 为什么写在当前类会错...
* */

class C1 {
    String name = 'C1'
    def closure = {
        println name
    }

    @Override
    String toString() {
        closure.call()
    }
}

class C2 {
    static String name = 'C2'
}

def c1 = new C1()

c1.closure.delegate = C2.class
c1.closure.resolveStrategy = Closure.DELEGATE_FIRST
c1.toString()
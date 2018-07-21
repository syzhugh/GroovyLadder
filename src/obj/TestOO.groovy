package obj
/*
* 类
* */

class Person {
    String name
    int age
}

void testC() {
    def a = new Person(name: 'sun', age: 24)
    println a.getName()
}

/*
* 接口
* */

interface Run {
    void run()

    def run1()
}

/*
* trait 类似于接口和抽象类 几乎不用
* */

trait Run1 {
    abstract void eat()

    void run() {
        println 'run'
    }
}

class Person1 implements Run1 {
    @Override
    void eat() {
        println 'eat'
    }
}
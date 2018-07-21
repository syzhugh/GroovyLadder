package obj.meta
/*
* 元编程
*
* 1.一种RunTime行为
* method in class
*   method in metaClass
*       override methodMissing() or not
*           override invokeMethod() or not
*               throw MissingMethodException
* 2.意义
*   不修改不继承的前提下,对类的属性或方法做扩展
*
* 3.遗留问题
*   了解一下GroovyObject MetaClass
*
* */

class Person {

    String name
    int age

    Object methodMissing(String s, Object o) {
        return "methodMissing ${s} ${o}"
    }

    @Override
    Object invokeMethod(String s, Object o) {
        return "invokeMethod ${s} ${o}"
    }
}

/*
* groovy会自动生成field get方法
* */

void test() {
    println new Person(name: "sun", age: 24).getName()
}

/*
* 注入属性
* */

void testMeta() {
    Person.metaClass.sex = 'male'
    def person = new Person()
    person.sex = '123'
    println person.sex
}

/*
* 注入方法
* */

void testMeta1() {
    Person.metaClass.sex = 'male'
    Person.metaClass.upperSex = { sex.toUpperCase() }
    def person = new Person()
    println person.upperSex()
}

/*
* 注入静态方法
* */

void testMeta2() {
    Person.metaClass.static.getInfo = { println 'a Person instance' }
    Person.getInfo()
}

package obj.meta

/*
* 测试全局注入 ExpandoMetaClass.enableGlobally();
* */

class TestGlobal {
    static void main(String[] args) {
        println '程序启动'
        AppManager.init()
        println '程序初始化'
        PersonManager.Person person = PersonManager.createPerson("sun", 24)
        println "a person - name:${person.getName()} age:${person.getAge()} "
    }
}

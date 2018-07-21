package obj.meta

class AppManager {
    static void init() {
        ExpandoMetaClass.enableGlobally()
        PersonManager.metaClass.static.createPerson = {
            String name, int age ->
                return new PersonManager.Person(name: name, age: age)
        }
    }
}

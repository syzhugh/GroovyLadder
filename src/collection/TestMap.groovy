package collection
/*
* map
*
* */

/*
* map定义
* 1.key要使用不可变str '',不写默认''
* 2.不能使用.class
* */
color = [
        'red'  : 'ff0000',
        'green': '00ff00',
        'blue' : '0000ff'
]

void showInfo() {
    println color
    println color.getClass()
}
/*[red:ff0000, green:00ff00, blue:0000ff]
class java.util.LinkedHashMap*/

void selectEntry() {
    println color['red']
    println color.green
}
/*ff0000
00ff00*/

void addEntry() {
    println color.yellow
    color.yellow = color.red.concat(color.green)
    println color.yellow

    color.e1 = [1, 2, 3]
    color.e2 = [a: '1', b: '2']
    println color
}
/*null
ff000000ff00
[red:ff0000, green:00ff00, blue:0000ff, yellow:ff000000ff00, e1:[1, 2, 3], e2:[a:1, b:2]]*/

/*
* map 操作详解
* */

students = [
        1: [name: "s1", age: 10, score: 99],
        2: [name: "s2", age: 15, score: 59],
        3: [name: "s3", age: 20, score: 99]
]

void testTravelsal() {
    // 遍历
    students.each {
        println it.key + " " + it.value
    }
    // 带索引遍历
    students.eachWithIndex {
        def o, int index ->
            println index + " " + o.key + " " + o.value
    }
    // key value遍历
    students.eachWithIndex {
        key, value, int index ->
            println index + " " + key + " " + value
    }
}
/*1 [type:s1, age:10]
2 [type:s2, age:15]
3 [type:s3, age:20]

0 1 [type:s1, age:10]
1 2 [type:s2, age:15]
2 3 [type:s3, age:20]

0 1 [type:s1, age:10]
1 2 [type:s2, age:15]
2 3 [type:s3, age:20]*/

void testFind() {
    def map = (Map) students
    def c1 = {
        it.value.age > 10
    }
    println map.find(c1)
    println map.findAll(c1)
    println map.findAll(c1).findAll { it.value.score > 60 }
}
/*
2={type=s2, age=15, score=59}
[2:[type:s2, age:15, score:59], 3:[type:s3, age:20, score:99]]
[3:[type:s3, age:20, score:99]]*/

void testGroup() {
    def map = (LinkedHashMap) students
    println map.groupBy {
        return it.value.score > 60 ? '及格' : '不及格';
    }
}
/*[及格:[1:[type:s1, age:10, score:99], 3:[type:s3, age:20, score:99]], 不及格:[2:[type:s2, age:15, score:59]]]*/

void testSort() {
    def map = (LinkedHashMap) students
    // 返回一个新的map
    println map.sort {
        def stu1, stu2 ->
            Number v1 = stu1.value.score
            Number v2 = stu2.value.score
            return v1 == v2 ? 0 : v1 < v2 ? -1 : 1;
    }
}
/*
[2:[type:s2, age:15, score:59], 1:[type:s1, age:10, score:99], 3:[type:s3, age:20, score:99]]*/

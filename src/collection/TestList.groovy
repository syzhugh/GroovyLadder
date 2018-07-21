package collection
/*
* 列表
*
* ?遗留问题 closure return it > 0 与 it > 0 的区别
* -> 最后一行默认return,return更加符合代码规范
* */

/*
* 列表的定义,区别于java
* */
List list = new ArrayList()
def l1 = [1, 2, 3]
//println l1.class
// class java.util.ArrayList

/*
* 区别于数组
* */
def arr1 = [1, 2, 3] as int[]
int[] arr2 = [1, 2, 3]
//println arr1.class
//println arr2.class
// class [I

/*
* 列表的排序 java
* */
def l2 = [6, -3, 9, -4, 1, -7, 5]
Collections.sort(l2)
//println l2
// [-7, -4, -3, 1, 5, 6, 9]

Collections.sort(l2, { int a, int b ->
    a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1
})
//println l2
// [1, -3, -4, 5, 6, -7, 9]

/*
* 列表的排序 groovy
* */
def sort = l2.sort()
//println sort
// [-7, -4, -3, 1, 5, 6, 9]

def sort1 = l2.sort({ int a, int b ->
    a == b ? 0 : Math.abs(a) > Math.abs(b) ? -1 : 1
})
//println sort1
// [9, -7, 6, 5, -4, -3, 1]

def l3 = ['abc', 'ab', 'c']
//println l3.sort { return it.size() }
// [c, ab, abc]

/*
* 列表的查找
* */
def c1 = { return it % 2 == 0 }
def o1 = l2.find(c1)
//println o1
// 6

def o2 = l2.findAll(c1)
//println o2
// [6, -4]

def o3 = l2.any(c1)
//println o3
// true

def o4 = l2.every(c1)
//println o4
// false

def c2 = { return Math.abs(it) }
def o5 = l2.min(c2)
//println o5
// 1

def o6 = l2.max(c2)
//println o6
// 9

def o7 = l2.count { return it > 0 }
//println o7
// 4
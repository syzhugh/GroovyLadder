package base

import org.codehaus.groovy.runtime.DefaultGroovyMethods
import org.codehaus.groovy.runtime.StringGroovyMethods

/*
* 字符串
*/

void testString1() {
    String str1 = '123\'a\' '
    println str1 + str1.class
    // 123'a' class java.lang.String

    def str2 = '123\\a\\ '
    println str2 + str2.class
    // 123\a\ class java.lang.String

    // ''' ''' 具有格式
    def str3 = '''
line 1
    line 2
        line 3'''
    println str3 + str3.class
    /*
    * line 1
    *    line 2
    *       line 3class java.lang.String
    * */
}

/**
 * // GString 可扩展字符串
 */
void testString2() {
    def str0 = 'sun'
    def str1 = "hello ${str0} 0123 "
    println str1 + str1.class
    // hello sun 0123 class org.codehaus.groovy.runtime.GStringImpl

    println "the sum of 2 and 3 equals ${2 + 3}"
}

GString getGString(String str) {
    return str
}

String getGString(GString str) {
    return str
}

/**
 * 类型转换关系 String <- GString <- GStringImpl
 */
void testString3() {
//    println getGString("str").class
//    Cannot cast object 'str' with class 'java.lang.String' to class 'groovy.lang.GString'

    def str = "the sum of 2 and 3 equals ${2 + 3}"
    println str.class
    println getGString(str).class
}

/**
 * String的扩展:
 * 1.java.lang.String
 * 2.DefaultGroovyMethods
 * 3.StringGroovyMethods
 *  普通类型参数
 *  闭包类型参数
 */
void testString4() {
    def str = 'test123'

    println str.center(10, '|')
//    |testStr||
    println str.padLeft(10, 'l')
//    llltestStr

    def str1 = 'test1234'
    println str1 > str
//    true

    println str[0]
//    t
    println str[0..5]
//    test12

    println str1.minus(str)
//    4
    println str1.reverse()
//    4321tset
    println str1.capitalize()
//    Tst1234

    println '' + '123'.isNumber() + ' ' + ' t123 '.isNumber()
//    true false
}

testString4()
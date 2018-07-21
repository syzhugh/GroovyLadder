

/*Groovy语言特性*/

/*
* 1.Groovy默认导入以下包.
*
* */

//import java.lang.*  基本包，包括封装类型 String、System、Throwable、Exception等
//import java.util.*  包含数据结构与相关Exception
//import java.io.*    IO相关
//import java.net.*   NET相关
//
//import groovy.lang.*
//import groovy.util.*
//
//import java.math.BigInteger
//import java.math.BigDecimal

/*
* 3.GDK对JDK的扩展
*   对比Process调用
* */
try {
    Process process = Runtime.getRuntime().exec("groovy -v")
    def bufferedReader = new BufferedReader(new InputStreamReader(process.inputStream))
    String temp
    while ((temp = bufferedReader.readLine()) != null) {
        println(temp)
    }
    bufferedReader.close()
    process.destroy()
} catch (Exception e) {
    println(e.message)
}

println "groovy -v".execute().text

/*
* 4.安全操作导航符
*   ?.  不为空时分配调用
* */
String str = null
println(str?.charAt(0))

/*
* 5.异常处理
*   1)不会强制检查，不检查则上抛出
*   2）默认捕获Exception，不能处理Error Throwable
* */

def openFile() {
    new File("")
}

try {
    openFile()
} catch (e) {
    println(e.message)
}
package file.file

/*
* 文件操作
* 1.file使用with new开头的流方法
* 2.不再使用循环,改用闭包
*
* */

/*
* 1. 文件遍历
* */

void testTravelsal() {
    File file = new File('./TempFile.txt')
    file.eachLine {
        println it
    }

    println file.getText()

    println file.readLines()

    file.withReader {
        char[] buffer = new char[19]
        it.read(buffer)
        return buffer
    }
}

/*
* 2. 文件读写
* */

void testCopy() throws Exception {
    File file = new File('./TempFile.txt')
    File fileCopy = new File('./TempFileCopy.txt')

    file.withReader {
        def lines = it.readLines()
        fileCopy.withWriter { writer ->
            lines.eachWithIndex { String content, int i ->
                writer.append(content)
                if (i < lines.size() - 1) {
                    writer.newLine()
                }
            }
        }
    }
}

/*
* 3. obj读写
* */

def saveObj(Object obj, String path, String name) {
    try {
        def file = new File(path, name)
        file.withObjectOutputStream {
            it.writeObject(obj)
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
    return false
}

def readObj(String path) {
    try {
        def file = new File(path)
        return file.withObjectInputStream {
            it.readObject()
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
    return null
}

def testobj() {
    List l = [1, 2, 3, 4,]
    saveObj(l, './', 'obj.txt')
    println readObj('./obj.txt')
}
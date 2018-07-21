//normal
def product(n) {
    result = 1
    for (int i = 1; i <= n; i++) {
        result *= i
    }
    result
}

println product(5)

/* closure
 * 使用方法：1.即时创建 2.赋值给变量
 *
 * */
def closureSquare = {
    num ->
        total = 1
        for (i in 1..num) {
            total *= i
        }
        total
}

def getIteration(n, block) {
    for (i in 1..n) {
        println block(i)
    }
}

getIteration(5) { num -> num * num }
getIteration(5, closureSquare)

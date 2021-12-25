class BasicFunction {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    // 더 간단한 function
    fun sumSimple(a: Int, b: Int) = a + b

    // return 이 없는 function
    fun printSum(a: Int, b: Int): Unit {
        println("BasicFunction().printSum : sum of $a and $b is ${a + b}")
    }

    // return Unit 생략
    fun printSumNoReturn(a: Int, b: Int) {
        println("BasicFunction().printSumNoReturn : sum of $a and $b is ${a + b}")
    }
}

fun main(args: Array<String>) {
    //함수
    println("BasicFunction().sum(1,2) : " + BasicFunction().sum(1, 2))
    println("BasicFunction().sumSimple(1,2) : " + BasicFunction().sumSimple(1, 2))
    BasicFunction().printSum(1, 2)
    BasicFunction().printSumNoReturn(1, 2)
}
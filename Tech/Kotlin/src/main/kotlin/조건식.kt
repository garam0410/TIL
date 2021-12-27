class EtcBasic {
    // 기본 조건식
    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    // 코틀린 if 표현식
    fun maxOfSimple(a: Int, b: Int) = if (a > b) a else b
}

fun main(args: Array<String>) {
    println(EtcBasic().maxOf(1, 2))
    println(EtcBasic().maxOfSimple(1, 2))
}
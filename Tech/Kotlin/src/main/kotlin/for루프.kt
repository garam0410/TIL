class for루프 {
    // for loop (items를 문자열에 모두 더하여 return)

    val items = listOf("apple", "banana", "kiwifruit")

    fun basicFor(): Unit {
        var itemsStr: String = ""

        // 값으로 돌리기
        for (i: Int in 1..10)
            print("$i ")

        println()

        val len: Int = 5

        // 변수값으로 돌리기
        for (i: Int in 1..len)
            print("$i ")

        println()

        // until로 미만까지 돌리기
        for(i in 1 until len)
            print("$i ")

        println()

        // 증가 값 지정, step(변수) 도 가능, 음수는 안됌
        for(i:Int in 1..10 step 2)
            print("$i ")

        // 거꾸로
        for(i:Int in 9 downTo 0 step 3)
            print("$i ")
    }

    fun forLoop(): String {
        var itemsStr: String = ""

        for (item in items) {
            itemsStr += item
        }

        return itemsStr
    }

    // for loop 인덱스 포함
    fun forLoogWithIdx(): String {
        var itemsStr: String = ""

        for(idx in items.indices){
            itemsStr += items[idx]
        }

        return itemsStr
    }

    // while
    fun whileLoop(){
        var index = 0

        while(index < items.size){
            println("item idx : $index / item : ${items[index]}")
            index++
        }
    }
}

fun main(args: Array<String>){
    for루프().basicFor()

    println(for루프().forLoop())
    println(for루프().forLoogWithIdx())

    for루프().whileLoop()
}
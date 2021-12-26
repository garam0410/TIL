class Variables() {
    // val은 초기값 할당 후 값을 변경할 수 없음 (final, ReadOnly)
    fun variableVal() {
        val a: Int = 1 // 즉시 할당
        val b = 2   // 변수 타입을 지정하지 않았지만, Int형이 유추됨
        val c: Int // 값을 초기화 하지 않은 경우 타입 필요
        c = 3       // 초기값 지연 할당

        println("Variables.variableVal - a : ${a}, b : ${b}, c : ${c}")
    }

    // var는 재할당 할 수 있는 변수
    fun valiableVar(){
        var x = 5
        x += 1
        println("x : ${x}")
    }
}

fun main(args: Array<String>){
    //변수
    Variables().variableVal()
    Variables().valiableVar()
}
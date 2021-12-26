fun printStringTemplete(){
    var a = 1
    val s1 = "a is $a"
    a = 2
    val s2 = "${s1.replace("is","was")}, but now is $a"

    println("s1 : $s1")
    println("s2 : $s2")
}

fun main(args: Array<String>){
    // String 템플릿
    printStringTemplete()
}
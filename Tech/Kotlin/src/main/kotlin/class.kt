
// 클래스 정의
class BasicClass

// 클래스의 속성은 선언 또는 본문에 나열 가능
class Rectangle(var height : Double, var length : Double){
    var perimeter = (height + length) * 2
}

// 클래스를 상속 가능하게 하려면 open을 붙인다.
open class OpenClass(){
    var two : Int = 2
}

// 클래스의 속성은 선언 또는 본문에 나열될 수 있다.
class OpenRectangle(var height : Double, var length : Double) : OpenClass(){
    var perimeter = (height + length) * 2
}

fun main(args : Array<String>){
    // 클래스 변수 선언
    println("직사각형의 둘레 : " + Rectangle(5.0,2.0).perimeter)

    // 상속 클래스
    println("상속 직사각형의 둘레 : " + OpenRectangle(5.0,2.0).perimeter)
}
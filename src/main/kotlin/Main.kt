fun main(args: Array<String>) {
    val ivan = Person("Ivan", null)
    // let()
    ivan.email?.let { println(it) }
    // если идет обращение только к it
    ivan.email?.let(::println)
    // без let()
    if(ivan.email != null) println(ivan.email)

    // with()
    val oleg = Person("Oleg", null)
    val result = with(oleg) {
        if(email == null)
            email = "oleg@defult.ru"
        email
    }

    // run()
    // похож на with(), но реализован как функция расширения
    val obj = MyClass(12,3)
    obj.action()
    obj.action2()

    val masha = Person("Masha", null)
    val res2 = masha.run {
        if(email == null)
            email = "masha@masha.ru"
        email
    }
    println(res2)

    run { println("123123") }

    // apply()
    // можно использовать при построении объекта в виде паттерна Builder
    val aaa = Worker()
    aaa.name("AAA")
    aaa.age(20)

    val aaa2 = Worker()
    aaa2.age(22)

    // also()
    val max = Person("Max", null)
    max.also {
        if(it.email == null)
            it.email = "max@max.ru"
    }
    println(max.email)

}
data class Worker(var name: String = "", var age: Int = 0) {
    fun name(_name: String): Worker = apply { name = _name }
    fun age(_age: Int): Worker = apply { age = _age }
}
data class Person(val name: String, var email: String?)
class MyClass(val a: Int = 0, val b: Int = 0) {
    fun action() {
        println(a-b)
    }
}
fun MyClass.action2() {
    println((a+b)*100)
}

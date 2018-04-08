package example

class LazyUser {

    val name: String by lazy {
        println("I'm lazy")
        "Mr.Lazy"
    }

}

fun main(args: Array<String>) {
    val user = LazyUser()
    println(user.name)
    println(user.name)
}
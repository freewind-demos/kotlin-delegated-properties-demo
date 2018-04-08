package example

fun main(args: Array<String>) {
    val lazyString by lazy {
        println("I'm lazy")
        "lazy-string"
    }
    println(lazyString)
    println(lazyString)
}
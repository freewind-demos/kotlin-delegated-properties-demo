package example

import kotlin.properties.Delegates

class User {
    var name: String by Delegates.notNull()
}

fun main(args: Array<String>) {
    val user = User()

    // IllegalStateException:
    // Property name should be initialized before get.
    // println(user.name)

    user.name = "good-name"
    println(user.name)
}
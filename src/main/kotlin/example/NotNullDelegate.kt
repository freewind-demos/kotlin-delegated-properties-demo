package example

import kotlin.properties.Delegates

class NotNullUser {
    var name: String by Delegates.notNull()
}

fun main(args: Array<String>) {
    val user = NotNullUser()
    println(user.name)
//    user.name = "good-name"
//    println(user.name)
}
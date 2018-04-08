package example

import kotlin.properties.Delegates

class VetoableUser {
    var name: String by Delegates.vetoable("init-name") { property, oldValue, newValue ->
        println("${property.name} want to change: $oldValue -> $newValue, but rejected")
        false
    }
}

fun main(args: Array<String>) {
    val user = VetoableUser()
    println(user.name)
    user.name = "new-name"
    println(user.name)
}
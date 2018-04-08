package example

import kotlin.properties.Delegates

class ObservableUser {
    var name: String by Delegates.observable("init-name") { property, oldValue, newValue ->
        println("${property.name} changed: $oldValue -> $newValue")
    }
}

fun main(args: Array<String>) {
    val user = ObservableUser()
    println(user.name)
    user.name = "new-name"
    println(user.name)
}
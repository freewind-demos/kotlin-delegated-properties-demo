package example

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


class MyDelegate<in R> : ReadOnlyProperty<R, String> {
    override fun getValue(thisRef: R, property: KProperty<*>): String {
        return "$thisRef.${property.name}"
    }

}

class MyUser {
    val name by MyDelegate<MyUser>()
}

fun main(args: Array<String>) {
    val user = MyUser()
    println(user.name)
}
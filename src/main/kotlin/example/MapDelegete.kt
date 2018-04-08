package example

class MapUser(map: Map<String, String>) {
    val name: String by map
}

fun main(args: Array<String>) {
    val user = MapUser(mapOf("name" to "Freewind", "other" to "other"))
    println(user.name)
}
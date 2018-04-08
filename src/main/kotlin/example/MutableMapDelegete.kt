package example

class MutableMapUser(map: MutableMap<String, String>) {
    var name: String by map
}

fun main(args: Array<String>) {
    val map = LinkedHashMap<String, String>().apply { putAll(mapOf("name" to "Freewind", "other" to "other")) }
    val user = MutableMapUser(map)
    user.name = "Lily"
    println(map)
}
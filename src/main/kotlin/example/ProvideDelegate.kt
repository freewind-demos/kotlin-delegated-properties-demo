package example

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


// The demo is not good
// see: https://kotlinlang.org/docs/reference/delegated-properties.html#providing-a-delegate-since-11

class ResourceID<T>(var value: T) {
    companion object {
        val image_id = ResourceID("image_id")
        val text_id = ResourceID(123)
    }
}

class ResourceDelegate<T>(val v: T) : ReadOnlyProperty<MyUI, T> {
    override fun getValue(thisRef: MyUI, property: KProperty<*>): T {
        println("$thisRef -> ${property.name}")
        return v
    }
}

class ResourceLoader<T>(var id: ResourceID<T>) {
    operator fun provideDelegate(
            thisRef: MyUI,
            prop: KProperty<*>
    ): ReadOnlyProperty<MyUI, T> {
        checkProperty(thisRef, prop.name)
        // create delegate
        return ResourceDelegate(id.value)
    }

    private fun checkProperty(thisRef: MyUI, name: String) {
        if (name.startsWith("image")) {
            throw Exception("Image not supported")
        }
    }
}

class MyUI {
    fun <T> bindResource(id: ResourceID<T>): ResourceLoader<T> {
        return ResourceLoader(id)
    }

    val image by bindResource(ResourceID.image_id)
    val text by bindResource(ResourceID.text_id)
}
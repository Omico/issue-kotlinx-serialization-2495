import attribute.Attribute
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

val dataSerializersModule: SerializersModule =
    SerializersModule {
        polymorphic(Attribute::class) {
            subclass(CharacterHitDamage::class)
        }
    }

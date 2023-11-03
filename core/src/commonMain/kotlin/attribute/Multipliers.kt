package attribute

import foundation.MapifySerializer
import foundation.Percentage
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer

typealias Multipliers = List<Multiplier>

@Serializable(MultiplierSerializer::class)
data class Multiplier(
    private val map: Map<Int, Percentage>,
) : Map<Int, Percentage> by map

fun Multiplier(vararg pairs: Pair<Int, Percentage>): Multiplier = Multiplier(map = pairs.toMap())

// Cannot use private keyword here
private object MultiplierSerializer : MapifySerializer<Multiplier, Int, Percentage>(
    keySerializer = Int.serializer(),
    valueSerializer = Percentage.serializer(),
) {
    override fun deserialize(map: Map<Int, Percentage>): Multiplier = Multiplier(map = map)
    override fun serialize(value: Multiplier): Map<Int, Percentage> = value.toMap()
}

// private keyword can be used here
// private object MultiplierSerializer : KSerializer<Multiplier> {
//    private val mapSerializer: KSerializer<Map<Int, Percentage>> =
//        MapSerializer(
//            keySerializer = Int.serializer(),
//            valueSerializer = Percentage.serializer(),
//        )
//
//    override val descriptor: SerialDescriptor = mapSerializer.descriptor
//
//    override fun deserialize(decoder: Decoder): Multiplier =
//        Multiplier(
//            map = decoder.decodeSerializableValue(mapSerializer),
//        )
//
//    override fun serialize(encoder: Encoder, value: Multiplier): Unit =
//        encoder.encodeSerializableValue(
//            serializer = mapSerializer,
//            value = value,
//        )
// }

package foundation

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

abstract class MapifySerializer<T : Any, Key, Value>(
    keySerializer: KSerializer<Key>,
    valueSerializer: KSerializer<Value>,
) : KSerializer<T> {
    abstract fun deserialize(map: Map<Key, Value>): T
    abstract fun serialize(value: T): Map<Key, Value>

    private val mapSerializer: KSerializer<Map<Key, Value>> =
        MapSerializer(
            keySerializer = keySerializer,
            valueSerializer = valueSerializer,
        )

    override val descriptor: SerialDescriptor = mapSerializer.descriptor

    override fun deserialize(decoder: Decoder): T = deserialize(decoder.decodeSerializableValue(mapSerializer))

    override fun serialize(encoder: Encoder, value: T): Unit =
        encoder.encodeSerializableValue(
            serializer = mapSerializer,
            value = serialize(value),
        )
}

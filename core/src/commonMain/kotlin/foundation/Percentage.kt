package foundation

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class Percentage(
    val value: Double,
)

inline val Number.percent: Percentage
    get() = Percentage(toDouble())

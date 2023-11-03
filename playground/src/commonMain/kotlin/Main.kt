import attribute.Multiplier
import foundation.percent
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun main() {
    val test1 = setOf(
        CharacterHitDamage(
            number = 1,
            multiplier = Multiplier(
                1 to 39.65.percent,
                2 to 42.87.percent,
            ),
        ),
    )
    println(prettyJson.encodeToString(test1))
}

private val prettyJson: Json =
    Json {
        prettyPrint = true
        serializersModule = dataSerializersModule
    }

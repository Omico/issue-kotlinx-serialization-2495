import attribute.Attribute
import attribute.Multiplier
import attribute.Multipliers
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("character_hit_damage")
data class CharacterHitDamage(
    private val number: Int,
    private val multipliers: Multipliers,
) : Attribute

fun CharacterHitDamage(
    number: Int,
    multiplier: Multiplier,
): CharacterHitDamage =
    CharacterHitDamage(
        number = number,
        multipliers = listOf(multiplier),
    )

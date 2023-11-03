plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin {
    jvm()
}

dependencies {
    commonMainImplementation(kotlinx.serialization.json)
}

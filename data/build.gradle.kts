plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin {
    jvm()
}

dependencies {
    commonMainImplementation(project(":core"))
    commonMainImplementation(kotlinx.serialization.json)
}

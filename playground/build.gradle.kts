plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin {
    jvm()
}

dependencies {
    commonMainImplementation(project(":core"))
    commonMainImplementation(project(":data"))
    commonMainImplementation(kotlinx.serialization.json)
}

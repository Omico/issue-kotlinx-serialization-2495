import me.omico.consensus.dsl.requireRootProject

plugins {
    id("me.omico.consensus.spotless")
}

requireRootProject()

consensus {
    spotless {
        allprojects {
            kotlin()
            kotlinGradle()
        }
        rootProject {
            freshmark()
            gradleProperties()
        }
    }
}

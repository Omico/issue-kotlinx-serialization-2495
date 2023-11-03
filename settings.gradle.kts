rootProject.name = "gpi-root"

pluginManagement {
    includeBuild("build-logic/initialization")
}

plugins {
    id("gpi")
}

include(":core")
include(":data")
include(":playground")

plugins {
    kotlin("jvm") version "2.2.21"
}

group = "nl.mnijdam"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-engine:6.0.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:6.0.1")
    testImplementation("org.assertj:assertj-core:3.27.6")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
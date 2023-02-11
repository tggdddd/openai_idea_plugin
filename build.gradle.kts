buildscript {
    dependencies {
        classpath("com.theokanning.openai-gpt3-java:client:0.9.0")
    }
}
plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.10.1"
    id("application")
}
dependencies {
    implementation("com.theokanning.openai-gpt3-java:client:0.9.0")
}
group = "icu.stopit"
version = "1.1-SNAPSHOT"

repositories {
    mavenCentral()
}
// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2022.1.4")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(
            /* Plugin Dependencies */))
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
    patchPluginXml {
        sinceBuild.set("221")
        untilBuild.set("231.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}

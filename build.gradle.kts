import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

val ktor_version = "1.6.0"
val junit_version = "5.7.2"

group = "no.nav"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_15
    targetCompatibility = JavaVersion.VERSION_15
}

dependencies {
    // Server
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-jetty:$ktor_version")
    implementation("org.apache.kafka:kafka-clients:2.7.0")

    // Logging
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("net.logstash.logback:logstash-logback-encoder:5.1")

    // Test
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit_version")
}

tasks {

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "15"
    }

    named<KotlinCompile>("compileTestKotlin") {
        kotlinOptions.jvmTarget = "15"
    }

    withType<Test> {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }

    withType<ShadowJar> {
        archiveBaseName.set("app")
        archiveClassifier.set("")
        mergeServiceFiles()
        manifest {
            attributes(
                mapOf(
                    "Main-Class" to "no.nav.AppKt"
                )
            )
        }
    }

    withType<Wrapper> {
        gradleVersion = "7.1"
    }

}

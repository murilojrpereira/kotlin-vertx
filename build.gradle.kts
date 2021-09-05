import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
}

group = "me.factorypal"
version = "1.0-SNAPSHOT"
val vertxVersion = "4.0.0"
val junitJupiterVersion = "5.7.0"
val flywayVersion = "6.5.3"
val log4jVersion = "2.14.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("io.vertx:vertx-stack-depchain:$vertxVersion"))
    implementation("io.vertx:vertx-web")
    implementation("io.vertx:vertx-web-client")
    implementation("io.vertx:vertx-service-proxy")
    implementation("io.vertx:vertx-config")
    implementation("io.vertx:vertx-lang-kotlin")
    implementation("io.vertx:vertx-lang-kotlin-coroutines")
    implementation("io.vertx:vertx-pg-client")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-api:$log4jVersion")
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("org.postgresql:postgresql:42.2.14")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.2.3")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.+")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.6.5")
    testImplementation("io.vertx:vertx-junit5")
    testImplementation("com.opentable.components:otj-pg-embedded:0.13.3")
    testImplementation("org.flywaydb:flyway-core:$flywayVersion")
    testImplementation("io.vertx:vertx-web-client")
    testImplementation("org.mockito:mockito-core:3.7.7")
    testImplementation("org.assertj:assertj-core:3.19.0")

    compileOnly("io.vertx:vertx-codegen:$vertxVersion")
    testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}


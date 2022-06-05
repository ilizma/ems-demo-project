plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    // region Rx
    implementation(Rx.java)
    // endregion

    // region Kotlin
    implementation(Kotlin.datetime)
    // endregion

    // region Test
    testImplementation(Test.mockk)
    testImplementation(Test.junitApi)
    testRuntimeOnly(Test.junitEngine)
    // endregion

    // region Ems
    implementation(project(":ems-domain"))
    implementation(project(":ems-data"))
    // endregion

    // region Api
    implementation(project(":api"))
    // endregion
}
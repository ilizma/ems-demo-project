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

    // region Dashboard
    implementation(project(":dashboard-domain"))
    // endregion

    // region Test
    testImplementation(Test.mockk)
    testImplementation(Test.junitApi)
    testRuntimeOnly(Test.junitEngine)
    // endregion
}

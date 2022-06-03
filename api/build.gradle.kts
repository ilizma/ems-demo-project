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

    // region Network
    implementation(Network.gson)
    // endregion
}
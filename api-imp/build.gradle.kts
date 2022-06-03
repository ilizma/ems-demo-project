plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdk
    }

}

dependencies {
    // region Rx
    implementation(Rx.java)
    // endregion

    // region Network
    implementation(Network.moshi)
    // endregion

    // region Api
    implementation(project(":api"))
    // endregion
}
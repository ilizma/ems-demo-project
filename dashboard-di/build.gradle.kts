plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdk
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

}

dependencies {
    // region Di
    implementation(Di.hilt)
    kapt(Di.compiler)
    // endregion

    // region Android
    implementation(AndroidKtx.fragment)
    // endregion

    // region Base
    implementation(project(":di-base"))
    implementation(project(":presentation-base"))
    // endregion

    // region Menu
    implementation(project(":dashboard-view"))
    implementation(project(":dashboard-view-imp"))
    // endregion
}

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdk
    }

    viewBinding {
        isEnabled = true
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
    implementation(Android.appcompat)
    implementation(AndroidUI.material)
    // endregion

    // region Architecture
    implementation(Architecture.navigationFragment)
    // endregion

    // region Base
    implementation(project(":view-base"))
    // endregion

    // region Dashboard
    implementation(project(":dashboard-view"))
    // endregion
}

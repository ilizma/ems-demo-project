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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
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
    implementation(AndroidUI.constraintLayout)
    implementation(AndroidUI.material)
    // endregion

    // region Architecture
    implementation(Architecture.navigationFragment)
    // endregion

    // region Base
    implementation(project(":view-base"))
    // endregion

    // region App
    implementation(project(":app-flow"))
    // endregion

    // region Resources
    implementation(project(":resources"))
    // endregion
}

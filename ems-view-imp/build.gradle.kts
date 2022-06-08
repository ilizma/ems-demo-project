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
        testInstrumentationRunner = ConfigData.testInstrumentationRunner
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
    }

}

dependencies {
    // region Di
    implementation(Di.hilt)
    kapt(Di.compiler)
    // endregion

    // region Rx
    implementation(Rx.java)
    // endregion

    // region Android
    implementation(AndroidUI.material)
    implementation(AndroidUI.recyclerview)
    // endregion

    // region AndroidKtx
    implementation(AndroidKtx.core)
    // endregion

    // region Ui
    implementation(UI.chart)
    implementation(UI.shimmer)
    // endregion

    // region Base
    implementation(project(":view-base"))
    // endregion

    // region Resources
    implementation(project(":resources"))
    // endregion

    // region Ems
    implementation(project(":ems-view"))
    implementation(project(":ems-presentation"))
    // endregion
}

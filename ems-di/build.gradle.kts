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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
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
    implementation(AndroidUI.recyclerview)
    implementation(AndroidKtx.fragment)
    // endregion

    // region Architecture
    implementation(Architecture.navigationFragment)
    // endregion

    // region Base
    implementation(project(":presentation-base"))
    // endregion

    // region Api
    implementation(project(":api"))
    // endregion

    // region Ems
    implementation(project(":ems-flow"))
    implementation(project(":ems-flow-imp"))
    implementation(project(":ems-view"))
    implementation(project(":ems-view-imp"))
    implementation(project(":ems-presentation"))
    implementation(project(":ems-presentation-imp"))
    implementation(project(":ems-domain"))
    implementation(project(":ems-domain-imp"))
    implementation(project(":ems-data"))
    implementation(project(":ems-data-imp"))
    // endregion
}

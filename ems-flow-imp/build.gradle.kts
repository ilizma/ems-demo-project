plugins {
    id("com.android.library")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdk
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
    }

}

dependencies {
    //region Android // TODO: check 
    implementation(Android.appcompat)
    implementation(Android.activity)
    // endregion

    //region Architecture
    implementation(Architecture.lifecycleCommon) // TODO: check
    implementation(Architecture.navigationFragment)
    // endregion

    //region App
    implementation(project(":app-flow"))
    // endregion

    //region Ems
    implementation(project(":ems-flow"))
    implementation(project(":ems-view"))
    implementation(project(":ems-presentation"))
    // endregion
}

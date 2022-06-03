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

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

}

dependencies {
    // region Architecture
    implementation(Architecture.lifecycleViewModel)
    implementation(Architecture.lifecycleLivedata)
    // endregion

    // region Annotation
    implementation(Annotation.annotation)
    // endregion
}
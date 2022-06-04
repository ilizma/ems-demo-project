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

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

}

dependencies {
    // region Di
    implementation(Di.hilt)
    kapt(Di.compiler)
    // endregion

    // region Rx
    implementation(Rx.java)
    implementation(Rx.kotlin)
    // endregion

    // Architecture
    implementation(Architecture.lifecycleViewModel)
    implementation(Architecture.lifecycleLivedata)
    // endregion

    // region Test
    testImplementation(Test.mockk)
    testImplementation(Test.junitApi)
    testRuntimeOnly(Test.junitEngine)
    testImplementation(project(":test-base"))
    // endregion

    // region Base
    implementation(project(":presentation-base"))
    // endregion

    // region Dashboard
    implementation(project(":dashboard-presentation"))
    implementation(project(":dashboard-domain"))
    // endregion
}
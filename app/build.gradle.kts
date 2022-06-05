plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.ilizma.ems"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdk
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
        testInstrumentationRunner = ConfigData.testInstrumentationRunner
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        getByName("debug")
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

}

dependencies {
    implementation(Di.hilt)
    kapt(Di.compiler)
    implementation(Android.v4)
    implementation(CustomActivityOnCrash.customactivityoncrash)
    implementation(Network.moshi)

    // region Api
    implementation(project(":api-di"))
    implementation(project(":api"))
    implementation(project(":api-imp"))
    // endregion

    // region Base
    implementation(project(":view-base"))
    implementation(project(":presentation-base"))
    // endregion

    // regionResources
    implementation(project(":resources"))
    // endregion

    // region App
    implementation(project(":app-di"))
    implementation(project(":app-flow"))
    implementation(project(":app-view"))
    // endregion

    // region Error Management
    implementation(project(":error-management-di"))
    implementation(project(":error-management-view"))
    implementation(project(":error-management-view-imp"))
    // endregion

    // region Ems
    implementation(project(":ems-di"))
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

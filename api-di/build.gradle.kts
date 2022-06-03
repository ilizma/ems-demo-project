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

    // region Base
    implementation(project(":di-base"))
    // endregion

    // region Api
    implementation(project(":api"))
    implementation(project(":api-imp"))
    // endregion

    // region Network
    implementation(Network.moshi)
    implementation(Network.moshiKotlin)
    // endregion
}

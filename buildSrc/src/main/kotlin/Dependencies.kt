object Project {
    val buildGradle by lazy { "com.android.tools.build:gradle:${Versions.buildGradleVersion}" }
    val kotlinGradle by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}" }
    val navigation by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}" }
    val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}" }
}

object Rx {
    val kotlin by lazy { "io.reactivex.rxjava3:rxkotlin:${Versions.rxKotlinVersion}" }
    val java by lazy { "io.reactivex.rxjava3:rxjava:${Versions.rxJavaVersion}" }
    val binding by lazy { "com.jakewharton.rxbinding4:rxbinding:${Versions.rxBindingVersion}" }
}

object Android {
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.supportVersion}" }
    val v4 by lazy { "androidx.legacy:legacy-support-v4:${Versions.legacyVersion}" }
    val activity by lazy { "androidx.activity:activity:${Versions.activityVersion}" }
}

object AndroidKtx {
    val core by lazy { "androidx.core:core-ktx:${Versions.coreKtxVersion}" }
    val fragment by lazy { "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}" }
}

object AndroidUI {
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}" }
    val recyclerview by lazy { "androidx.recyclerview:recyclerview:${Versions.recyclerviewVersion}" }
    val material by lazy { "com.google.android.material:material:${Versions.materialVersion}" }
    val shimmer by lazy { "com.facebook.shimmer:shimmer:${Versions.shimmerVersion}" }
    val lottie by lazy { "com.airbnb.android:lottie:${Versions.lottieVersion}" }
}

object Architecture {
    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}" }
    val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}" }
    val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycleVersion}" }
    val lifecycleCommon by lazy { "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}" }
    val lifecycleViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}" }
    val lifecycleLivedata by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}" }
    val lifecycleReactivestreams by lazy { "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.lifecycleVersion}" }
}

object CustomActivityOnCrash {
    val customactivityoncrash by lazy { "cat.ereza:customactivityoncrash:${Versions.customactivityoncrashVersion}" }
}

object Network {
    val gson by lazy { "com.google.code.gson:gson:${Versions.gsonVersion}" }
}

object Di {
    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hiltVersion}" }
    val compiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}" }
}

object Annotation {
    val annotation by lazy { "androidx.annotation:annotation:${Versions.annotationVersion}" }
}

object Test {
    val mockk by lazy { "io.mockk:mockk:${Versions.mockkVersion}" }
    val junit by lazy { "junit:junit:${Versions.junitVersion}" }
    val runner by lazy { "androidx.test:runner:${Versions.supportTestVersion}" }
    val rules by lazy { "androidx.test:rules:${Versions.supportTestVersion}" }
    val core by lazy { "androidx.test:core:${Versions.testCoreVersion}" }
    val extJunit by lazy { "androidx.test.ext:junit:${Versions.testExtJunitVersion}" }
}

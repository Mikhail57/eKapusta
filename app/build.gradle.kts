plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

android {
    compileSdkVersion(30)

    defaultConfig {
        applicationId = "org.ekapusta.zaemonline"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dexOptions {
        preDexLibraries = true
        javaMaxHeapSize = "4g"
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    buildFeatures {
        viewBinding = true
    }
}

val daggerVersion: String by project

dependencies {
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")

    implementation("com.google.android.material:material:1.2.1")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.0-beta01")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1")

    // Navigation
    implementation("com.github.terrakok:cicerone:6.4")

    // AppMetrica SDK
    implementation("com.yandex.android:mobmetricalib:3.16.1")

    // My Tracker SDK
    implementation("com.my.tracker:mytracker-sdk:2.0.10")

    // Facebook SDK
    implementation("com.facebook.android:facebook-android-sdk:8.1.0")

    // Crashlytics
    implementation("com.google.firebase:firebase-crashlytics:17.3.0")

    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:26.1.0"))

    // Declare the dependency for the Analytics library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-analytics-ktx")

    // Dagger2
    implementation("com.google.dagger:hilt-android:$daggerVersion") {
        exclude(group = "javax.annotation", module = "jsr250-api")
    }
    kapt("com.google.dagger:hilt-compiler:$daggerVersion")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02")

    // Assisted inject for Dagger 2
    compileOnly("com.squareup.inject:assisted-inject-annotations-dagger2:0.5.2")
    kapt("com.squareup.inject:assisted-inject-processor-dagger2:0.5.2")

    // Networking
    implementation("io.ktor:ktor-client-okhttp:1.4.0")
    implementation("io.ktor:ktor-client-serialization-jvm:1.4.0")

    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("com.github.mukeshsolanki:android-otpview-pinview:2.1.2")

    implementation("androidx.datastore:datastore-preferences:1.0.0-alpha04")

    testImplementation("junit:junit:4.13.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}

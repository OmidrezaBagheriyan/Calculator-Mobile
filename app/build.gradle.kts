plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.omidrezabagheriyan.calculatormobile"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.omidrezabagheriyan.calculatormobile"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Components module
    implementation(project(mapOf("path" to ":components")))

    // Basic dependencies
    val coreVersion = "1.12.0"
    implementation("androidx.core:core-ktx:$coreVersion")
    val lifecycleVersion = "2.6.2"
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    val activityComposeVersion = "1.7.2"
    implementation("androidx.activity:activity-compose:$activityComposeVersion")
    val composeBomVersion = "2023.03.00"
    val platform = platform("androidx.compose:compose-bom:$composeBomVersion")
    implementation(platform)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    val junitVersion = "4.13.2"
    testImplementation("junit:junit:$junitVersion")
    val extJunitVersion = "1.1.5"
    androidTestImplementation("androidx.test.ext:junit:$extJunitVersion")
    val espressoCoreVersion = "3.5.1"
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoCoreVersion")
    androidTestImplementation(platform)
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.omidrezabagheriyan.components"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    // Compose dependencies
    val activityComposeVersion = "1.7.2"
    implementation("androidx.activity:activity-compose:$activityComposeVersion")
    val composeBomVersion = "2023.03.00"
    val platform = platform("androidx.compose:compose-bom:$composeBomVersion")
    implementation(platform)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    androidTestImplementation(platform)
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Basic dependencies
    val coreVersion = "1.12.0"
    implementation("androidx.core:core-ktx:$coreVersion")
    val appCompatVersion = "1.6.1"
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    val materialVersion = "1.9.0"
    implementation("com.google.android.material:material:$materialVersion")
    val junitVersion = "4.13.2"
    testImplementation("junit:junit:$junitVersion")
    val extJunitVersion = "1.1.5"
    androidTestImplementation("androidx.test.ext:junit:$extJunitVersion")
    val espressoCoreVersion = "3.5.1"
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoCoreVersion")
}
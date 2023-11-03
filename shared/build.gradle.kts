plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
  /*  listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic=true
        }
    }*/

    sourceSets {
        val commonMain by getting {
            dependencies {implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(project(":subzero"))
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation("com.chrynan.navigation:navigation-compose:0.10.0")

                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res", "src/commonMain/resources")
}
dependencies {
    implementation("androidx.compose.ui:ui-tooling-preview-android:1.5.3")
    implementation("androidx.lifecycle:lifecycle-livedata-core-ktx:2.6.2")
    // implementation("androidx.navigation:navigation-runtime-ktx:2.7.4")
}

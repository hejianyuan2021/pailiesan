buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
    // 终极止血：强制所有 kotlin 相关依赖降到 1.7.20，防传递依赖拉高
    configurations.all {
        resolutionStrategy {
            force("org.jetbrains.kotlin:kotlin-stdlib:1.7.20")
            force("org.jetbrains.kotlin:kotlin-stdlib-common:1.7.20")
            force("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.7.20")
            force("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.20")
            force("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
        }
    }
}

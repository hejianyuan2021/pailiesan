buildscript {
    repositories {
        mavenCentral()
        google()
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven { url = uri("https://jitpack.io") }
    }
    configurations.all {
        resolutionStrategy {
            force("org.jetbrains.kotlin:kotlin-stdlib:1.9.10")
            force("org.jetbrains.kotlin:kotlin-stdlib-common:1.9.10")
            force("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.10")
            force("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.10")
            force("org.jetbrains.kotlin:kotlin-reflect:1.9.10")
            force("com.google.code.findbugs:jsr305:3.0.2")
            force("com.squareup:javawriter:2.5.0")
        }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
    }
}
allprojects {
    repositories {
        mavenCentral()
        google()
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven { url = uri("https://jitpack.io") }
    }
    configurations.all {
        resolutionStrategy {
            force("org.jetbrains.kotlin:kotlin-stdlib:1.9.10")
            force("com.google.code.findbugs:jsr305:3.0.2")
            force("com.squareup:javawriter:2.5.0")
        }
    }
}

// 顶层项目构建配置（最小可用版）
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // 注意：具体插件版本需与 gradle/wrapper 版本及 app 内配置匹配，此处先保证能识别模块
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

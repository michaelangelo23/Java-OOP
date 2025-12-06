plugins {
    eclipse
}

subprojects {
    apply(plugin="java-library")
    apply(plugin="eclipse")

    plugins.withType<JavaPlugin> {
        the<JavaPluginExtension>().toolchain {
            languageVersion.set(JavaLanguageVersion.of(24))
        }
    }

    repositories {
        mavenCentral()
    }
}

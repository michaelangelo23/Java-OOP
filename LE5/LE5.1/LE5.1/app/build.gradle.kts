plugins {
	id("application")
	id("org.openjfx.javafxplugin") version "0.1.0"
}

dependencies {
	implementation(project(":exercise5"))
}

repositories {
	mavenCentral()
}

javafx {
	version = "21"
	modules = listOf("javafx.controls", "javafx.graphics", "javafx.base")
}

application {
	mainClass = "me.cantago.app.App"
}

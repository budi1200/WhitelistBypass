plugins {
    kotlin("jvm") version "1.6.10"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
}

group = "si.budimir"
version = "1.1-SNAPSHOT"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    mavenCentral()
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
}

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly("io.papermc.paper:paper-api:1.18.1-R0.1-SNAPSHOT")
}

task("buildAndPush") {
    dependsOn("build")

    doLast {
        copy {
            from("build/libs/WhitelistBypass-" + project.version + ".jar")
            into("../00-server/plugins/")
        }
    }
}

bukkit {
    main = "si.budimir.whitelistbypass.WhitelistBypassMain"
    apiVersion = "1.18"
    authors = listOf("budi1200")
    prefix = "WhitelistBypass"

    permissions {
        register("whitelistbypass.bypass") {
            description = "Allows you to bypass the server whitelist"
            default = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default.OP
        }
    }

    libraries = listOf("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
}
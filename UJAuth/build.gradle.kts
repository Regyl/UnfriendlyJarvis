plugins {
	java
	jacoco

	id("org.springframework.boot") version "3.0.2"
	id("io.spring.dependency-management") version "1.1.2"
	id("checkstyle")

	id("com.google.cloud.tools.jib") version "3.3.1"
}

group = "com.github.regyl.unfriendlyjarvis"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_17

jacoco {
	toolVersion = "0.8.9"
	reportsDirectory.set(layout.buildDirectory.dir("reports/customJacocoReportDir"))
}

jib {
	from {
		image = "eclipse-temurin:17-jre"
	}
	to {
		image = "registry.hub.docker.com/regyl/yasn-auth"
		auth {
			username = System.getenv("DockerHubLogin")
			password = System.getenv("DockerHubPassword")
		}
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://artifactory-oss.prod.netflix.net/artifactory/maven-oss-candidates") }
}

extra["springCloudVersion"] = "2022.0.1"
extra["testcontainersVersion"] = "1.17.6"
extra["mapstructVersion"] = "1.5.5.Final"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-mail")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
	implementation("org.springframework.cloud:spring-cloud-starter-config")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

	implementation("org.postgresql:postgresql:42.6.0")

	implementation("org.apache.commons:commons-lang3:3.13.0")
	implementation("org.apache.commons:commons-collections4:4.4")

	compileOnly("org.projectlombok:lombok")
	compileOnly("org.mapstruct:mapstruct:${property("mapstructVersion")}")
	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("org.mapstruct:mapstruct-processor:${property("mapstructVersion")}")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

	testImplementation("org.projectlombok:lombok")
	testImplementation("org.assertj:assertj-core:3.24.2")
	testImplementation("org.testcontainers:postgresql")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
	imports {
		mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.test {
	finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}
tasks.jacocoTestReport {
	dependsOn(tasks.test) // tests are required to run before generating the report
}
tasks.jib {
	dependsOn(tasks.test, tasks.checkstyleMain, tasks.checkstyleTest)
}

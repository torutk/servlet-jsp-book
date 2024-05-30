plugins {
    war
}

group = "com.torutk.book"

repositories {
    mavenCentral()
}

dependencies {
    providedCompile("jakarta.servlet:jakarta.servlet-api:6.0.0")
    providedCompile("jakarta.annotation:jakarta.annotation-api:2.1.1")
    //implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0")
    runtimeOnly("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0")
    runtimeOnly("com.h2database:h2:2.2.224")
    runtimeOnly("org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1")
}

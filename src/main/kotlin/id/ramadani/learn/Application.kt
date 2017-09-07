package id.ramadani.learn

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@SpringBootApplication
class Application

@Component
@ConfigurationProperties("app")
class ApplicationProperties {
    lateinit var name: String
    lateinit var env: String
}

fun main(args: Array<String>) {
    with(SpringApplication(Application::class.java)) {
        setBannerMode(Banner.Mode.OFF)
        run(*args)
    }
}

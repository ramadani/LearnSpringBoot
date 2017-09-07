package id.ramadani.learn

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class Application

@Component
class ApplicationProperties {

    @Value("\${app.name}")
    val name: String? = null

    @Value("\${app.env}")
    val env: String? = null
}

fun main(args: Array<String>) {
    with(SpringApplication(Application::class.java)) {
        setBannerMode(Banner.Mode.OFF)
        run(*args)
    }
}

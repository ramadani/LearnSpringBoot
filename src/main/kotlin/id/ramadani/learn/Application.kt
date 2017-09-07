package id.ramadani.learn

import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    with(SpringApplication(Application::class.java)) {
        setBannerMode(Banner.Mode.OFF)
        run(*args)
    }
}

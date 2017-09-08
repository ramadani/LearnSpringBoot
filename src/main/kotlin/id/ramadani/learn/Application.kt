package id.ramadani.learn

import id.ramadani.learn.http.interceptor.AuthInterceptor
import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Component
@ConfigurationProperties("app")
class ApplicationProperties {
    lateinit var name: String
    lateinit var env: String
}

@Configuration
class Configuration : WebMvcConfigurerAdapter() {
    companion object {
        val API_PATTERN = "/api/**"
    }
    override fun addInterceptors(registry: InterceptorRegistry?) {
        registry?.addInterceptor(AuthInterceptor())?.addPathPatterns(API_PATTERN)
    }
}

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    with(SpringApplication(Application::class.java)) {
        setBannerMode(Banner.Mode.OFF)
        run(*args)
    }
}

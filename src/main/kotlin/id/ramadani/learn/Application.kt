package id.ramadani.learn

import id.ramadani.learn.interceptors.AuthInterceptor
import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@SpringBootApplication
class Application

@Component
@ConfigurationProperties("app")
class ApplicationProperties {
    lateinit var name: String
    lateinit var env: String
}

@Configuration
class ApplicationConfiguration : WebMvcConfigurerAdapter() {
    override fun addCorsMappings(registry: CorsRegistry?) {
        registry?.addMapping("/api/**")
    }

    override fun addInterceptors(registry: InterceptorRegistry?) {
        registry?.addInterceptor(AuthInterceptor())?.addPathPatterns("/api/**")
    }
}

fun main(args: Array<String>) {
    with(SpringApplication(Application::class.java)) {
        setBannerMode(Banner.Mode.OFF)
        run(*args)
    }
}

package id.ramadani.learn.interceptors

import org.springframework.http.HttpStatus
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): Boolean {
        if (request?.getHeader("token").isNullOrEmpty())
            response?.sendError(HttpStatus.UNAUTHORIZED.value(), "Token Not Found")

        return true
    }

    override fun postHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?,
                            modelAndView: ModelAndView?) = Unit

    override fun afterCompletion(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?,
                                 ex: Exception?) = Unit
}
package tc.kotlin.mvc.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.web.multipart.MultipartResolver
import org.springframework.web.multipart.support.StandardServletMultipartResolver
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.InternalResourceViewResolver
import org.springframework.web.servlet.view.JstlView
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * Created by thomas.croft on 17/03/2017.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = arrayOf("tc.kotlin"))
@PropertySource("classpath:file-upload.properties")
class KotlinConfig : WebMvcConfigurerAdapter() {

    /*
        KOTLIN NOTE: Unlike Java, in Kotlin there are no static methods. Generally it is recommended
        to use package-level functions instead (see comment above). If you need to have a function that can be called
        without having an instance of the class you can put it in an object declaration in the class.
        Furthermore, if you put this function inside a companion object declaration then the same
        syntax for calling static methods in Java can be used. (i.e. the function below can be called
        by writing KotlinConfig.placeholderConfigurer() - which is actually short for:
        KotlinConfig.Companion.placeholderConfigurer() since a companion object with no specified
        name defaults to Companion)
     */
    companion object {
        @Bean
        fun placeholderConfigurer(): PropertySourcesPlaceholderConfigurer {
            /*
                KOTLIN NOTE: Constructors can be called without the 'new' keyword as in Java.
             */
            val configurer = PropertySourcesPlaceholderConfigurer()
            configurer.setIgnoreUnresolvablePlaceholders(true)
            return configurer
        }
    }

    @Bean
    fun viewResolver(): ViewResolver {
        val viewResolver = InternalResourceViewResolver()
        /*
            KOTLIN NOTE: Calling JstlView::class returns a type KClass<> which is a class of
            Kotlin classes. You need to additionally call a get on the 'java' property of KClass
            in order to get the Java class Class<> when working with Java classes such as this
            ViewResolver.
         */
        viewResolver.setViewClass(JstlView::class.java)
        viewResolver.setPrefix("/WEB-INF/views/")
        viewResolver.setSuffix(".jsp")
        return viewResolver
    }

    @Bean
    fun multipartResolver(): MultipartResolver {
        return StandardServletMultipartResolver()
    }

    /*
        KOTLIN NOTE: Kotlin is null safe which means any method call on an object which could be null
        causes a compiler error. Specifying a class with a ? at the end of it like this
        DefaultServletHandlerConfigurer? means that it is nullable. Trying to call configurer.enable()
        would cause a compiler error hence you must use the null safe call ?. which returns null
        if configurer is null and configurer.enable() otherwise. This avoids NullPointerExceptions.
     */
    override fun configureDefaultServletHandling(configurer: DefaultServletHandlerConfigurer?) {
        configurer?.enable()
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/")
    }

}

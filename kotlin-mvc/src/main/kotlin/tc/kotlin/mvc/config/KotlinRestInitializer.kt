package tc.kotlin.mvc.config

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer
import java.util.*
import javax.servlet.MultipartConfigElement
import javax.servlet.ServletRegistration

/**
 * Created by thomas.croft on 16/03/2017.
 */


class KotlinRestInitializer() : AbstractAnnotationConfigDispatcherServletInitializer() {

    private val location : String
    private val maxFileSize : Long
    private val maxRequestSize : Long
    private val fileSizeThreshold : Int

    /*
        KOTLIN NOTE: All class properties must be initialized upon instantiation of a class. If
        this is not done explicitly in the constructor for the class it must be done in the definition
        of the property or in an init{} block as below: This init block is run upon initialization of an
        instance of the class.
     */
    init {
        //Loading servlet properties
        val properties = Properties()
        val input = Thread.currentThread().contextClassLoader.getResourceAsStream("file-upload.properties")
        properties.load(input)
        location = properties.getProperty("temp.folder")
        maxFileSize = properties.getProperty("max.file.size").toLong()
        maxRequestSize = properties.getProperty("max.request.size").toLong()
        fileSizeThreshold = properties.getProperty("file.size.threshold").toInt()
    }

    override fun getRootConfigClasses(): Array<Class<*>> {
        return arrayOf()
    }

    override fun getServletConfigClasses(): Array<Class<*>> {
        return arrayOf(KotlinConfig::class.java)
    }

    override fun getServletMappings(): Array<String> {
        return arrayOf("/")
    }

    override fun customizeRegistration(registration: ServletRegistration.Dynamic?) {
        registration?.setMultipartConfig(getMultipartConfigElement())
    }

    private fun getMultipartConfigElement() : MultipartConfigElement {
        val multipartConfigElement = MultipartConfigElement(location, maxFileSize, maxRequestSize, fileSizeThreshold)
        return multipartConfigElement
    }

}
package tc.kotlin.mvc.service

import tc.kotlin.mvc.model.UploadResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.util.FileCopyUtils
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.util.*

/**
 * Created by thomas.croft on 13/04/2017.
 */
@Service
/*
    KOTLIN NOTE: As with the KotlinController and Autowired properties; if you want to use
    @Value to inject a property this should be done through constructor injection. You also
    need to escape the $ since this is used for String templates (see KOTLIN NOTE below).
 */
class UploadService(@Value("\${upload.folder}") private val uploadLocation: String) {

//    @Value("\${upload.folder}")
//    private lateinit var uploadLocation : String

    fun uploadImage(file : MultipartFile) : UploadResponse {
        val contentType = file.contentType
        if (!contentType.startsWith("image/")) {
            return UploadResponse(false, null, "Uploaded file was not an image")
        }
        /*
            KOTLIN NOTE: In Kotlin you can use String templates for piecing together strings
            based on evaluated code which is concatenated together (i.e. the line of code
            below is equivalent to 'val extension = "." + file.contentType.split("/")[1]'
         */
        val extension = ".${file.contentType.split("/")[1]}"
        val fileName = "/${UUID.randomUUID()}$extension"
        val directory = "src/main/webapp/$uploadLocation"
        File(directory).mkdirs()
        FileCopyUtils.copy(file.bytes, File(directory + fileName))
        return UploadResponse(true, uploadLocation + fileName, null)
    }

}
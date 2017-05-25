package tc.kotlin.mvc.controller

import tc.kotlin.mvc.model.Manos
import tc.kotlin.mvc.service.UploadService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

/**
 * Created by thomas.croft on 17/03/2017.
 */

@Controller
@RequestMapping("/")
/*
	KOTLIN NOTE: It is recommended to use constructor injection for autowiring properties. This is because
	all properties in Kotlin need to be initialized on construction of an instance of the class. It is also
	possible to use property injection by specifying the property as 'lateinit' (See commented out
	code below). However this is only possible for mutable objects (i.e. var's not val's)
	and so for immutable objects it is better to use constructor injection.
 */
class KotlinController(val uploadService: UploadService) {

//	@Autowired
//	private lateinit var uploadService : UploadService

	@RequestMapping(path = arrayOf("/"), method = arrayOf(RequestMethod.GET))
	fun index() : String {
		return "index"
	}

    @RequestMapping(path = arrayOf("/manosMaker"), method = arrayOf(RequestMethod.GET))
    fun manosMaker(model: Model) : String {
		model.addAttribute("manos", Manos())
        return "form"
    }

	@RequestMapping(path = arrayOf("/fileUploader"), method = arrayOf(RequestMethod.GET))
	fun fileUploader() : String {
		return "upload"
	}

	@RequestMapping(path = arrayOf("/addManos"), method = arrayOf(RequestMethod.POST))
	fun addManos(model: Model, manos: Manos) : String {
		return "summary"
	}

	@RequestMapping(path = arrayOf("/upload"), method = arrayOf(RequestMethod.POST),
			consumes = arrayOf("multipart/form-data"))
	fun upload(@RequestPart("file") file : MultipartFile, model: Model) : String {
		/*
			KOTLIN NOTE: The type of variables is automatically inferred from the signature
			of the method called to create them. So unlike in Java we do not need to specify
			the type of 'response' (e.g. 'val response : UploadResponse = uploadService.uploadImage(file)'
			- this code is valid Kotlin but the type definition is redundant).
		 */
		val response = uploadService.uploadImage(file)
		model.addAttribute("response", response)
		return "uploadResponse"
	}

}
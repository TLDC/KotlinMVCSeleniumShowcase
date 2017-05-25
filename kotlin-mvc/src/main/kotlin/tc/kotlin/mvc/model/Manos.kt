package tc.kotlin.mvc.model
/*
    KOTLIN NOTE: A one line POKO (see UploadResponse for more info). By including default values for the
    properties in the constructor it automatically generates a callable default constructor Manos() which
    can be used to create an instance of this class with these default values. This is required for this
    particular class because an instance of the class is needed to register it as a model attribute in
    the KotlinController before the properties we want to set are known.
 */
class Manos(var name: String = "", var age: Int = 0, var gender: String = "", var height: Double = 0.0, var confirmed: Boolean = false)
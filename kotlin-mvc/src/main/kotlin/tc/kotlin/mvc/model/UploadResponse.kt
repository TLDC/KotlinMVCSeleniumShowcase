package tc.kotlin.mvc.model

/**
 * Created by thomas.croft on 19/04/2017.
 */
/*
    KOTLIN NOTE: POJOs (or strictly speaking POKOs) in Kotlin can be written in one line. Getters
    and setters are automatically generated and referenced in the same way one would access the
    properties directly (e.g. uploadResponse.success for getter and uploadResponse.success = true for setter.
    This removes the need for a lot of the boilerplate code required in Java. Furthermore this POKO is
    marked as a data class. This means it is only for holding data so in actual fact the setters are not
    present. This is equivalent to making a POJO with only getters and a constructor setting up all the properties.
 */
data class UploadResponse(val success: Boolean, val location: String?, val errorMsg: String?)


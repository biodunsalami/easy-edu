package ps.room.easyedu.api

import com.squareup.moshi.Json
import ps.room.easyedu.api.models.course.Course
//import ps.room.easyedu.api.models.Course


data class CourseResponse(

    @Json(name="results")
    val courseResponse: List<Course>

)

package ps.room.easyedu.api

import com.squareup.moshi.Json
import ps.room.easyedu.api.models.coursecurriculum.LectureItem

data class CourseCurriculumResponse(
    @Json(name="results")
    val courseCurriculumResponse: List<LectureItem>

)

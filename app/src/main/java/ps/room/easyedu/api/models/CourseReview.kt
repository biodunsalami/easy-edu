package ps.room.easyedu.api.models

data class CourseReview(
    val content: String,
//    val course: Course,
    val created: String,
    val rating: Int, //Verify this
    val title: String,
    val user: String
)

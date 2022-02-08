package ps.room.easyedu.api.models.course

data class CoursesList(
    val aggregations: List<Aggregation>,
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Course>,
    val search_tracking_id: String
)
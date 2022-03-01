package ps.room.easyedu.api.models.course

import java.io.Serializable

data class Course(
    val _class: String?,
    val curriculum_items: List<Any>,
    val curriculum_lectures: List<Any>,
    val headline: String?,
    val id: Int?,
    val image_125_H: String?,
    val image_240x135: String?,
    val image_480x270: String?,
    val input_features: Any?,
    val instructor_name: Any?,
    val is_paid: Boolean,
    val is_practice_test_course: Boolean,
    val lecture_search_result: Any?,
    val order_in_results: Any?,
    val predictive_score: Any?,
    val price: String?,
    val price_detail: Any?,
    val price_serve_tracking_id: String?,
    val published_title: String?,
    val relevancy_score: Any?,
    val title: String?,
    val tracking_id: String?,
    val url: String?,
    val visible_instructors: List<VisibleInstructor>
) : Serializable
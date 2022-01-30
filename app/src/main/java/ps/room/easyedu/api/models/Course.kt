package ps.room.easyedu.api.models

data class Course(
    val avg_rating: String,
    val completion_ratio: String,
    val description: String,
    val headline: String,
    val image_100x100: String,

    val is_paid: Boolean,
    val is_wishlisted: Boolean,
    val num_lectures: Int,
    val num_reviews: Int,
    val num_subscribers: String,
    val price: String,
    val primary_category: String,
    val primary_subcategory: String,
    val status_label: String,
    val title: String,
    val url: String,
    val visible_instructors: String //This is supposed to be an array of instructors
)

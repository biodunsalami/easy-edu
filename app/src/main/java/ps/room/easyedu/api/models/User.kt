package ps.room.easyedu.api.models

data class User(
    val created: String,
    val has_activated: String,
    val image_100x100: String,
    val is_disabled: Boolean,
    val is_followed: Boolean,
    val is_generated: Boolean,
    val job_title: String,
    val name: String,
    val num_subscribed_courses: String,
    val surname: String,
    val time_zone: String,
    val title: String,
    val url: String,
    val url_title: String
)

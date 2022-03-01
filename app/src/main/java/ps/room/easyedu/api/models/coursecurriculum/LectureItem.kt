package ps.room.easyedu.api.models.coursecurriculum

data class LectureItem(
    val _class: String,
    val asset: Asset,
    val can_be_previewed: Boolean,
    val created: String,
    val description: String,
    val duration: Any,
    val id: Int,
    val is_downloadable: Boolean,
    val is_draft: Boolean,
    val is_free: Boolean,
    val is_published: Boolean,
    val object_index: Int,
    val pass_percent: Any,
    val sort_order: Int,
    val title: String?,
    val title_cleaned: String,
    val transcript: String,
    val type: String,
    val version: Int
)
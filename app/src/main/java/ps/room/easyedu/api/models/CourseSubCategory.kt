package ps.room.easyedu.api.models

data class CourseSubCategory(
    val category: CourseCategory,
    val sort_order: String, //Verify this
    val title: String,
    val title_cleaned: String
)

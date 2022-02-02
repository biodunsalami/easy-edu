package ps.room.easyedu.api

import ps.room.easyedu.api.models.Course

class Repository(private val apiService: ApiService) {

    suspend fun getCourses () : ArrayList<Course>{

        val apiCourseList = apiService.getCourse()

        val courseList = ArrayList<Course>()

        for (course in apiCourseList){
            val course = Course(
                course.avg_rating,
                course.completion_ratio,
                course.description,
                course.headline,
                course.image_100x100,
                course.is_paid,
                course.is_wishlisted,
                course.num_lectures,
                course.num_reviews,
                course.num_subscribers,
                course.price,
                course.primary_category,
                course.primary_subcategory,
                course.status_label,
                course.title,
                course.url,
                course.visible_instructors
            )

            courseList.add(course)
        }

        return courseList
    }

}
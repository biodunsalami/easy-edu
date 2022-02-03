package ps.room.easyedu.api

import android.util.Log
import ps.room.easyedu.api.models.Course

class Repository(private val apiService: ApiService) {

    suspend fun getCourses () : ArrayList<Course>{

        val clientId = "9jXy1gh7gcCzGxj43QC2eIe4Bh0oMiuCSWWdCBtb"
        val clientSecret = "4QwoV4SQFbOt9sbuoxrS9Lw5cYrI71xPEEDi7cyN2stMi9zqC8pLtMGBQEy399sK6gVFLaSp1ZAaORuuwPLpfkzN1uCBcLDLp1hLHOqIkFPTSeAW32w3SvGOBGgN7Pqb"

        val apiCourseList = apiService.getCourse(clientId, clientSecret)

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
        Log.e("Course", courseList.toString())

        return courseList
    }

}
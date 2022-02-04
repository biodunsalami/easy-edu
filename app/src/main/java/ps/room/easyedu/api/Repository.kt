package ps.room.easyedu.api

import android.util.Log
import ps.room.easyedu.api.models.Course

class Repository(private val apiService: ApiService) {

    suspend fun getCourses () : ArrayList<Course>{

        val auth = "Basic OWpYeTFnaDdnY0N6R3hqNDNRQzJlSWU0Qmgwb01pdUNTV1dkQ0J0Yjo0UXdvVjRTUUZiT3Q5c2J1b3hyUzlMdzVjWXJJNzF4UEVFRGk3Y3lOMnN0TWk5enFDOHBMdE1HQlFFeTM5OXNLNmdWRkxhU3AxWkFhT1J1dXdQTHBma3pOMXVDQmNMRExwMWhMSE9xSWtGUFRTZUFXMzJ3M1N2R09CR2dON1BxYg=="

        val apiCourseList = apiService.getCourse(auth)

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

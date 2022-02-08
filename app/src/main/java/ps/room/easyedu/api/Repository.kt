package ps.room.easyedu.api

import android.util.Log
//import ps.room.easyedu.api.models.Course
import ps.room.easyedu.api.models.course.Course

class     Repository(private val apiService: ApiService) {

    suspend fun getCourses () : ArrayList<Course>{

        val auth = "Basic OWpYeTFnaDdnY0N6R3hqNDNRQzJlSWU0Qmgwb01pdUNTV1dkQ0J0Yjo0UXdvVjRTUUZiT3Q5c2J1b3hyUzlMdzVjWXJJNzF4UEVFRGk3Y3lOMnN0TWk5enFDOHBMdE1HQlFFeTM5OXNLNmdWRkxhU3AxWkFhT1J1dXdQTHBma3pOMXVDQmNMRExwMWhMSE9xSWtGUFRTZUFXMzJ3M1N2R09CR2dON1BxYg=="

        val apiCourseList = apiService.getCourse(auth).courseResponse

        val courseList = ArrayList<Course>()

        for (course in apiCourseList){
            val course = Course(
                course._class,
                course.curriculum_items,
                course.curriculum_lectures,
                course.headline,
                course.id,
                course.image_125_H,
                course.image_240x135,
                course.image_480x270,
                course.input_features,
                course.instructor_name,
                course.is_paid,
                course.is_practice_test_course,
                course.lecture_search_result,
                course.order_in_results,
                course.predictive_score,
                course.price,
                course.price_detail,
                course.price_serve_tracking_id,
                course.published_title,
                course.relevancy_score,
                course.title,
                course.tracking_id,
                course.url,
                course.visible_instructors,
            )

            courseList.add(course)
        }
        Log.e("Course", courseList.toString())

        return courseList
    }

}

package ps.room.easyedu.api

import android.util.Log
import ps.room.easyedu.api.models.CourseCategory
import ps.room.easyedu.api.models.course.Course
import ps.room.easyedu.api.models.coursecurriculum.LectureItem

class Repository(private val apiService: ApiService) {

    private lateinit var categoryData: CategoryData

    suspend fun getCourses () : ArrayList<Course>{

        val auth = ""

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
//        Log.e("Course", courseList.toString())

        return courseList
    }

     suspend fun getCourseCategories() : ArrayList<CourseCategory> {
        categoryData = CategoryData()
        return categoryData.categoriesArrayList
    }

    suspend fun getCourseCurriculum() : ArrayList<LectureItem>{
        val auth = ""

        val courseList = getCourses()

        val course_id = ""



        val apiCourseCurriculumList = apiService.getCourseCurriculum(auth, course_id).courseCurriculumResponse

        val courseLecturesList = ArrayList<LectureItem>()

        for(lecture in apiCourseCurriculumList){
            val lectures = LectureItem(lecture._class,
                lecture.asset,
                lecture.can_be_previewed,
                lecture.created,
                lecture.description,
                lecture.duration,
                lecture.id,
                lecture.is_downloadable,
                lecture.is_draft,
                lecture.is_free,
                lecture.is_published,
                lecture.object_index,
                lecture.pass_percent,
                lecture.sort_order,
                lecture.title,
                lecture.title_cleaned,
                lecture.transcript,
                lecture.type,
                lecture.version)

            courseLecturesList.add(lectures)
        }

        return courseLecturesList
    }

}

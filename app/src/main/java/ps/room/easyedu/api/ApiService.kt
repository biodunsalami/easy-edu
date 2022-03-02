package ps.room.easyedu.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
//import ps.room.easyedu.api.models.Course
import ps.room.easyedu.api.models.course.Course
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header


private val BASEURL = "https://www.udemy.com/api-2.0/"


interface ApiService {

    @GET("courses")
    suspend fun getCourse(@Header("authorization") authorization: String): CourseResponse

    @GET("{course_id}/public-curriculum-items/")
    suspend fun getCourseCurriculum(@Header("authorization") authorization: String,
                                    @Header("course_id") course_id: String) : CourseCurriculumResponse

    @GET("courses/{pk}")
    suspend fun getCourseDetails(): List<Course>

}

val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory
    .create(moshi))
    .baseUrl(BASEURL)
    .build()

object Api{
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
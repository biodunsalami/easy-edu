package ps.room.easyedu.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import ps.room.easyedu.api.models.Course
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers


private val BASEURL = "https://www.udemy.com/api-2.0/"


interface ApiService {

    @Headers("9jXy1gh7gcCzGxj43QC2eIe4Bh0oMiuCSWWdCBtb : " +
            "4QwoV4SQFbOt9sbuoxrS9Lw5cYrI71xPEEDi7cyN2stMi9zqC8pLtMGBQEy399sK6gVFLaSp1ZAaORuuwPLpfkzN1uCBcLDLp1hLHOqIkFPTSeAW32w3SvGOBGgN7Pqb ")
    @GET("courses")
    suspend fun getCourse(): List<Course>

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
package ps.room.easyedu.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ps.room.easyedu.R
import ps.room.easyedu.adapers.CategoriesAdapter
import ps.room.easyedu.adapers.CourseAdapter
import ps.room.easyedu.adapers.PopularCourseAdapter
import ps.room.easyedu.api.Api
import ps.room.easyedu.api.Repository
import ps.room.easyedu.api.models.CourseCategory
import ps.room.easyedu.api.models.course.Course
import ps.room.easyedu.databinding.FragmentBrowseBinding


class BrowseFragment : BaseFragment() {

    private lateinit var binding: FragmentBrowseBinding

    private lateinit var courseAdapter: CourseAdapter
    private lateinit var popularCourseAdapter: PopularCourseAdapter
    private lateinit var categoriesAdapter: CategoriesAdapter

    private var repository = Repository(Api.apiService)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBrowseBinding.inflate(inflater, container, false)

        MainScope().launch {
            setUpCourseAdapter(repository.getCourses())
            setUpPopularCourseAdapter(repository.getCourses())
            setUpCourseCategoriesAdapter(repository.getCourseCategories())
        }

        return binding.root
    }

    private fun setUpCourseAdapter(course: List<Course>) {
        courseAdapter = CourseAdapter(course, requireContext())
        binding.coursesRecyclerView.adapter = courseAdapter
        binding.coursesRecyclerView.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setUpPopularCourseAdapter(course: List<Course>) =
        binding.mostPopularRecyclerView.apply{

        popularCourseAdapter = PopularCourseAdapter(course, requireContext())
        adapter = popularCourseAdapter
        layoutManager = LinearLayoutManager(context)
    }

    private fun setUpCourseCategoriesAdapter(courseCategory: List<CourseCategory>) =
        binding.categoriesRecyclerView.apply{

        categoriesAdapter = CategoriesAdapter(courseCategory)
        adapter = categoriesAdapter
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }


}
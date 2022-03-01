package ps.room.easyedu.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ps.room.easyedu.R
import ps.room.easyedu.adapers.CategoriesAdapter
import ps.room.easyedu.adapers.CourseAdapter
import ps.room.easyedu.adapers.CourseInfoInterface
import ps.room.easyedu.adapers.PopularCourseAdapter
import ps.room.easyedu.api.Api
import ps.room.easyedu.api.Repository
import ps.room.easyedu.api.models.CourseCategory
import ps.room.easyedu.api.models.course.Course
import ps.room.easyedu.api.models.course.CoursesList
import ps.room.easyedu.databinding.FragmentBrowseBinding


class BrowseFragment : BaseFragment(), CourseInfoInterface {

    private lateinit var binding: FragmentBrowseBinding

    private lateinit var courseAdapter: CourseAdapter
    private lateinit var popularCourseAdapter: PopularCourseAdapter
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var coursesList: ArrayList<Course>

    private var repository = Repository(Api.apiService)


    private lateinit var view: FrameLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBrowseBinding.inflate(inflater, container, false)
        view = binding.root

        MainScope().launch {
            setUpCourseAdapter(repository.getCourses())
            setUpPopularCourseAdapter(repository.getCourses())
            setUpCourseCategoriesAdapter(repository.getCourseCategories())
            coursesList = repository.getCourses()
        }



        return view
    }


    private fun setUpCourseAdapter(course: List<Course>) {
        courseAdapter = CourseAdapter(course, requireContext(), this@BrowseFragment)
        binding.coursesRecyclerView.adapter = courseAdapter
        binding.coursesRecyclerView.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setUpPopularCourseAdapter(course: List<Course>) =
        binding.mostPopularRecyclerView.apply{

        popularCourseAdapter = PopularCourseAdapter(course, requireContext(), this@BrowseFragment)
        adapter = popularCourseAdapter
        layoutManager = LinearLayoutManager(context)
    }

    private fun setUpCourseCategoriesAdapter(courseCategory: List<CourseCategory>) =
        binding.categoriesRecyclerView.apply{

        categoriesAdapter = CategoriesAdapter(courseCategory)
        adapter = categoriesAdapter
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }


    override fun onCardClicked(position: Int) {
        Toast.makeText(context, "This Works", Toast.LENGTH_SHORT).show()

        val course = coursesList[position]

        activityCast().changeActivityFragment(BaseFragmentDirections.actionBaseFragmentToCourseFragment(course))


    }

}
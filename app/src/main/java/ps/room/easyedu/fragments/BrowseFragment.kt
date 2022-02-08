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
import ps.room.easyedu.adapers.CourseAdapter
import ps.room.easyedu.api.Api
import ps.room.easyedu.api.Repository
import ps.room.easyedu.api.models.course.Course
import ps.room.easyedu.databinding.FragmentBrowseBinding


class BrowseFragment : BaseFragment() {

    private lateinit var binding: FragmentBrowseBinding

    private lateinit var courseAdapter: CourseAdapter

    private var repository = Repository(Api.apiService)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBrowseBinding.inflate(inflater, container, false)

        MainScope().launch {
            setUpAdapter(repository.getCourses())
        }

        return binding.root
    }

    private fun setUpAdapter(course: List<Course>) {
        courseAdapter = CourseAdapter(course)
        binding.coursesRecyclerView.adapter = courseAdapter
        binding.coursesRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }


}
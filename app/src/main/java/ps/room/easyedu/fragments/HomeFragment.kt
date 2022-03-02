package ps.room.easyedu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ps.room.easyedu.R
import ps.room.easyedu.adapers.CourseEnrolledAdapter
import ps.room.easyedu.api.Api
import ps.room.easyedu.api.Repository
import ps.room.easyedu.api.models.course.Course
import ps.room.easyedu.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var courseEnrolledAdapter : CourseEnrolledAdapter

    private var repository = Repository(Api.apiService)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        swapViews(isCourseAdded)

        MainScope().launch {
            setUpAdapter(repository.getCourses())
        }

        return binding.root
    }

    //Swaps the views on the home fragment once user starts a course
    private fun swapViews(boolean: Boolean){
        if (boolean){
            binding.homeConstraintLayout.visibility = View.GONE
            binding.browseTextView.visibility = View.VISIBLE
            binding.coursesRecyclerView.visibility = View.VISIBLE
        }else{
            binding.homeConstraintLayout.visibility = View.VISIBLE
            binding.browseTextView.visibility = View.GONE
            binding.coursesRecyclerView.visibility = View.GONE
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.browseCoursesButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_browseFragment)
        }
    }

    private fun setUpAdapter(courses : List<Course>) = binding.coursesRecyclerView.apply {
        courseEnrolledAdapter = CourseEnrolledAdapter(courses, requireContext())
        adapter = courseEnrolledAdapter
        layoutManager = LinearLayoutManager(context)
    }


}
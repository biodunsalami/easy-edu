package ps.room.easyedu.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ps.room.easyedu.R
import ps.room.easyedu.adapers.CourseContentAdapter
import ps.room.easyedu.api.Api
import ps.room.easyedu.api.Repository
import ps.room.easyedu.api.models.Lecture
import ps.room.easyedu.api.models.course.Course
import ps.room.easyedu.api.models.coursecurriculum.LectureItem
import ps.room.easyedu.databinding.FragmentCourseBinding


class CourseFragment : Fragment() {

    private lateinit var binding: FragmentCourseBinding

    private var repository = Repository(Api.apiService)

    private lateinit var courseContentAdapter: CourseContentAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCourseBinding.inflate(inflater, container, false)

        arguments.let {
            val args = CourseFragmentArgs.fromBundle(requireArguments())
            Log.e("COURSE DATA", args.courseData.toString())

            binding.courseTitleTextView.text = args.courseData?.title.toString()
            binding.courseTutorTextView.text = getString(R.string.tutors_name,
                args.courseData?.visible_instructors?.get(0)?.display_name.toString())
            binding.courseIntroTextView.text = args.courseData?.headline.toString()
        }

        MainScope().launch {
            setUpCourseContentAdapter(repository.getCourseCurriculum())
        }

        return binding.root
    }

    private fun setUpCourseContentAdapter(lectures: List<LectureItem>) = binding.courseContentRecyclerView.apply {
        courseContentAdapter = CourseContentAdapter(lectures, requireContext())
        adapter = courseContentAdapter
        layoutManager = LinearLayoutManager(context)
    }


}
package ps.room.easyedu.adapers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ps.room.easyedu.R
import ps.room.easyedu.api.models.course.Course
import ps.room.easyedu.databinding.ItemCoursesEnrolledRecyclerBinding

class CourseEnrolledAdapter (private val courses: List<Course>, private val context: Context) :
    RecyclerView.Adapter<CourseEnrolledAdapter.CourseEnrolledViewHolder>(){

    inner class CourseEnrolledViewHolder(private val binding: ItemCoursesEnrolledRecyclerBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bindViews(course: Course){
                binding.courseTitleTextView.text = course.title.toString()
                binding.courseTutorTextView.text = context.getString(R.string.tutors_name, course.visible_instructors[0].display_name)

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseEnrolledViewHolder {
        return CourseEnrolledViewHolder(ItemCoursesEnrolledRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: CourseEnrolledViewHolder, position: Int) {
        val course = courses[position]
        holder.bindViews(course)
    }

    override fun getItemCount(): Int {
        return courses.size
    }
}
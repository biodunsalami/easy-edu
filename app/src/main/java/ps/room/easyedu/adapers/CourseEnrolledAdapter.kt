package ps.room.easyedu.adapers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ps.room.easyedu.api.models.Course
import ps.room.easyedu.databinding.ItemCoursesEnrolledRecyclerBinding

class CourseEnrolledAdapter (private val courses: List<Course>) :
    RecyclerView.Adapter<CourseEnrolledAdapter.CourseEnrolledViewHolder>(){

    inner class CourseEnrolledViewHolder(private val binding: ItemCoursesEnrolledRecyclerBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bindViews(course: Course){
                //bind views here
                binding.courseTitleTextView.text = course.title
                binding.courseTutorTextView.text = course.visible_instructors
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
package ps.room.easyedu.adapers


import android.content.Context
import android.content.res.Resources
import android.provider.Settings.Global.getString
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ps.room.easyedu.R
import ps.room.easyedu.api.models.course.Course
import ps.room.easyedu.databinding.ItemCoursesListRecyclerBinding


class CourseAdapter (private val courses: List<Course>, private val context: Context) :
    RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {


    inner class CourseViewHolder(private val binding: ItemCoursesListRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bindView(course: Course){
                binding.courseTitleTextView.text = course.title.toString()
                binding.courseTutorTextView.text = context.getString(R.string.tutors_name, course.visible_instructors[0].display_name.toString())
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(ItemCoursesListRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false ))
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        holder.bindView(course)
    }

    override fun getItemCount(): Int {
        return courses.size
    }
}
package ps.room.easyedu.adapers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ps.room.easyedu.R
import ps.room.easyedu.api.models.course.Course
import ps.room.easyedu.databinding.ItemMostPopularRecyclerBinding

class PopularCourseAdapter(private val courses: List<Course>, private val context: Context):
    RecyclerView.Adapter<PopularCourseAdapter.PopularCourseViewHolder>() {

    inner class PopularCourseViewHolder(private val binding: ItemMostPopularRecyclerBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bindViews(course: Course){
                binding.courseTitleTextView.text = course.title.toString()
                binding.courseTutorTextView.text = context.getString(R.string.tutors_name, course.visible_instructors[0].display_name)
                binding.popularCourseImageView.load(course.image_480x270)
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularCourseViewHolder {
        return PopularCourseViewHolder(ItemMostPopularRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false) )
    }

    override fun onBindViewHolder(holder: PopularCourseViewHolder, position: Int) {
        val course = courses[position]
        holder.bindViews(course)
    }

    override fun getItemCount(): Int {
        return courses.size
    }


}
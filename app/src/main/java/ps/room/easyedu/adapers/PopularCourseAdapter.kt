package ps.room.easyedu.adapers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ps.room.easyedu.api.models.course.Course
import ps.room.easyedu.databinding.ItemMostPopularRecyclerBinding

class PopularCourseAdapter(private val courses: List<Course>):
    RecyclerView.Adapter<PopularCourseAdapter.PopularCourseViewHolder>() {

    inner class PopularCourseViewHolder(private val binding: ItemMostPopularRecyclerBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bindViews(course: Course){
                //bindViews here
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
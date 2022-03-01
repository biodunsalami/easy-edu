package ps.room.easyedu.adapers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ps.room.easyedu.api.models.Lecture
import ps.room.easyedu.api.models.coursecurriculum.LectureItem
import ps.room.easyedu.databinding.ItemCourseContentRecyclerBinding

class CourseContentAdapter(private val lectures : List<LectureItem>,
                           private val context: Context) :
    RecyclerView.Adapter<CourseContentAdapter.CourseContentViewHolder>() {
    inner class CourseContentViewHolder(private val  binding: ItemCourseContentRecyclerBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bindViews(lecture: LectureItem){
            binding.lectureTextView.text = lecture.title.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseContentViewHolder {
        return CourseContentViewHolder(ItemCourseContentRecyclerBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: CourseContentViewHolder, position: Int) {
        val lecture = lectures[position]
        holder.bindViews(lecture)
    }

    override fun getItemCount(): Int {
        return lectures.size
    }

}
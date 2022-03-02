package ps.room.easyedu.adapers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ps.room.easyedu.api.models.CourseCategory
import ps.room.easyedu.databinding.ItemCategoriesRecyclerBinding

class CategoriesAdapter(private val courseCategories : List<CourseCategory>) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesAdapterViewHolder>(){

    inner class CategoriesAdapterViewHolder(private val binding: ItemCategoriesRecyclerBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bindView(courseCategory: CourseCategory){
                binding.categoryTextView.text = courseCategory.title
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapterViewHolder {
        return CategoriesAdapterViewHolder(ItemCategoriesRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: CategoriesAdapterViewHolder, position: Int) {
        val courseCategory = courseCategories[position]
        holder.bindView(courseCategory)
    }

    override fun getItemCount(): Int {
        return courseCategories.size
    }

}

package ru.nikitazar.justmoby.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.nikitazar.justmoby.databinding.CardCategoryListBinding
import ru.nikitazar.justmoby.dto.CategoryData

class CategoryAdapter : ListAdapter<CategoryData, CategoryViewHolder>(CategoryDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CardCategoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class CategoryViewHolder(
    private val binding: CardCategoryListBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: CategoryData) {
        with(binding) {
            categoryName.text = item.name

            val cardDataAdapter = CardDataAdapter()
            list.adapter = cardDataAdapter
            cardDataAdapter.submitList(item.list)

            btSeeMore.setOnClickListener {
                //Not yet implemented
            }
        }
    }
}

class CategoryDiffCallback : DiffUtil.ItemCallback<CategoryData>() {
    override fun areItemsTheSame(oldItem: CategoryData, newItem: CategoryData) = newItem.id == oldItem.id
    override fun areContentsTheSame(oldItem: CategoryData, newItem: CategoryData) = newItem == oldItem
}
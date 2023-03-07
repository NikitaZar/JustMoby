package ru.nikitazar.justmoby.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.nikitazar.justmoby.R
import ru.nikitazar.justmoby.databinding.CardItemBinding
import ru.nikitazar.justmoby.dto.CardData

class CardDataAdapter : ListAdapter<CardData, CardDataViewHolder>(CardDataDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDataViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardDataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDataViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class CardDataViewHolder(
    private val binding: CardItemBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: CardData) {
        with(binding) {
            val context = root.context

            val resourceId = context.resources.getIdentifier(
                item.pic,
                "drawable",
                context.packageName
            )

            val drawable = AppCompatResources.getDrawable(context, resourceId)
            pic.setImageDrawable(drawable)
        }
    }
}

class CardDataDiffCallback : DiffUtil.ItemCallback<CardData>() {
    override fun areItemsTheSame(oldItem: CardData, newItem: CardData) = newItem.id == oldItem.id
    override fun areContentsTheSame(oldItem: CardData, newItem: CardData) = newItem == oldItem
}
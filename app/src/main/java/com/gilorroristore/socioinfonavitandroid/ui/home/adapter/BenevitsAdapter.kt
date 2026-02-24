package com.gilorroristore.socioinfonavitandroid.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gilorroristore.socioinfonavitandroid.databinding.ItemBenevitsBinding
import com.gilorroristore.socioinfonavitandroid.domain.model.BenevitsInfo

class BenevitsAdapter(
    var list: List<BenevitsInfo> = emptyList(),
    val onItemSelected: (BenevitsInfo) -> Unit
) :
    RecyclerView.Adapter<BenevitsViewHolder>() {

    fun updateList(listBenevits: List<BenevitsInfo>) {
        list = listBenevits
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BenevitsViewHolder {
        return BenevitsViewHolder(
            ItemBenevitsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: BenevitsViewHolder,
        position: Int
    ) {
        holder.addItem(list[position], onItemSelected)
    }

    override fun getItemCount() = list.size
}
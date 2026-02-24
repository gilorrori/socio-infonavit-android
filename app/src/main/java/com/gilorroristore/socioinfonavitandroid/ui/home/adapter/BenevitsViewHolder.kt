package com.gilorroristore.socioinfonavitandroid.ui.home.adapter

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gilorroristore.socioinfonavitandroid.R
import com.gilorroristore.socioinfonavitandroid.data.network.model.BenevitsResponse
import com.gilorroristore.socioinfonavitandroid.databinding.ItemBenevitsBinding
import com.gilorroristore.socioinfonavitandroid.domain.model.BenevitsInfo
import com.google.android.material.snackbar.Snackbar

class BenevitsViewHolder(val binding: ItemBenevitsBinding) : RecyclerView.ViewHolder(binding.root) {

    fun addItem(benevitsInfo: BenevitsInfo, onItemSelected: (BenevitsInfo) -> Unit) {
        val context = binding.root.context
        Glide.with(context).load(benevitsInfo.miniLogoFullPath)
            .transition(DrawableTransitionOptions.withCrossFade(1000)).centerInside()
            .into(binding.ivLogo)
        binding.tvTitle.text = context.getString(benevitsInfo.title)
        binding.tvDescription.text = context.getString(benevitsInfo.description)

        binding.root.setOnClickListener { onItemSelected(benevitsInfo) }

        if (!benevitsInfo.acquired) {
            Glide.with(context).load(benevitsInfo.miniLogoFullPath)
                .transition(DrawableTransitionOptions.withCrossFade(1000)).centerInside()
                .into(binding.ivLogoGet)
            binding.mainContainer.isVisible = false
            binding.clGet.isVisible = true

            binding.btnGet.setOnClickListener {
                Snackbar.make(
                    binding.btnGet,
                    context.getString(R.string.get_product_button),
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }
}
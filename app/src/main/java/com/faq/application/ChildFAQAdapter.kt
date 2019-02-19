package com.faq.application

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.faq.application.databinding.ItemChildFaqBinding
import kotlinx.android.synthetic.main.item_child_faq.view.*
import android.support.v4.view.ViewCompat.animate
import android.R.attr.rotation



class ChildFAQAdapter(val data: ArrayList<FAQItem>?) : RecyclerView.Adapter<ChildFAQAdapter.FAQViewHolder>() {

    var rotationAngle : Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FAQViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemChildFaqBinding.inflate(inflater)
        return FAQViewHolder(binding)
    }

    override fun getItemCount(): Int = data!!.size

    override fun onBindViewHolder(holder: FAQViewHolder, position: Int) = holder.bind(data!![position])

    inner class FAQViewHolder(val binding: ItemChildFaqBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FAQItem) {
            binding.child = item
            binding.root.setOnClickListener {
                if (binding.root.ll_child_items.visibility == View.VISIBLE) {
                    binding.root.ll_child_items.visibility = View.GONE
                } else {
                    binding.root.ll_child_items.visibility = View.VISIBLE
                }
                if (rotationAngle == 0) {
                    rotationAngle = 90
                } else {
                    rotationAngle = 0
                }

                binding.root.im_expand.animate().apply {
                    rotation(rotationAngle.toFloat())
                    setDuration(500)
                    start()
                }
            }
            binding.executePendingBindings()
        }
    }
}
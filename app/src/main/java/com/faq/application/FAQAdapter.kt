package com.faq.application

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.faq.application.databinding.ItemListFaqBinding

class FAQAdapter(val data: List<FAQPojo>) : RecyclerView.Adapter<FAQAdapter.FAQViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FAQViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListFaqBinding.inflate(inflater)
        return FAQViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: FAQViewHolder, position: Int) = holder.bind(data[position])

    inner class FAQViewHolder(val binding: ItemListFaqBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FAQPojo) {
            binding.faq = item
            binding.root.setOnClickListener {
                if (item.subFAQs != null) {
                    val intent = Intent(it.context, ChildFAQActivity::class.java)
                    intent.putExtra("DATA", item)
                    it.context.startActivity(intent);
                }
            }
            binding.executePendingBindings()
        }
    }
}
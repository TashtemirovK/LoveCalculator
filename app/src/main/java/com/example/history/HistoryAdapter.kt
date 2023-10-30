package com.example.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.LoveModel
import com.example.lovecalculator.databinding.ItemHistoryBinding

class HistoryAdapter(
    val onLongClick: (loveModel: LoveModel) -> Unit,
    val onCLick: (loveModel: LoveModel) -> Unit
) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val historyList = ArrayList<LoveModel>()

    fun addData(loveModel: List<LoveModel>) {
        historyList.clear()
        historyList.addAll(loveModel)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(historyList[position])
    }

    override fun getItemCount() = historyList.size

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel) {
            binding.tvFirstName.text = loveModel.fname
            binding.tvSecondName.text = loveModel.sname
            binding.tvPercent.text = loveModel.percentage

            itemView.setOnLongClickListener {
                onLongClick(loveModel)
                true
            }

            itemView.setOnClickListener {
                onCLick(loveModel)
            }
        }
    }

}
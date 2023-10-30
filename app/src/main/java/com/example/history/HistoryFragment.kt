package com.example.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentHistoryBinding
import com.example.lovecalculator.room.LoveDao
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    private var adapter = HistoryAdapter(this::onLongClick, this::onClick)

    @Inject
    lateinit var dao: LoveDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvHistory.adapter = adapter
        adapter.addData(dao.getAll())
    }

    private fun onLongClick(loveModel: LoveModel) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setMessage("Are you sure want delete this history?")
            .setTitle("Delete history")
            .setNegativeButton("nope") { dialog, _ -> dialog?.cancel() }
            .setPositiveButton("yes") { _, _ ->
                dao.delete(loveModel)
                setData()
            }
            .show()
    }

    private fun onClick(loveModel: LoveModel) {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setTitle("Time")
            .setMessage(SimpleDateFormat("d MMM yyyy HH:mm:ss").format(loveModel.insertTime))
            .setCancelable(true)
            .show()
    }

    private fun setData() {
        val loveModel = dao.getAll()
        adapter.addData(loveModel)
    }

}
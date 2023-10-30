package com.example.lovecalculator.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lovecalculator.databinding.ActivityHistoryBinding
import com.example.lovecalculator.room.LoveDao
import javax.inject.Inject

class HistoryActivity : AppCompatActivity() {

    @Inject
    lateinit var dao: LoveDao

    lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = App.appDatabase.getLoveDao().getAll()

        list.forEach {
            binding.tvHistory.append(
                " \n ${it.fname}" +
                        " \n${it.fname} " +
                        "\n ${it.percentage} " +
                        "\n ${it.result} \n"
            )
        }
    }

}
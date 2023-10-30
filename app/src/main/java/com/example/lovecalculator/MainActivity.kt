package com.example.lovecalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.di.Hero
import com.example.lovecalculator.databinding.ActivityMainBinding
import com.example.lovecalculator.view.MainPresenter
import com.example.lovecalculator.view.MainView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {


    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var hero: Hero

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        presenter.attachView(this)
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                Toast.makeText(this@MainActivity, "${hero.name} ${hero.damage}", Toast.LENGTH_SHORT).show()
                presenter.getData(etFirst.text.toString(), etSecond.text.toString())
            }
        }

    }

    override fun changeScreen(loveModel: LoveModel) {
        val intent = Intent(this, ResultFragment::class.java)
        intent.putExtra("key", loveModel)
        startActivity(intent)
    }
}



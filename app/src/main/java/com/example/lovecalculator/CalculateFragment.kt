package com.example.lovecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.di.Hero
import com.example.lovecalculate.databinding.FragmentCalculateBinding
import com.example.lovecalculator.databinding.FragmentCalculateBinding
import com.example.lovecalculator.view.MainPresenter
import com.example.lovecalculator.view.MainView
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@AndroidEntryPoint
class CalculateFragment : Fragment(), MainView {

    private lateinit var binding: FragmentCalculateBinding

    @Inject
    lateinit var presenter: MainPresenter

    var hero = Hero()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicks()
    }

    private fun initClicks() {
        with(binding) {
            btnCalculate.setOnClickListener {
                Toast.makeText(requireContext(), "${hero.name} ${hero.damage}",Toast.LENGTH_SHORT).show()
                presenter.attachView(this@CalculateFragment)
                presenter.getData(
                    etFirst.text.toString(),
                    etSecond.text.toString()
                )
            }
            btnHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
        }
    }

    override fun changeScreen(loveModel: LoveModel) {
        findNavController().navigate(R.id.resultFragment, bundleOf("key" to loveModel))
    }

}


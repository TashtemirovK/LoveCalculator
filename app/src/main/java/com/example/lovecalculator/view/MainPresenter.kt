package com.example.lovecalculator.view

import android.util.Log
import com.example.lovecalculator.LoveApi
import com.example.lovecalculator.LoveModel
import com.example.lovecalculator.room.LoveDao
import com.example.pref.Pref
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Date
import javax.inject.Inject

class MainPresenter @Inject constructor(private val api: LoveApi) {

    @Inject
    lateinit var dao: LoveDao

    @Inject
    lateinit var pref: Pref

    private val TAG = "ololo"

    private lateinit var view: MainView


    fun getData(firstName: String, secondName: String) {
        api.getPercentage(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    response.body()?.let { model ->
                        model.insertTime = Date().time
                        dao.insert(model)
                        view.changeScreen(model)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    fun attachView(view: MainView) {
        this.view = view
    }


}

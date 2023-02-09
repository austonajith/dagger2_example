package com.example.daggerme

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.daggerme.databinding.ActivityMainBinding
import com.example.daggerme.utils.NetworkUtils
import com.example.daggerme.utils.PrefHelper
import javax.inject.Inject
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var prefHelper: PrefHelper
    @Inject
    lateinit var networkUtils: NetworkUtils
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()
    }

    private fun initView() {
        binding.btnSaveNum.setOnClickListener {
            prefHelper.put("DaggerMsg", "${Random.nextInt()}")
            val result = prefHelper.pref().getString("DaggerMsg", "empty")
            binding.textView.text = result
        }

        binding.btnCheckNet.setOnClickListener {
            Toast.makeText(this, networkUtils.isInternetAvailable().toString(), Toast.LENGTH_SHORT).show()
        }
    }


}
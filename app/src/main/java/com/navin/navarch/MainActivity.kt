package com.navin.navarch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.navin.navarch.base.BaseActivity
import com.navin.navarch.databinding.ActivityLauncherBinding
import com.navin.navarch.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)    }
}
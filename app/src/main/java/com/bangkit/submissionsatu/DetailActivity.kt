package com.bangkit.submissionsatu

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.bangkit.submissionsatu.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        const val agentDetais = "AGENT_DETAILS"
    }

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(agentDetais, Agent::class.java)
        } else {
            intent.getParcelableExtra(agentDetais)
        }

        binding.agentImage.load(data?.image) {
            placeholder(R.drawable.loading_img)
        }
        binding.agentName.text = data?.name
        binding.agentExplain.text = data?.details
        binding.agentDetail.text = data?.explain

    }
}
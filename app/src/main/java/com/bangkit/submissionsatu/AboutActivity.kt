package com.bangkit.submissionsatu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.bangkit.submissionsatu.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private var _binding: ActivityAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

    val profileUrl = "https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/small/avatar/dos:aa662b8c84c335b3062b2cbba10c22fe20231110201402.png"
        binding.profileImage.load(profileUrl) {
            placeholder(R.drawable.loading_animation)
        }

        createShareButton()
    }

    fun createShareButton() {
        binding.actionShare.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Shout me out please: https://github.com/salafqt/someAgents/"
                )
                type = "text/plain"
            }
            startActivity(Intent.createChooser(sendIntent, null))
        }
    }

}
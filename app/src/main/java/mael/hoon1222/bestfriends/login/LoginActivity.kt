package mael.hoon1222.bestfriends.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mael.hoon1222.bestfriends.MainActivity
import mael.hoon1222.bestfriends.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupListener()
    }

    private fun setupListener() = with(binding) {
        btnLogin.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

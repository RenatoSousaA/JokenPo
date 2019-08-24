package br.com.fiap.jokenpo.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.jokenpo.R
import br.com.fiap.jokenpo.game.gamePlay.GamePlayActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btNewGame.setOnClickListener {
            startActivity(Intent(this, GamePlayActivity::class.java))
        }
        btExit.setOnClickListener {
            finish()
        }
    }
}

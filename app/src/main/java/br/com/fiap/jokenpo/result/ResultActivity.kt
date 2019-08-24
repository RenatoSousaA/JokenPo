package br.com.fiap.jokenpo.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.jokenpo.R
import kotlinx.android.synthetic.main.activity_play_game.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getStringExtra("GameResult")

        if(result == "Win") {
            tvResult.text = "Você Venceu"
            avWin.setAnimation("trofeu.json")
            tvResult.setTextAppearance(this, R.style.title_Win)
        } else {
            tvResult.text = "Você Perdeu"
            avWin.setAnimation("lose.json")
            tvResult.setTextAppearance(this, R.style.title_Lose)
        }
    }
}

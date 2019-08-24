package br.com.fiap.jokenpo.gamePlay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.content.ContextCompat
import br.com.fiap.jokenpo.R
import br.com.fiap.jokenpo.game.gamePlay.GamePlayActivity
import br.com.fiap.jokenpo.main.MainActivity
import br.com.fiap.jokenpo.result.ResultActivity
import kotlinx.android.synthetic.main.activity_play_game.*
import kotlin.random.Random

class PlayGameActivity : AppCompatActivity() {

    var stopRandom = false

    var selectComputer = "";
    var selectPlayer = "";

    var scorePlayer = 1
    var scoreComputer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_game)

        imgPedra()

        btPapel.setOnClickListener {
            ivPlayer.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.papel))
            selectPlayer = "Papel"
            stopComputer()
        }

        btPedra.setOnClickListener {
            ivPlayer.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pedra))
            selectPlayer = "Pedra"
            stopComputer()
        }

        btTesoura.setOnClickListener {
            ivPlayer.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.tesoura))
            selectPlayer = "Tesoura"
            stopComputer()
        }

        ivReload.setOnClickListener {
            resetGame()
        }

    }

    private fun resetGame() {
        tvEventName.text = "Escolha uma opção"
        btTesoura.setClickable(true);
        btPedra.setClickable(true);
        btPapel.setClickable(true);
        stopRandom = false
        ivComputerSelect.setVisibility(View.INVISIBLE);
        ivComputer.setVisibility(View.VISIBLE);
        tvEventName.setTextAppearance(this, R.style.title_escolha)
        imgPedra()
    }

    private fun stopComputer() {
        stopRandom = true;

        val random = Random.nextInt(3)

        if (random == 0) {
            ivComputerSelect.setVisibility(View.VISIBLE);
            ivComputer.setVisibility(View.INVISIBLE);
            ivComputerSelect.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pedra))
            selectComputer = "Pedra"
        } else if (random == 1) {
            ivComputerSelect.setVisibility(View.VISIBLE);
            ivComputer.setVisibility(View.INVISIBLE);
            ivComputerSelect.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.tesoura))
            selectComputer = "Tesoura"
        } else {
            ivComputerSelect.setVisibility(View.VISIBLE);
            ivComputer.setVisibility(View.INVISIBLE);
            ivComputerSelect.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.papel))
            selectComputer = "Papel"
        }

        verificaGanhador()
    }

    private fun verificaGanhador() {
        if (
            (selectPlayer == "Papel" && selectComputer == "Pedra") ||
            (selectPlayer == "Pedra" && selectComputer == "Tesoura") ||
            (selectPlayer == "Tesoura" && selectComputer == "Papel")
        ) {
            tvEventName.text = "Você Venceu!"
            tvEventName.setTextAppearance(this, R.style.title_Win)
            tvPontuacaoPlayer.text = scorePlayer++.toString()
        } else if (selectComputer == selectPlayer) {
            tvEventName.text = "Ops, deu empate!"
            tvEventName.setTextAppearance(this, R.style.title_draw)
        } else {
            tvEventName.text = "Você Perdeu!"
            tvEventName.setTextAppearance(this, R.style.title_Lose)
            tvPontuacaoComputer.text = scoreComputer++.toString()
        }

        if (scoreComputer > 3) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("GameResult", "Lose")
            startActivity(intent)
        } else if(scorePlayer > 3) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("GameResult", "Win")
            startActivity(intent)
        } else {
            btTesoura.setClickable(false);
            btPedra.setClickable(false);
            btPapel.setClickable(false);
        }
    }

    private fun imgPedra() {
        Handler().postDelayed({
            ivComputer.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pedra))
            if(!stopRandom) {
                imgTesoura()
            }
        }, 100L)
    }

    private fun imgTesoura() {
        Handler().postDelayed({
            ivComputer.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.tesoura))
            if(!stopRandom) {
                imgPapel()
            }
        }, 100L)
    }

    private fun imgPapel() {
        Handler().postDelayed({
            ivComputer.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.papel))
            if(!stopRandom) {
                imgPedra()
            }
        }, 100L)
    }


}

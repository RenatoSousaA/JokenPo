package br.com.fiap.jokenpo.game.gamePlay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.jokenpo.R
import br.com.fiap.jokenpo.game.playerOne.PlayerOneFragment
import kotlinx.android.synthetic.main.activity_game_play.*

class GamePlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)

        showEventFragment()
        ivBack.setOnClickListener {
            onBackPressed()
        }

    }

    private fun showEventFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.containerGame, PlayerOneFragment())
        ft.commit()
    }
}

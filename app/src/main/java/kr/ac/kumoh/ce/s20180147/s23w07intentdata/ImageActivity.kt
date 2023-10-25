package kr.ac.kumoh.ce.s20180147.s23w07intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import kr.ac.kumoh.ce.s20180147.s23w07intentdata.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity(), OnClickListener {
    companion object{
        const val TANK_NAME = "tank name"
        const val TANK_RESULT = "tank result"

        const val LIKE = 100
        const val HATE = 101
        const val NONE = 0
    }

    private lateinit var main:ActivityImageBinding
    private lateinit var tanks:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        main = ActivityImageBinding.inflate(layoutInflater)
        setContentView(main.root)

        tanks = intent.getStringExtra(MainActivity.KEY_NAME) ?: "NULL"

        val res = when(tanks){
            MainActivity.AMX50B -> R.drawable.amx50b
            MainActivity.AMXM454 -> R.drawable.amxm454
            else -> R.drawable.ic_launcher_foreground
        }
        main.img1.setImageResource(res)

        main.btnlike.setOnClickListener(this)
        main.btnhate.setOnClickListener(this)
    }

    override fun onClick(p: View?) {
        val value = when(p?.id){
            main.btnlike.id -> LIKE
            main.btnhate.id -> HATE
            else -> NONE
        }
        val lahe = when(p?.id){
            main.btnlike.id -> "개추"
            main.btnhate.id -> "비추"
            else -> "error"
        }
        val intent = Intent()
        Toast.makeText(this, lahe, Toast.LENGTH_SHORT).show()
        intent.putExtra(TANK_NAME, tanks)
        intent.putExtra(TANK_RESULT, value)
        setResult(RESULT_OK, intent)
        finish()
    }
}
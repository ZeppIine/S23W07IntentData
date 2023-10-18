package kr.ac.kumoh.ce.s20180147.s23w07intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.ac.kumoh.ce.s20180147.s23w07intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        const val KEY_NAME = "tank"
    }
    private lateinit var main:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        main.btn1.setOnClickListener {
            Toast.makeText(this, "무장공비", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra(KEY_NAME, "amx50b")
            main.text1.setText("AMX 50B")
            startActivity(intent)
        }

        main.btn2.setOnClickListener {
            Toast.makeText(this, "빵헤비", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra(KEY_NAME, "amxm454")
            main.text1.setText("AMX M4 54")
            startActivity(intent)
        }
    }
}
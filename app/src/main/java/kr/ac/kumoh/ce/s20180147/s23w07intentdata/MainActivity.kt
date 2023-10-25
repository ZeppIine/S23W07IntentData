package kr.ac.kumoh.ce.s20180147.s23w07intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kr.ac.kumoh.ce.s20180147.s23w07intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    companion object{
        const val KEY_NAME = "tank"
        const val AMX50B = "amx50b"
        const val AMXM454 = "amxm454"
    }
    private lateinit var main:ActivityMainBinding

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if(it.resultCode != RESULT_OK) return@registerForActivityResult

        val result = it.data?.getIntExtra( ImageActivity.TANK_RESULT, ImageActivity.NONE )
        val str = when(result){
            ImageActivity.LIKE -> "개추"
            ImageActivity.HATE -> "비추"
            else -> ""
        }
        when (it.data?.getStringExtra(ImageActivity.TANK_NAME)){
            AMX50B -> main.btn1.text = "$AMX50B ($str)"
            AMXM454 -> main.btn2.text = "$AMXM454 ($str)"
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        main.btn1.setOnClickListener(this)
        main.btn2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val value = when(v?.id){
            main.btn1.id -> AMX50B
            main.btn2.id -> AMXM454
            else -> return
        }
        val tank_text = when(v?.id){
            main.btn1.id -> "AMX 50B"
            main.btn2.id -> "AMX M4 54"
            else -> "error"
        }
        Toast.makeText(this, tank_text, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, AnotherActivity::class.java)
        intent.putExtra(KEY_NAME, value)
        main.text1.text = tank_text
//        startActivity(intent)
        startForResult.launch(intent)
    }
}
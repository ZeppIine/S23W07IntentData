package kr.ac.kumoh.ce.s20180147.s23w07intentdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kumoh.ce.s20180147.s23w07intentdata.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    private lateinit var main:ActivityImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        main = ActivityImageBinding.inflate(layoutInflater)
        setContentView(main.root)

        val res = when(intent.getStringExtra(MainActivity.KEY_NAME)){
            "amx50b" -> R.drawable.amx50b
            "amxm454" -> R.drawable.amxm454
            else -> R.drawable.ic_launcher_foreground
        }
        main.img1.setImageResource(res)
    }
}
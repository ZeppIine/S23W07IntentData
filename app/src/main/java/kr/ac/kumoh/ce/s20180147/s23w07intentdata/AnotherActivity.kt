package kr.ac.kumoh.ce.s20180147.s23w07intentdata

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kr.ac.kumoh.ce.s20180147.s23w07intentdata.AnotherActivity.Companion.HATE
import kr.ac.kumoh.ce.s20180147.s23w07intentdata.AnotherActivity.Companion.LIKE
import kr.ac.kumoh.ce.s20180147.s23w07intentdata.AnotherActivity.Companion.RESULT_OK
import kr.ac.kumoh.ce.s20180147.s23w07intentdata.AnotherActivity.Companion.TANK_NAME
import kr.ac.kumoh.ce.s20180147.s23w07intentdata.AnotherActivity.Companion.TANK_RESULT
import kr.ac.kumoh.ce.s20180147.s23w07intentdata.ui.theme.S23W07IntentDataTheme

class AnotherActivity : ComponentActivity() {
    companion object{
        const val TANK_NAME = "tank name"
        const val TANK_RESULT = "tank result"

        const val LIKE = 100
        const val HATE = 101
        const val NONE = 0

        const val RESULT_OK = -1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S23W07IntentDataTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TankImage()
                }
            }
        }
    }
}

fun onResultClick(activity: Activity, tankName: String?, tankResult: Int) {
    val intent = Intent()
    intent.putExtra(TANK_NAME, tankName)
    intent.putExtra(TANK_RESULT, tankResult)
    activity.setResult(RESULT_OK, intent)
    activity.finish()
}

@Composable
fun TankImage(modifier: Modifier = Modifier){
    val context = LocalContext.current
    val activity = context as Activity
    val intent = activity.intent
//    val intent = (LocalContext.current as MainActivity).intent
    val tankname = intent.getStringExtra(MainActivity.KEY_NAME)
    val res = when(tankname){
        MainActivity.AMX50B -> R.drawable.amx50b
        MainActivity.AMXM454 -> R.drawable.amxm454
        else -> R.drawable.ic_launcher_foreground
    }
    Image(
        modifier = modifier,
        painter = painterResource(id = res),
        contentScale = ContentScale.FillWidth,
        contentDescription = "Tank Image"
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Bottom),
        horizontalArrangement =  Arrangement.SpaceEvenly
    ){
        Button(onClick = {
            onResultClick(activity, tankname, LIKE)
        }) {
            Text("개추")
        }
        Button(onClick = {
            onResultClick(activity, tankname, HATE)
        }) {
            Text("비추")
        }
    }
}
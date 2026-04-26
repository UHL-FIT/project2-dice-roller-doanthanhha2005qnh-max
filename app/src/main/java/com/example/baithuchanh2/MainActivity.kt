package com.example.baithuchanh2

import android.R.attr.onClick
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.baithuchanh2.ui.theme.BaiThucHanh2Theme
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaiThucHanh2Theme {
                DiceRollerApp()
            }
        }
    }

}



    @Preview
@Composable
fun DiceRollerApp() {
        DiceWithButtonAndImage()
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    Column(
        modifier = modifier
            .fillMaxSize() // 1. Bắt Column phải nở ra chiếm hết toàn bộ màn hình
            .wrapContentSize(Alignment.Center), // 2. Đưa nội dung bên trong vào chính giữa diện tích đó
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )

        Spacer(modifier = Modifier.height(16.dp))



        Button(onClick = { result = (1..6).random() }) {
            Text(stringResource(R.string.roll))


        }
    }

}



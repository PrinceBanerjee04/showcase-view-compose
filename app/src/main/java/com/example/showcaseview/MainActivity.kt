package com.example.showcaseview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.showcaseview.ui.theme.ShowCaseViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowCaseViewTheme {
                Surface {
                    SampleShowcase()
                }
            }
        }
    }
}

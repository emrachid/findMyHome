package com.redspace.findmyhome

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.redspace.findmyhome.ui.theme.FindMyHomeTheme

class ProfileActivity : ComponentActivity() {
    private val property: Property by lazy { intent?.getSerializableExtra(PUPPY_ID) as Property }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FindMyHomeTheme {
                ProfileScreen(property)
            }
        }
    }

    companion object {
        private const val PUPPY_ID = "puppy_id"

        fun newIntent(context: Context, property: Property) =
            Intent(context, ProfileActivity::class.java).apply { putExtra(PUPPY_ID, property) }
    }
}

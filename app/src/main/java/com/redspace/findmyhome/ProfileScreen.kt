package com.redspace.findmyhome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(property: Property) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxWidth()) {
        BoxWithConstraints {
            Surface {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                ) {
                    ProfileHeader(
                        property = property,
                        containerHeight = this@BoxWithConstraints.maxHeight
                    )
                    ProfileContent(
                        property = property,
                        containerHeight = this@BoxWithConstraints.maxHeight
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileHeader(property: Property, containerHeight: Dp) {
    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        painter = painterResource(id = property.imageId),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
fun ProfileContent(property: Property, containerHeight: Dp) {
    Column {
        Title(property = property)
        ProfileProperty(label = stringResource(R.string.address), value = property.address)
        ProfileProperty(label = stringResource(R.string.bedrooms), value = property.bedrooms.toString())
        ProfileProperty(label = stringResource(R.string.description), value = property.description)
        
        Spacer(modifier = Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
private fun Title(property: Property) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)) {
        Text(
            text = property.title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun ProfileProperty(label: String, value: String) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = label,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = value,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Visible
        )
    }
}
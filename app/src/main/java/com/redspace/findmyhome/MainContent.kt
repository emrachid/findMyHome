package com.redspace.findmyhome

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp

@Composable
fun MainContent(navigateToProfile: (Property) -> Unit) {
    val properties = remember { DataProvider.propertyLists }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = properties,
            itemContent = {
                PropertyListItem(property = it, navigateToProfile)
            }
        )
    }
}

package org.utl.ldsm406_harrypotterapp.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RemoveImage(
    imageUrl: String?,
    contentDescription: String?,
    modifier: Modifier = Modifier
){
    GlideImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier
    )
}
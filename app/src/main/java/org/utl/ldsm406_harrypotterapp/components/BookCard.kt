package org.utl.ldsm406_harrypotterapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.utl.ldsm406_harrypotterapp.R
import org.utl.ldsm406_harrypotterapp.data.model.Book
import org.utl.ldsm406_harrypotterapp.data.model.Character

@Composable
fun BookCard(book: Book){
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.cafe),
        ),
        border = BorderStroke(1.dp, colorResource(R.color.dorado))
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RemoveImage(
                imageUrl = book.cover,
                contentDescription = book.title,
                modifier = Modifier.size(100.dp)
                )
            Spacer(modifier = Modifier.width(12.dp))
            Column() {
                Text(
                    text = book.title ?: "Sin datos",
                    style = MaterialTheme.typography.titleMedium,
                    color = colorResource(R.color.gold),
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "Autor: ${book.author ?: "Sin datos"}",
                    color = colorResource(R.color.plata)
                )
                Text(
                    text = "Fecha de lanzamiento: ${book.release_date ?: "Sin datos"}",
                    color = colorResource(R.color.plata)
                )
                Text(
                    text = "Paginas: ${book.pages ?: "Sin datos"}",
                    color = colorResource(R.color.plata)
                )
            }
        }
    }
}
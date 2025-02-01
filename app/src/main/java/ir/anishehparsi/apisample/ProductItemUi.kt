package ir.anishehparsi.apisample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun ProductItemUi(modifier: Modifier = Modifier, item: Product) {
    Row(modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            modifier=Modifier.size(64.dp,80.dp),
            contentScale = ContentScale.Crop,
            model = item.image,
            contentDescription = ""
        )

        Spacer(Modifier.width(12.dp))

        Column (verticalArrangement = Arrangement.Center){
            Text(text = item.title)
            Spacer(modifier.height(4.dp))
            Text(text = "$ ${item.price}")
            Spacer(modifier.height(4.dp))
            Row {
                Image(
                    painter = painterResource(R.drawable.baseline_star_24),
                    contentDescription = ""
                )
                Spacer(Modifier.width(4.dp))
                Text(text = item.rating.rate.toString())}
        }
    }

}
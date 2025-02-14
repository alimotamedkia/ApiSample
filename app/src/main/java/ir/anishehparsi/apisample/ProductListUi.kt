package ir.anishehparsi.apisample

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

@Composable
fun ProductListUi(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var state by remember { mutableStateOf<List<Product>?>(null) }

    LaunchedEffect(key1 = Unit) {
        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json)
            }
        }

        try {
            state = client.get("https://emojihub.yurace.pro/api/all").body()
            Log.d("CoroutineTag", state.toString())
        } catch (e: Exception) {
            val toast =
                Toast.makeText(context, "No Connection to INTERNET", Toast.LENGTH_LONG).show()
            state = emptyList()
        } finally {
            client.close()


        }
    }

    LazyColumn(Modifier.padding(16.dp)) {
        items(state ?: emptyList()) {
            ProductItemUi(item = it)
            HorizontalDivider()
        }
    }
}
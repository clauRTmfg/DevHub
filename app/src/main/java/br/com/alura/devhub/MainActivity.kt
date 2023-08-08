package br.com.alura.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.devhub.ui.theme.DevHubTheme
import android.content.res.Configuration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserCard(
                        UsuarioGitHub(
                            "Claudio Renato",
                            "clauRTmfg",
                            "Aluno da Alura, aprendendo Android com Kotlin",
                            R.drawable.imagem_clau
                        )
                    )
                }
            }
        }
    }
}

data class UsuarioGitHub(
    val nome: String,
    val username: String,
    val bio: String,
    val imagem: Int
)

@Composable
fun UserCard(usuario: UsuarioGitHub) {

    Column {

        Image(
            painter = painterResource(usuario.imagem),
            contentDescription = "Contact profile picture",
        )

        Text(
            text = usuario.nome,
            style = MaterialTheme.typography.titleSmall
        )

        Text(
            text = usuario.bio,
            modifier = Modifier.padding(all = 4.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    DevHubTheme {
        Surface {
            UserCard(
                UsuarioGitHub(
                    "Claudio",
                    "clauRT",
                    "7 Days of Code",
                    R.drawable.imagem_clau
                )
            )
        }
    }
}
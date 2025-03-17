package br.dev.flp.empregamais.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.provider.FontsContractCompat

// Definição das cores
val NavyBlue = Color(0xFF002366)
val LightBlue = Color(0xFF4A90E2)
val DarkGray = Color(0xFF2C2C2C)
val Gold = Color(0xFFFFC107)
val White = Color(0xFFFFFFFF)

// Gradiente de fundo
val BackgroundGradient = Brush.verticalGradient(
    colors = listOf(NavyBlue, LightBlue, White)
)


// Definição do esquema de cores
private val DarkColorScheme = darkColorScheme(
    primary = NavyBlue,
    secondary = LightBlue,
    background = DarkGray,
    surface = NavyBlue,
    onPrimary = White,
    onSecondary = White,
    onBackground = White,
    onSurface = White
)

private val LightColorScheme = lightColorScheme(
    primary = NavyBlue,
    secondary = LightBlue,
    background = White,
    surface = NavyBlue,
    onPrimary = White,
    onSecondary = White,
    onBackground = DarkGray,
    onSurface = DarkGray
)

// Aplicação do tema
@Composable
fun EmpregamaisTheme(
    darkTheme: Boolean = false, // Você pode ajustar conforme necessário
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    val CustomFont = null
    MaterialTheme(
        colorScheme = colors,
        typography = Typography(
            titleLarge = Typography().titleLarge.copy(fontFamily = CustomFont, fontWeight = FontWeight.Bold),
            bodyLarge = Typography().bodyLarge.copy(fontFamily = CustomFont)
        ),
        shapes = Shapes(
            small = RoundedCornerShape(4.dp),
            medium = RoundedCornerShape(8.dp),
            large = RoundedCornerShape(16.dp)
        ),
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BackgroundGradient)
            ) {
                content()
            }
        }
    )
}

// Preview do tema
@Preview
@Composable
fun PreviewTheme() {
    EmpregamaisTheme {
        Text(text = "EmpregaMais App", color = White)
    }
}

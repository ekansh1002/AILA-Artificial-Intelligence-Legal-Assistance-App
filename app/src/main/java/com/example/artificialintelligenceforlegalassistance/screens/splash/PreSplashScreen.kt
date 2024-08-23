import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.artificialintelligenceforlegalassistance.R
import com.example.artificialintelligenceforlegalassistance.navigation.AilaScreens
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun PreSplashScreen(navController: NavHostController) {
    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(0.9f, tween(durationMillis = 800, easing = { OvershootInterpolator(8f).getInterpolation(it) }))
        delay(1000L)

        if (FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()) {
            navController.navigate(AilaScreens.SplashScreen.name)
        } else {
            navController.navigate(AilaScreens.HomeScreen.name)
            // navController.navigate(ReaderScreens.LoginScreen.name)
        }
    }

    Surface(
        modifier = Modifier
            .padding(15.dp)
            .scale(scale.value)
        .fillMaxSize(),
        shape = CircleShape,
        color = Color.White,
        //border = BorderStroke(width = 2.dp, color = Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .clip(CircleShape),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.splash),
                contentDescription = "Splash Screen Image", // Provide a descriptive content description
                modifier = Modifier.fillMaxWidth() // Adjust sizing as needed
            )

            //Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "\"AI's here to help you.\"",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black
            )
        }
    }
}

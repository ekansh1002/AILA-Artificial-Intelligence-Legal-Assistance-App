package com.example.artificialintelligenceforlegalassistance.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.artificialintelligenceforlegalassistance.R
import com.example.artificialintelligenceforlegalassistance.navigation.AilaScreens

@Composable
fun AilaLogo(modifier: Modifier = Modifier) {
    Column(horizontalAlignment = CenterHorizontally){
        Text(
        modifier = modifier
            .padding(15.dp),
        text = "Artificial intelligence for legal Assistance ",
        style = MaterialTheme.typography.headlineLarge,
        color = Color(0xFFAF1BC9),
            textAlign = TextAlign.Center
    )
    }
}

@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    emailState: MutableState<String>,
    labelId: String = "Email",
    enabled: Boolean = true,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default){
    InputField(
        valueState = emailState,
        labelId = labelId,
        modifier = modifier,
        enabled = enabled,
        keyboardType = KeyboardType.Email,
        imeAction = imeAction,
        onAction = onAction)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelId: String,
    enabled: Boolean = true,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
){
    OutlinedTextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        label = { Text(text = labelId)},
        singleLine = isSingleLine,
        textStyle = TextStyle(fontSize = 18.sp, color = MaterialTheme.colorScheme.onBackground),
        modifier = modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(
    modifier: Modifier,
    passwordState: MutableState<String>,
    labelId: String,
    enabled: Boolean,
    passwordVisibility: MutableState<Boolean>,
    imeAction: ImeAction = ImeAction.Done,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    val visualTransformation = if(passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
    OutlinedTextField(
        value = passwordState.value,
        onValueChange = { passwordState.value = it},
        label = { Text(text = labelId)},
        singleLine = true,
        textStyle = TextStyle(fontSize = 18.sp, color = MaterialTheme.colorScheme.onBackground),
        modifier = modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Password,
            imeAction = imeAction),
        visualTransformation = visualTransformation,
        trailingIcon = {PasswordVisibility(passwordVisibility = passwordVisibility)},
        keyboardActions = onAction
    )
}

@Composable
fun PasswordVisibility(passwordVisibility: MutableState<Boolean>) {

    val visible = passwordVisibility.value
    IconButton(onClick = { passwordVisibility.value = !visible}) {
        Icons.Default.Close
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AilaAppBar(
    title: String,
    icon: ImageVector? = null,
    showProfile: Boolean,
    navController: NavController,
    onBackArrowClicked: () -> Unit = {}
){
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly) {
                if(showProfile){
                    Icon(imageVector = Icons.Default.Settings, contentDescription = "icon", modifier = Modifier
                        .scale(0.8f))
                }
                if(icon != null){
                    Icon(imageVector = icon, contentDescription = "arrow back", tint = Color.Red.copy(0.7f), modifier = Modifier.clickable {
                        onBackArrowClicked.invoke()
                    })
                }
                Spacer(modifier = Modifier.width(50.dp))
                Text(
                    text = title,
                    color = Color.Black.copy(0.8f),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                )

            }
        },
        actions = {


        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent)
    )
}


@Composable
fun CircleButtons(image: Int, text: String,onPress: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .size(150.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onPress.invoke()
                },
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Image in Round Card",
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = text,
                color = Color(0xFFAF1BC9),
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
        }
    }
}




@Composable
fun LawChatWithAI(
    modifier: Modifier = Modifier,
) {
    Column(  modifier = modifier
        .fillMaxWidth()
        .height(120.dp)) {
        Image(painter = painterResource(id = R.drawable.lcwa),
            contentDescription ="LCWA",
            modifier= Modifier
                .fillMaxWidth()
                .height(120.dp))
    }
}

@Composable
fun CardComp(
    modifier: Modifier = Modifier,
    image: Int,
    text: String,
    onPress: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(8.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                onPress.invoke()
            }) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Law Chat with AI",
                    modifier= Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                )
                Text(text = text,modifier = Modifier.padding(start = 5.dp))
            }
    }
}




@Composable
fun AilaBottomAppBar(navController: NavController) {
    Divider()
    BottomAppBar(containerColor = Color.White,
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(onClick = { navController.navigate(AilaScreens.HomeScreen.name) }) {
                    Icon(Icons.Filled.Home, contentDescription = "Localized description")
                }
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(onClick = { navController.navigate(AilaScreens.ChatScreen.name) }) {
                    Icon(
                        Icons.Filled.ChatBubble,
                        contentDescription = "Localized description",
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(onClick = { navController.navigate(AilaScreens.SearchScreen.name) }) {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = "Localized description",
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(onClick = { navController.navigate(AilaScreens.SettingsScreen.name) }) {
                    Icon(
                        Icons.Filled.Settings,
                        contentDescription = "Localized description",
                    )
                }
            }
        }
    )
}








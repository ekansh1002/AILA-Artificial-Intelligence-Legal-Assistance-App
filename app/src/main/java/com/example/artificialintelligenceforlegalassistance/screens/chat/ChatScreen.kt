package com.example.artificialintelligenceforlegalassistance.screens.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.artificialintelligenceforlegalassistance.components.AilaBottomAppBar
import com.example.artificialintelligenceforlegalassistance.data.ChatState

@Composable
fun ChatsScreen(navController: NavController, paddingValues: PaddingValues) {
    val chaViewModel: ChatViewModel = viewModel()
    val chatState by chaViewModel.chatState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "ChatBot",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = MaterialTheme.typography.titleLarge.fontFamily)
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            reverseLayout = true
        ) {
            itemsIndexed(chatState.chatList) { _, chat ->
                if (chat.isFromUser) {
                    UserChatItem(prompt = chat.prompt)
                } else {
                    ModelChatItem(response = chat.prompt)
                }
            }
        }

        ChatInputRow(
            chatState = chatState,
            onSendClick = {
                chaViewModel.onEvent(ChatUiEvent.SendPrompt(chatState.prompt))
            },
            onPromptChange = { chaViewModel.onEvent(ChatUiEvent.UpdatePrompt(it)) }
        )

        AilaBottomAppBar(navController = navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatInputRow(
    chatState: ChatState,
    onSendClick: () -> Unit,
    onPromptChange: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier.weight(1f),
            value = chatState.prompt,
            onValueChange = onPromptChange,
            placeholder = { Text(text = "Type a prompt") }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            modifier = Modifier
                .clickable { onSendClick() },
            imageVector = Icons.Rounded.Send,
            contentDescription = "Send prompt",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun UserChatItem(prompt: String) {
    Column(
        modifier = Modifier.padding(start = 100.dp, bottom = 16.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp),
            text = prompt,
            fontSize = 17.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun ModelChatItem(response: String) {
    Column(
        modifier = Modifier.padding(end = 100.dp, bottom = 16.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.secondary)
                .padding(16.dp),
            text = response,
            fontSize = 17.sp,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}

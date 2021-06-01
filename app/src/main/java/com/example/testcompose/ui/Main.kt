package com.example.testcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowRight
import androidx.compose.material.icons.twotone.CheckBoxOutlineBlank
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcompose.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateAccessibilityScreen()
        }
    }
}

@Preview
@Composable
fun CreateAccessibilityScreen() {
    Column {
        makeHeader()
        makePartToCheckClause()
        makePartToGoToNextScreen()
    }
}

@Composable
fun makeHeader() {
    Column(modifier = Modifier.semantics(mergeDescendants = true) {}) {
        Box(
            modifier = Modifier
                .height(450.dp)
                .semantics { /*todo*/ } //stateDescription = if (selected) ... else ... }
        ) {
            Image(
                painter = painterResource(R.drawable.listening_to_music),
                contentDescription = null,
                modifier = Modifier.height(450.dp),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            modifier = Modifier
                .padding(all = 16.dp)
                .semantics { heading() },
            text = "Escute suas músicas favoritas",
            style = typography.h4,
            maxLines = 2,
        )
    }
}

@Composable
fun makePartToCheckClause() {
    Spacer(modifier = Modifier.height(20.dp))
    Row {
        IconButton(
            modifier = Modifier
                .padding(start = 10.dp)
                .size(40.dp),
            onClick = { }
        ) {
            Icon(
                modifier = Modifier
                    .size(40.dp),
                contentDescription = "Clique aqui para marcar essa opção",
                imageVector = Icons.TwoTone.CheckBoxOutlineBlank,
            )
        }
        Text(
            modifier = Modifier
                .padding(start = 16.dp, top = 10.dp)
                .clearAndSetSemantics { /* todo */ },
            text = "Texto deve ser ignorado",
            style = typography.subtitle1

        )
    }
}


@Composable
fun makePartToGoToNextScreen() {
    Spacer(modifier = Modifier.height(30.dp))
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(start = 16.dp)
                .clip(shape = RoundedCornerShape(35.dp))
                .background(MaterialTheme.colors.secondaryVariant)
        ) {
            IconButton(
                modifier = Modifier
                    .size(70.dp),
                onClick = { }
            ) {
                Icon(
                    modifier = Modifier.fillMaxSize(),
                    imageVector = Icons.TwoTone.ArrowRight,
                    contentDescription = "Clique aqui para avançar para a próxima tela"
                )
            }
        }
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Lorem ipsum pharetra a elementum molestie ullamcorper aenean test",
            style = typography.subtitle1
        )
    }
}




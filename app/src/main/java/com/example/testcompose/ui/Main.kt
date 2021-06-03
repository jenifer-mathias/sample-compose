package com.example.testcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    Column(
        modifier = Modifier
            .verticalScroll(
                rememberScrollState()
            )
            .background(Color.White)
    ) {
        MakeHeader()
        MakePartToCheckClause()
        MakeSecondHeader()
        MakePartToGoToNextScreen()
    }
}

@Composable
fun MakeHeader() {
    Column(modifier = Modifier.semantics(mergeDescendants = true) {}) {
        Box(
            modifier = Modifier
                .height(450.dp)
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
            text = "Lorem ipsum curae diam, nostra",
            style = typography.h4
        )
    }
}

@Composable
fun MakePartToCheckClause() {
    Spacer(modifier = Modifier.height(20.dp))
    Column {
        Row {
            val firstCheckboxIsChecked = remember { mutableStateOf(false) }
            Checkbox(
                enabled = true,
                checked = firstCheckboxIsChecked.value,
                onCheckedChange = { firstCheckboxIsChecked.value = it },
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clearAndSetSemantics {
                        this.contentDescription = "Checkbox"
                    },
                colors = CheckboxDefaults.colors(MaterialTheme.colors.secondaryVariant)
            )
            Text(
                modifier = Modifier
                    .padding(start = 16.dp),
                text = "Lorem ipsum euismod rutrum. ",
                style = typography.subtitle1
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 24.dp)
        ) {
            val secondCheckboxIsChecked = remember { mutableStateOf(false) }
            Checkbox(
                enabled = true,
                checked = secondCheckboxIsChecked.value,
                onCheckedChange = { secondCheckboxIsChecked.value = it },
                modifier = Modifier
                    .padding(start = 16.dp)
                    .semantics {
                        this.contentDescription = "Checkbox"
                    },
                colors = CheckboxDefaults.colors(MaterialTheme.colors.secondaryVariant)
            )
            Text(
                modifier = Modifier
                    .padding(start = 16.dp),
                text = "Lorem ipsum convallis port. ",
                style = typography.subtitle1
            )
        }
    }
    Row(modifier = Modifier.padding(top = 24.dp)) {
        val thirdCheckboxIsChecked = remember { mutableStateOf(false) }
        Checkbox(
            enabled = true,
            checked = thirdCheckboxIsChecked.value,
            onCheckedChange = { thirdCheckboxIsChecked.value = it },
            modifier = Modifier
                .padding(start = 16.dp),
            colors = CheckboxDefaults.colors(MaterialTheme.colors.secondaryVariant)
        )
        Text(
            modifier = Modifier
                .semantics { SemanticsProperties.HorizontalScrollAxisRange }
                .padding(start = 16.dp),
            text = "Lorem ipsum odio netus ut pretium, lacus scelerisque leo aenean. ",
            style = typography.subtitle1
        )
    }
}

@Composable
fun MakeSecondHeader() {
    Spacer(modifier = Modifier.height(10.dp))
    Column {
        Text(
            modifier = Modifier
                .padding(all = 16.dp)
                .semantics { heading() },
            text = "Lorem ipsum eleifend",
            style = typography.h4
        )
        Text(
            modifier = Modifier
                .padding(16.dp)
                .clearAndSetSemantics { /* todo */ },
            text = stringResource(id = R.string.bigger_text),
            style = typography.subtitle1
        )
    }
}

@Composable
fun MakePartToGoToNextScreen() {
    Row(modifier = Modifier.padding(start = 16.dp, bottom = 10.dp)) {
        Card(
            modifier = Modifier
                .size(60.dp),
            shape = CircleShape,
            elevation = 2.dp
        ) {
            Image(
                painterResource(R.drawable.ic_right_arrow),
                contentDescription = "Clique aqui para avançar para a próxima tela",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clickable { }
            )
        }
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 10.dp),
            text = "Lorem ipsum pharetra a elementum molestie ullamcorper aenean test",
            style = typography.subtitle1
        )
    }
}






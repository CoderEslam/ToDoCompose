package com.example.to_docompose.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_docompose.R

@Composable
fun DisplayAlertDialog(
    title: String = "test",
    message: String = "test",
    openDialog: Boolean = true,
    closeDialog: () -> Unit,
    onYesClicked: () -> Unit,
) {
    if (openDialog) {
        AlertDialog(modifier = Modifier.fillMaxSize(),
            title = {
                Text(
                    text = title,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    text = message,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Normal
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        onYesClicked()
                        closeDialog()
                    })
                {
                    Text(text = stringResource(id = R.string.yes))
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { closeDialog() })
                {
                    Text(text = stringResource(id = R.string.no))
                }
            },
            onDismissRequest = { closeDialog() }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun show() {
    DisplayAlertDialog(closeDialog = {

    }, onYesClicked = {

    }
    )
}









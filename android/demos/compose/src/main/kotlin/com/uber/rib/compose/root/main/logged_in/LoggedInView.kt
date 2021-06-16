package com.uber.rib.compose.root.main.logged_in

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uber.rib.compose.ExperimentsLocal
import com.uber.rib.compose.UButton
import com.uber.rib.core.ComposableProvider

@Composable
fun LoggedInView(
  onLogoutClick: () -> Unit,
  productSelectionRouter: ComposableProvider?
) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top,
    modifier = Modifier
      .fillMaxSize()
      .background(Color.Green)
  ) {
    Text("Logged In! (compose w/ CompView, no pres)")
    Spacer(Modifier.height(16.dp))
    UButton(analyticsId = "8a570808-07a4", onClick = onLogoutClick) {
      Text("Log Out")
    }
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1.0f)
        .padding(4.dp)
        .background(Color.LightGray)) {
      productSelectionRouter?.let { it.composable() }
    }
  }
}

@Preview
@Composable
fun LoggedInViewPreview() {
  LoggedInView({}, null)
}

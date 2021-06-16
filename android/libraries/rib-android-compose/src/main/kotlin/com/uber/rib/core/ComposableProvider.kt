package com.uber.rib.core

import androidx.compose.runtime.Composable

interface ComposableProvider {
  val composable: @Composable () -> Unit
}
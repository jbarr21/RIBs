package com.uber.rib.core

import androidx.compose.runtime.Composable

abstract class BasicComposeInteractor<P : Any, R : Router<*>> protected constructor(
  presenter: P
) : BasicInteractor<P, R>(presenter) {

  var composable: @Composable () -> Unit = { }
}

package com.uber.rib.core

import androidx.compose.runtime.Composable

abstract class BasicComposeRouter<I : BasicComposeInteractor<*, *>>(
  interactor: I
) : BasicRouter<I>(interactor), ComposableProvider {

  override val composable: @Composable () -> Unit
    get() = interactor.composable
}

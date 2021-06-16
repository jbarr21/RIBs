package com.uber.rib.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.uber.rib.compose.client.AnalyticsClient
import com.uber.rib.compose.client.ExperimentClient
import com.uber.rib.compose.client.LoggerClient

val AnalyticsLocal = staticCompositionLocalOf<AnalyticsClient> { error("No Analytics client provided") }
val ExperimentsLocal = staticCompositionLocalOf<ExperimentClient> { error("No Experiment client provided") }
val LoggerLocal = staticCompositionLocalOf<LoggerClient> { error("No Logger client provided") }

@Composable
fun PresidioApp(
  analyticsClient: AnalyticsClient,
  experimentClient: ExperimentClient,
  loggerClient: LoggerClient,
  content: @Composable () -> Unit
) {
  CompositionLocalProvider(
    AnalyticsLocal provides analyticsClient,
    ExperimentsLocal provides experimentClient,
    LoggerLocal provides loggerClient,
    content = content
  )
}

package com.uber.rib.compose.root.main.logged_in

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import com.uber.rib.compose.root.main.logged_in.product_selection.ProductSelectionRouter
import com.uber.rib.core.BasicViewRouter

class LoggedInRouter(
  view: ComposeView,
  interactor: LoggedInInteractor,
  private val scope: LoggedInScope
) : BasicViewRouter<ComposeView, LoggedInInteractor>(view, interactor) {

  internal var productSelectionRouter: ProductSelectionRouter? by mutableStateOf(null)

  internal fun attachProductSelection() {
    if (productSelectionRouter == null) {
      productSelectionRouter = scope.productSelectionScope().router().also {
        attachChild(it)
      }
    }
  }

  internal fun detachProductSelection() {
    productSelectionRouter?.let {
      detachChild(it)
    }
    productSelectionRouter = null
  }

  override fun willDetach() {
    detachProductSelection()
    super.willDetach()
  }
}

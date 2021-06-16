package com.uber.rib.compose.root.main.logged_in

import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.savedstate.ViewTreeSavedStateRegistryOwner
import com.uber.rib.compose.root.main.logged_in.product_selection.ProductSelectionScope
import com.uber.rib.core.EmptyPresenter
import com.uber.rib.core.RibActivity

@motif.Scope
interface LoggedInScope {
  fun router(): LoggedInRouter

  fun productSelectionScope(): ProductSelectionScope

  @motif.Objects
  abstract class Objects {
    abstract fun router(): LoggedInRouter

    abstract fun interactor(): LoggedInInteractor

    abstract fun presenter(): EmptyPresenter

    fun view(parentViewGroup: ViewGroup, activity: RibActivity): ComposeView {
      return ComposeView(parentViewGroup.context).apply {
        ViewTreeLifecycleOwner.set(this, activity)
        ViewTreeSavedStateRegistryOwner.set(this, activity)
      }
    }
  }
}

package com.uber.rib.compose.root.main.logged_in.product_selection

import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.savedstate.ViewTreeSavedStateRegistryOwner
import com.uber.rib.core.EmptyPresenter
import com.uber.rib.core.RibActivity

@motif.Scope
interface ProductSelectionScope {
  fun router(): ProductSelectionRouter

  @motif.Objects
  abstract class Objects {
    abstract fun router(): ProductSelectionRouter

    abstract fun interactor(): ProductSelectionInteractor

    abstract fun presenter(): EmptyPresenter
  }
}

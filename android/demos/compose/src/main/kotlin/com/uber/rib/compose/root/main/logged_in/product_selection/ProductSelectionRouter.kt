package com.uber.rib.compose.root.main.logged_in.product_selection

import com.uber.rib.core.BasicComposeRouter

class ProductSelectionRouter(
  interactor: ProductSelectionInteractor
) : BasicComposeRouter<ProductSelectionInteractor>(interactor)

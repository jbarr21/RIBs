package com.uber.rib.compose.root.main.logged_in.product_selection

import androidx.compose.runtime.rxjava2.subscribeAsState
import com.jakewharton.rxrelay2.BehaviorRelay
import com.uber.autodispose.autoDispose
import com.uber.rib.core.BasicComposeInteractor
import com.uber.rib.core.Bundle
import com.uber.rib.core.EmptyPresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.schedulers.Schedulers.computation
import java.util.concurrent.TimeUnit

class ProductSelectionInteractor(
  presenter: EmptyPresenter
) : BasicComposeInteractor<EmptyPresenter, ProductSelectionRouter>(presenter) {

  private val viewModelStream = BehaviorRelay.createDefault(ProductSelectionViewModel())

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)
    composable = {
      ProductSelectionView(viewModelStream.subscribeAsState(initial = viewModelStream.value!!))
    }

    Observable.interval(1, TimeUnit.SECONDS)
      .startWith(0L)
      .subscribeOn(computation())
      .map { it.toInt() }
      .observeOn(mainThread())
      .autoDispose(this)
      .subscribe {
        val products = viewModelStream.value!!.products.toMutableList()
        if (it % 5 == 0) {
          products.clear()
        }
        products += "Product $it"
        viewModelStream.accept(viewModelStream.value!!.copy(products = products))
      }
  }
}

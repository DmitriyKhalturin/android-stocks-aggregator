package dmitriykhalturin.stocksaggregator.view.anko_component

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import dmitriykhalturin.stocksaggregator.view.activity.MainActivity
import dmitriykhalturin.stocksaggregator.view.currency_list.adapter.CurrenciesAdapter
import dmitriykhalturin.stocksaggregator.view.currency_list.adapter.CurrencyData
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 21:04.
 */
class MainAnkoComponent: AnkoComponent<MainActivity> {

  private lateinit var swipeRefreshLayout: SwipeRefreshLayout

  private var onRefreshListener: (() -> Unit)? = null

  private val currenciesAdapter = CurrenciesAdapter()

  override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
    constraintLayout {
      swipeRefreshLayout = swipeRefreshLayout {
        setOnRefreshListener {
          onRefreshListener?.invoke()
        }

        recyclerView {
          adapter = currenciesAdapter
          layoutManager = LinearLayoutManager(ui.owner)
          setHasFixedSize(true)
        }
      }.lparams(width = MATCH_PARENT, height = MATCH_PARENT)
    }
  }

  fun setItems(value: MutableList<CurrencyData>?) = value?.let {
    swipeRefreshLayout.isRefreshing = false
    currenciesAdapter.setItems(it)
  }

  fun setOnRefreshListener(action: () -> Unit) {
    onRefreshListener = action
  }

}

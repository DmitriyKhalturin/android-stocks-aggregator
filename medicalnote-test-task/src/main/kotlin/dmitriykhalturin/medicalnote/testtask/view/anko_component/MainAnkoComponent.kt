package dmitriykhalturin.medicalnote.testtask.view.anko_component

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import dmitriykhalturin.medicalnote.testtask.view.activity.MainActivity
import dmitriykhalturin.medicalnote.testtask.view.currency_list.CurrencyAdapter
import dmitriykhalturin.medicalnote.testtask.view.currency_list.CurrencyData
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

  private val currencyAdapter = CurrencyAdapter()

  override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
    constraintLayout {
      swipeRefreshLayout = swipeRefreshLayout {
        setOnRefreshListener {
          onRefreshListener?.run { this() }
        }

        recyclerView {
          adapter = currencyAdapter
          layoutManager = LinearLayoutManager(ui.owner)
          setHasFixedSize(true)
        }
      }.lparams(width = MATCH_PARENT, height = MATCH_PARENT)
    }
  }

  fun setItems(value: MutableList<CurrencyData>?) = value?.let {
    swipeRefreshLayout.isRefreshing = false
    currencyAdapter.setItems(it)
  }

  fun setOnRefreshListener(action: () -> Unit) {
    onRefreshListener = action
  }

}

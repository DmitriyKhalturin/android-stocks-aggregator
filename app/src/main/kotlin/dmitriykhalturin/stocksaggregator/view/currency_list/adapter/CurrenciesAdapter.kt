package dmitriykhalturin.stocksaggregator.view.currency_list.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import dmitriykhalturin.stocksaggregator.view.currency_list.CurrencyAnkoComponent
import org.jetbrains.anko.AnkoContext

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 23:34.
 */
class CurrenciesAdapter: RecyclerView.Adapter<CurrenciesAdapter.CurrencyViewHolder>() {

  private val items: MutableList<CurrencyData> = ArrayList()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
    val ankoComponent = CurrencyAnkoComponent()
    val ankoContext = AnkoContext.create(parent.context, parent)
    val view = ankoComponent.createView(ankoContext)

    return CurrencyViewHolder(ankoComponent, view)
  }

  override fun getItemCount() = items.size

  override fun onBindViewHolder(viewHolder: CurrencyViewHolder, position: Int) {
    viewHolder.setData(items[position])
  }

  fun setItems(value: MutableList<CurrencyData>) {
    items.clear()
    items.addAll(value)

    notifyDataSetChanged()
  }

  inner class CurrencyViewHolder(private val ankoComponent: CurrencyAnkoComponent, view: View): RecyclerView.ViewHolder(view) {

    fun setData(data: CurrencyData) = ankoComponent.setData(data)

  }

}

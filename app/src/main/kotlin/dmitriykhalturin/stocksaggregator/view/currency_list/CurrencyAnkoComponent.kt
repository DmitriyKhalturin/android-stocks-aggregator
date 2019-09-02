package dmitriykhalturin.stocksaggregator.view.currency_list

import android.graphics.Typeface
import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.support.constraint.ConstraintLayout.LayoutParams.VERTICAL
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import dmitriykhalturin.stocksaggregator.R
import dmitriykhalturin.stocksaggregator.view.currency_list.adapter.CurrencyData
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.constraint.layout.guideline

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 23:50.
 */
class CurrencyAnkoComponent: AnkoComponent<ViewGroup> {

  private lateinit var name: TextView
  private lateinit var volume: TextView
  private lateinit var amount: TextView

  override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
    constraintLayout {
      padding = dip(5)

      guideline {
        id = R.id.guideline
      }.lparams {
        width = WRAP_CONTENT
        height = WRAP_CONTENT
        orientation = VERTICAL
        guidePercent = 0.4f
      }

      name = textView {
        textSize = 16f
        setTypeface(typeface, Typeface.BOLD)
      }.lparams {
        width = MATCH_PARENT
        height = WRAP_CONTENT
        topToTop = PARENT_ID
        leftToLeft = PARENT_ID
      }

      textView("Volume:") {
        id = R.id.volume_label
      }.lparams {
        width = WRAP_CONTENT
        height = WRAP_CONTENT
        bottomToBottom = PARENT_ID
        leftToLeft = PARENT_ID
      }

      volume = textView {
        id = R.id.volume
        setTypeface(typeface, Typeface.ITALIC)
        leftPadding = dip(5)
      }.lparams {
        width = WRAP_CONTENT
        height = WRAP_CONTENT
        topToTop = R.id.volume_label
        startToEnd = R.id.volume_label
      }

      textView("Amount:") {
        id = R.id.amount_label
      }.lparams {
        width = WRAP_CONTENT
        height = WRAP_CONTENT
        topToTop = R.id.volume
        startToEnd = R.id.guideline
      }

      amount = textView {
        id = R.id.amount
        setTypeface(typeface, Typeface.ITALIC)
        leftPadding = dip(5)
      }.lparams {
        width = WRAP_CONTENT
        height = WRAP_CONTENT
        topToTop = R.id.amount_label
        startToEnd = R.id.amount_label
      }

      lparams(MATCH_PARENT, dip(50))
    }
  }

  fun setData(data: CurrencyData) {
    name.text = data.name
    volume.text = "%d".format(data.volume)
    amount.text = "%.2f".format(data.amount)
  }

}

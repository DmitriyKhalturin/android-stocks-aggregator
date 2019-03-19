package dmitriykhalturin.medicalnote.testtask.view.anko_component

import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import dmitriykhalturin.medicalnote.testtask.R
import dmitriykhalturin.medicalnote.testtask.view.activity.SplashActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.imageView

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 20:55.
 */
class SplashAnkoComponent: AnkoComponent<SplashActivity> {

  override fun createView(ui: AnkoContext<SplashActivity>) = with(ui) {
    constraintLayout {
      imageView(R.drawable.claudius_ii_coin)
        .lparams {
          width = dip(64)
          height = dip(64)
          topToTop = PARENT_ID
          bottomToBottom = PARENT_ID
          leftToLeft = PARENT_ID
          rightToRight = PARENT_ID
        }
    }
  }

}

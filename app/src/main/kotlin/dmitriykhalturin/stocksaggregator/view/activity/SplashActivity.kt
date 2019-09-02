package dmitriykhalturin.stocksaggregator.view.activity

import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dmitriykhalturin.stocksaggregator.view.anko_component.SplashAnkoComponent
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.setContentView
import java.util.*
import kotlin.concurrent.schedule

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 20:55.
 */
class SplashActivity: AppCompatActivity() {

  companion object {
    const val SCREEN_DELAY = 2500L
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    SplashAnkoComponent().setContentView(this)

    Timer().schedule(SCREEN_DELAY) {
      startActivity(
        intentFor<MainActivity>()
          .setFlags(FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK)
      )
    }
  }

}

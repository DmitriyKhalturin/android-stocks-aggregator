package dmitriykhalturin.medicalnote.testtask

import android.app.Application
import dmitriykhalturin.medicalnote.testtask.di.Injector

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 22:01.
 */
class MainApplication: Application() {

  companion object {
    @JvmStatic
    val injector
      get() = Injector.getInstance()
  }

  override fun onCreate() {
    super.onCreate()

    injector.buildAppComponent(this)
  }

}

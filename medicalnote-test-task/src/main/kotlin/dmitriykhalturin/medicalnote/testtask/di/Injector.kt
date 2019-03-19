package dmitriykhalturin.medicalnote.testtask.di

import android.app.Application
import android.support.v4.app.FragmentActivity
import dmitriykhalturin.medicalnote.testtask.di.component.AppComponent
import dmitriykhalturin.medicalnote.testtask.di.component.DaggerAppComponent
import dmitriykhalturin.medicalnote.testtask.di.component.DaggerPresenterComponent
import dmitriykhalturin.medicalnote.testtask.di.module.AppModule
import dmitriykhalturin.medicalnote.testtask.di.module.PresenterModule
import dmitriykhalturin.medicalnote.testtask.di.module.RepositoryModule

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 22:03.
 */
class Injector {
  companion object {
    @JvmStatic
    private val instance = Injector()

    @JvmStatic
    fun getInstance() = instance

    @JvmStatic
    private lateinit var appComponent: AppComponent
  }

  fun buildAppComponent(application: Application) {
    appComponent = DaggerAppComponent.builder()
      .appModule(AppModule(application))
      .repositoryModule(RepositoryModule())
      .build()
  }

  fun getAppComponent() = appComponent

  fun getPresenterComponent(activity: FragmentActivity) = DaggerPresenterComponent.builder()
    .presenterModule(PresenterModule(activity))
    .build()
}

package dmitriykhalturin.medicalnote.testtask.di.module

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import dagger.Module
import dagger.Provides
import dmitriykhalturin.medicalnote.testtask.di.PerPresenter
import dmitriykhalturin.medicalnote.testtask.presenter.MainPresenter

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 22:19.
 */
@Module
class PresenterModule(private val activity: FragmentActivity) {

  @PerPresenter
  @Provides
  fun provideMainPresenter() = ViewModelProviders.of(activity).get(MainPresenter::class.java)

}

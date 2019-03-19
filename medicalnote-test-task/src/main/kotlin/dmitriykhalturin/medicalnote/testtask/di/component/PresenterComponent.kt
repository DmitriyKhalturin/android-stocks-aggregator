package dmitriykhalturin.medicalnote.testtask.di.component

import dagger.Component
import dmitriykhalturin.medicalnote.testtask.di.PerPresenter
import dmitriykhalturin.medicalnote.testtask.di.module.PresenterModule
import dmitriykhalturin.medicalnote.testtask.view.activity.MainActivity

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 22:09.
 */
@PerPresenter
@Component(
  modules = [
    PresenterModule::class
  ]
)
interface PresenterComponent {
  fun inject(activity: MainActivity)
}

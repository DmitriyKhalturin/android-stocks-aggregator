package dmitriykhalturin.stocksaggregator.di.component

import dagger.Component
import dmitriykhalturin.stocksaggregator.di.module.AppModule
import dmitriykhalturin.stocksaggregator.di.module.RepositoryModule
import dmitriykhalturin.stocksaggregator.presenter.MainPresenter
import javax.inject.Singleton

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 22:09.
 */
@Singleton
@Component(
  modules = [
    AppModule::class,
    RepositoryModule::class
  ]
)
interface AppComponent {
  fun inject(presenter: MainPresenter)
}

package dmitriykhalturin.stocksaggregator.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 22:15.
 */
@Module
class AppModule(private val application: Application) {

  @Singleton
  @Provides
  fun provideContext(): Context = application

}

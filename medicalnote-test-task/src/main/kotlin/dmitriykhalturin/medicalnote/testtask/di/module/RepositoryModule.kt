package dmitriykhalturin.medicalnote.testtask.di.module

import dagger.Module
import dagger.Provides
import dmitriykhalturin.medicalnote.testtask.executor.JobExecutor
import dmitriykhalturin.medicalnote.testtask.executor.PostExecutionThread
import dmitriykhalturin.medicalnote.testtask.executor.ThreadExecutor
import dmitriykhalturin.medicalnote.testtask.executor.UIThread
import javax.inject.Singleton

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 22:18.
 */
@Module
class RepositoryModule {

  @Singleton
  @Provides
  fun provideThreadExecutor(executor: JobExecutor): ThreadExecutor = executor

  @Singleton
  @Provides
  fun providePostExecutionThread(thread: UIThread): PostExecutionThread = thread

}

package dmitriykhalturin.stocksaggregator.executor

import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 22:27.
 */
class JobExecutor @Inject constructor(): ThreadExecutor {

  companion object {
    private const val CORE_POOL_SIZE = 5
    private const val MAX_POOL_SIZE = 10
    private const val KEEP_ALIVE_TIME = 10L
  }

  private val threadPoolExecutor = ThreadPoolExecutor(
    CORE_POOL_SIZE,
    MAX_POOL_SIZE,
    KEEP_ALIVE_TIME,
    TimeUnit.SECONDS,
    LinkedBlockingDeque(),
    JobThreadFactory()
  )

  override fun execute(command: Runnable?) = threadPoolExecutor.execute(command)

  private class JobThreadFactory: ThreadFactory {

    companion object {
      private const val THREAD_NAME_PREFIX = "job_executor_"
    }

    private var counter = 0

    private val threadName
      get() = THREAD_NAME_PREFIX + counter++

    override fun newThread(runnable: Runnable?) = Thread(runnable, threadName)

  }

}

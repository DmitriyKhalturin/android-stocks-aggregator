package dmitriykhalturin.stocksaggregator.executor

import io.reactivex.Scheduler

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 22:25.
 */
interface PostExecutionThread {
  fun getScheduler(): Scheduler
}

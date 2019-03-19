package dmitriykhalturin.medicalnote.testtask.executor

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 22:24.
 */
class UIThread @Inject constructor(): PostExecutionThread {

  override fun getScheduler(): Scheduler = AndroidSchedulers.mainThread()

}

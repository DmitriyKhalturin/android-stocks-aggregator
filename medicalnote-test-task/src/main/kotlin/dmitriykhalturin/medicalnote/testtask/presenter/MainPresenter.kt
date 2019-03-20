package dmitriykhalturin.medicalnote.testtask.presenter

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import dmitriykhalturin.medicalnote.testtask.MainApplication
import dmitriykhalturin.medicalnote.testtask.api.ApiService
import dmitriykhalturin.medicalnote.testtask.executor.PostExecutionThread
import dmitriykhalturin.medicalnote.testtask.executor.ThreadExecutor
import dmitriykhalturin.medicalnote.testtask.view.currency_list.CurrencyData
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 21:57.
 */
class MainPresenter: ViewModel() {

  private val appComponent by lazy { MainApplication.injector.getAppComponent() }

  init {
    appComponent.inject(this)
  }

  private var disposable: Disposable? = null

  private val apiService by lazy { ApiService.create() }

  @Inject lateinit var threadExecutor: ThreadExecutor

  @Inject lateinit var postExecutionThread: PostExecutionThread

  val currencyLiveData = MutableLiveData<MutableList<CurrencyData>>()

  fun updateCurrenciesList() {
    disposable = apiService.getCurrenciesList()
      .subscribeOn(Schedulers.from(threadExecutor))
      .observeOn(postExecutionThread.getScheduler())
      .subscribe {
        currencyLiveData.value = ArrayList()
      }
  }

  override fun onCleared() {
    disposable?.dispose()

    super.onCleared()
  }

}

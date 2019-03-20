package dmitriykhalturin.medicalnote.testtask.presenter

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log.d
import dmitriykhalturin.medicalnote.testtask.MainApplication
import dmitriykhalturin.medicalnote.testtask.api.ApiService
import dmitriykhalturin.medicalnote.testtask.executor.PostExecutionThread
import dmitriykhalturin.medicalnote.testtask.executor.ThreadExecutor
import dmitriykhalturin.medicalnote.testtask.model.mapper.stocksResponseToCurrenciesList
import dmitriykhalturin.medicalnote.testtask.view.currency_list.CurrencyData
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.schedule

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 21:57.
 */
class MainPresenter: ViewModel() {

  private val appComponent by lazy { MainApplication.injector.getAppComponent() }

  private val apiService by lazy { ApiService.create() }

  @Inject lateinit var threadExecutor: ThreadExecutor

  @Inject lateinit var postExecutionThread: PostExecutionThread

  init {
    appComponent.inject(this)

    setRepeatingTask()
  }

  private var apiRequestDisposable: Disposable? = null
  private var requestRepeatingTask: TimerTask? = null

  val currenciesLiveData = MutableLiveData<MutableList<CurrencyData>>()

  private fun setRepeatingTask() {
    requestRepeatingTask = Timer().schedule(0, 15000) {
      updateCurrenciesList()
    }
  }

  fun updateCurrenciesList() {
    if (apiRequestDisposable == null) {
      apiRequestDisposable = apiService.getStocks()
        .map { stocksResponseToCurrenciesList(it) }
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.getScheduler())
        .subscribe({
          currenciesLiveData.value = it

          apiRequestDisposable = null
        }, {
          d("RESPONSE_ERROR", it.message)
        })
    }
  }

  override fun onCleared() {
    requestRepeatingTask?.cancel()
    apiRequestDisposable?.dispose()

    super.onCleared()
  }

}

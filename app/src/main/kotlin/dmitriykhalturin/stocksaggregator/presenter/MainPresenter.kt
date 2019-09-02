package dmitriykhalturin.stocksaggregator.presenter

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import dmitriykhalturin.stocksaggregator.MainApplication
import dmitriykhalturin.stocksaggregator.api.ApiService
import dmitriykhalturin.stocksaggregator.executor.PostExecutionThread
import dmitriykhalturin.stocksaggregator.executor.ThreadExecutor
import dmitriykhalturin.stocksaggregator.model.mapper.stocksResponseToCurrenciesList
import dmitriykhalturin.stocksaggregator.view.currency_list.adapter.CurrencyData
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

  companion object {
    const val FETCHING_DELAY = 0L
    const val FETCHING_TIMEOUT = 15000L
  }

  private val appComponent by lazy { MainApplication.injector.getAppComponent() }

  private val apiService by lazy { ApiService.create() }

  @Inject lateinit var threadExecutor: ThreadExecutor

  @Inject lateinit var postExecutionThread: PostExecutionThread

  init {
    appComponent.inject(this)
  }

  private var apiRequestDisposable: Disposable? = null
  private var fetchingTask: TimerTask? = null

  val currenciesLiveData = MutableLiveData<MutableList<CurrencyData>>()

  fun fetchingStocks() {
    fetchingTask = Timer().schedule(
      FETCHING_DELAY,
      FETCHING_TIMEOUT
    ) {
      getStocksList()
    }
  }

  fun interruptFetching() {
    fetchingTask?.cancel()
  }

  fun getStocksList() {
    if (apiRequestDisposable == null) {
      apiRequestDisposable = apiService.getStocks()
        .map(::stocksResponseToCurrenciesList)
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.getScheduler())
        .subscribe({
          currenciesLiveData.value = it

          apiRequestDisposable = null
        }, {
          // TODO: handle exception
        })
    }
  }

  override fun onCleared() {
    apiRequestDisposable?.dispose()

    super.onCleared()
  }

}

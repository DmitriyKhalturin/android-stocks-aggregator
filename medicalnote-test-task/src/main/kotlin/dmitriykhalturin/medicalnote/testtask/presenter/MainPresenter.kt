package dmitriykhalturin.medicalnote.testtask.presenter

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import dmitriykhalturin.medicalnote.testtask.MainApplication
import dmitriykhalturin.medicalnote.testtask.view.currency_list.CurrencyData

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 21:57.
 */
class MainPresenter: ViewModel() {

  private val appComponent by lazy { MainApplication.injector.getAppComponent() }

  init {
    appComponent.inject(this)
  }

  val currencyLiveData = MutableLiveData<MutableList<CurrencyData>>()

  fun updateCurrenciesList() {}

  override fun onCleared() {
    super.onCleared()
  }

}

package dmitriykhalturin.medicalnote.testtask.view.activity

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dmitriykhalturin.medicalnote.testtask.MainApplication
import dmitriykhalturin.medicalnote.testtask.presenter.MainPresenter
import dmitriykhalturin.medicalnote.testtask.view.anko_component.MainAnkoComponent
import org.jetbrains.anko.setContentView
import javax.inject.Inject

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 19.03.19 21:00.
 */
class MainActivity: AppCompatActivity() {

  private val mainAnkoComponent = MainAnkoComponent()

  private val presenterComponent by lazy { MainApplication.injector.getPresenterComponent(this) }

  @Inject lateinit var presenter: MainPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    title = ""

    mainAnkoComponent.setContentView(this)

    presenterComponent.inject(this)

    mainAnkoComponent.setOnRefreshListener { presenter.updateCurrenciesList() }

    presenter.currencyLiveData.observe(this, Observer { mainAnkoComponent.setItems(it) })

    presenter.updateCurrenciesList()
  }

}

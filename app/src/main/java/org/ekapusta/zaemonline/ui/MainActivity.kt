package org.ekapusta.zaemonline.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import org.ekapusta.zaemonline.ui.global.BaseFragment
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.ekapusta.zaemonline.R
import org.ekapusta.zaemonline.databinding.ActivityMainBinding
import org.ekapusta.zaemonline.system.analytics.Analytics
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CoroutineScope by CoroutineScope(Dispatchers.Main) {
    @Inject
    protected lateinit var navigatorHolder: NavigatorHolder

    private val currentFragment: BaseFragment<*>?
        get() = supportFragmentManager.findFragmentById(R.id.container) as? BaseFragment<*>

    private lateinit var binding: ActivityMainBinding

    private val navigator: Navigator =
        object : AppNavigator(this, R.id.container, supportFragmentManager) {
            override fun setupFragmentTransaction(
                fragmentTransaction: FragmentTransaction,
                currentFragment: Fragment?,
                nextFragment: Fragment?
            ) {
                // Fix incorrect order lifecycle callback of MainFragment
                fragmentTransaction.setReorderingAllowed(true)
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

}

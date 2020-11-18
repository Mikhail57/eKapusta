package org.ekapusta.zaemonline.ui.global

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

private typealias FragmentViewBindingInflater<VB> = (
    inflater: LayoutInflater,
    parent: ViewGroup?,
    attachToParent: Boolean
) -> VB

abstract class BaseFragment<VB : ViewBinding>(
    private val bindingInflater: FragmentViewBindingInflater<VB>
) : Fragment() {
    private var _binding: VB? = null

    protected val binding: VB
        get() = requireNotNull(_binding) { "Binding should be accessed within fragment lifecycle" }

    protected val analytics by lazy {  }


    private var instanceStateSaved: Boolean = false

    private val viewHandler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = bindingInflater
        .invoke(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onResume() {
        super.onResume()
        instanceStateSaved = false
    }

    // Fix for async views (like swipeToRefresh and RecyclerView)
    // If synchronously call actions on swipeToRefresh in sequence show and hide then swipeToRefresh will not hidden
    protected fun postViewAction(action: () -> Unit) {
        viewHandler.post(action)
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        viewHandler.removeCallbacksAndMessages(null)
        _binding = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        instanceStateSaved = true
    }


    // This is android, baby!
    private fun isRealRemoving(): Boolean =
        (isRemoving && !instanceStateSaved) || // Because isRemoving == true for fragment in backstack on screen rotation
                ((parentFragment as? BaseFragment<*>)?.isRealRemoving() ?: false)

    protected fun showProgressDialog(progress: Boolean) {
        if (!isAdded || instanceStateSaved) return

//        val fragment = childFragmentManager.findFragmentByTag(PROGRESS_TAG)
//        if (fragment != null && !progress) {
//            (fragment as ProgressDialog).dismissAllowingStateLoss()
//            childFragmentManager.executePendingTransactions()
//        } else if (fragment == null && progress) {
//            ProgressDialog().show(childFragmentManager, PROGRESS_TAG)
//            childFragmentManager.executePendingTransactions()
//        }
    }

    open fun onBackPressed() {}
}

private const val PROGRESS_TAG = "progress_tag"

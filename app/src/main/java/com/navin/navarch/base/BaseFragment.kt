package com.navin.navarch.base

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.navin.navarch.R
import com.navin.navarch.ui.view.LoadingDialog


abstract class BaseFragment<T : ViewBinding> : Fragment(){

    private var isLoading = false
    private var loadingDialog: LoadingDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)// Inflate the layout for this fragment
    }



    fun showMessage(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }


    protected open fun showLoadingDialog(show: Boolean) {
        isLoading = show
        if (show) {
            if (loadingDialog?.isShowing() == true)
                return

            loadingDialog = LoadingDialog.getInstance()
            loadingDialog?.show(this.childFragmentManager, null)

        } else {
            if (loadingDialog?.isShowing() == true)
                loadingDialog?.dismiss()
            loadingDialog = null
        }
    }

    protected open fun showLoadingDialogWithTimer(sec: Long) {
        showLoadingDialog(true)
        Handler(Looper.getMainLooper()).postDelayed({
            showLoadingDialog(false)
        }, sec)
    }

}
package com.navin.navarch.base

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.navin.navarch.ui.view.LoadingDialog


abstract class BaseActivity : AppCompatActivity() {

    private var fm: FragmentManager? = null
    private var dialog: Dialog? = null
    // private var progressBar: LoadingIndicator? = null

    private var isLoading = false
    private var loadingDialog: LoadingDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fm = supportFragmentManager
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    protected open fun showLoadingDialog(show: Boolean) {
        isLoading = show
        if (show) {
            if (loadingDialog?.isShowing() == true)
                return

            loadingDialog = LoadingDialog.getInstance()
            loadingDialog?.show(this.supportFragmentManager, null)

        } else {
            if (loadingDialog?.isShowing() == true)
                loadingDialog?.dismiss()
            loadingDialog = null
        }
    }

    protected open fun hideLoadingBar() {
    }

    public fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    public fun showError(msg: String) {
        val toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT)
        toast.show()
    }

}

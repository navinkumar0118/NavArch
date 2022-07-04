package com.cricketronics.sportsal.ui.view

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import android.widget.LinearLayout


 fun Dialog.setDefaultWindowTheme() {
    window?.apply {
        setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        statusBarColor = Color.TRANSPARENT
        setDimAmount(0.3f)
    }
}
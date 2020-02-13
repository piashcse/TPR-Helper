package com.example.tprhelper.kotlin.ui.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.example.tprhelper.kotlin.misc.AppExecutor
import com.example.tprhelper.kotlin.misc.ResponseMapper
import com.example.tprhelper.kotlin.misc.RxMapper

/**
 * Created by roman on 2020-01-02
 * Copyright (c) 2020 bjit. All rights reserved.
 * hawladar.roman@bjitgroup.com
 * Last modified $file.lastModified
 */
abstract class BaseViewModel<T>
protected constructor(
    application: Application,
    protected val rx: RxMapper,
    protected val ex: AppExecutor,
    protected val rm: ResponseMapper
) : AndroidViewModel(application), LifecycleOwner {

    private val lifecycleRegistry: LifecycleRegistry

    init {
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.setCurrentState(Lifecycle.State.INITIALIZED)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    override fun onCleared() {
        lifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED)
        super.onCleared()
    }
}
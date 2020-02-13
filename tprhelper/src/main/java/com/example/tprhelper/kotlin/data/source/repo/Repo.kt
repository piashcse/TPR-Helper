package com.example.tprhelper.kotlin.data.source.repo

import com.example.tprhelper.kotlin.data.model.Response
import com.example.tprhelper.kotlin.misc.ResponseMapper
import com.example.tprhelper.kotlin.misc.RxMapper
import io.reactivex.subjects.PublishSubject

/**
 * Created by roman on 2020-01-02
 * Copyright (c) 2020 bjit. All rights reserved.
 * hawladar.roman@bjitgroup.com
 * Last modified $file.lastModified
 */
abstract class Repo<K, T>(protected val rx: RxMapper, protected val rm: ResponseMapper) {

    protected val subject: PublishSubject<Response<T>>
    protected val subjects: PublishSubject<Response<List<T>>>

    init {
        subject = PublishSubject.create()
        subjects = PublishSubject.create()
    }
}
package com.example.tprhelper.kotlin.misc

import androidx.lifecycle.MutableLiveData
import io.reactivex.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by roman on 2020-01-01
 * Copyright (c) 2020 bjit. All rights reserved.
 * hawladar.roman@bjitgroup.com
 * Last modified $file.lastModified
 */
@Singleton
class RxMapper @Inject constructor(var facade: RxFacade) {

    fun <T> toLiveData(subject: AsyncSubject<T>, disposables: CompositeDisposable): MutableLiveData<T> {
        val data = MutableLiveData<T>()
        val disposable = subject.subscribe({ data.setValue(it) })
        disposables.add(disposable)
        return data
    }

    fun <T> toLiveData(subject: ReplaySubject<T>, disposables: CompositeDisposable): MutableLiveData<T> {
        val data = MutableLiveData<T>()
        val disposable = subject.subscribe({ data.setValue(it) })
        disposables.add(disposable)
        return data
    }

    fun <T> toLiveData(subject: PublishSubject<T>, disposables: CompositeDisposable): MutableLiveData<T> {
        val data = MutableLiveData<T>()
        val disposable = subject.subscribe({ data.setValue(it) })
        disposables.add(disposable)
        return data
    }


    fun backToMain(completable: Completable): Completable {
        return completable.subscribeOn(facade.io()).observeOn(facade.ui())
    }

    fun <T> backToMain(single: Single<T>): Single<T> {
        return single.subscribeOn(facade.io()).observeOn(facade.ui())
    }

    fun <T> backToMain(maybe: Maybe<T>): Maybe<T> {
        return maybe.subscribeOn(facade.io()).observeOn(facade.ui())
    }

    fun <T> backToBack(flowable: Flowable<T>): Flowable<T> {
        return flowable.subscribeOn(facade.io()).observeOn(facade.compute())
    }

    fun <T> backToMain(flowable: Flowable<T>): Flowable<T> {
        return flowable.subscribeOn(facade.io()).observeOn(facade.ui())
    }

    fun <T> backToMain(observable: Observable<T>): Observable<T> {
        return observable.subscribeOn(facade.io()).observeOn(facade.ui())
    }

    fun back(completable: Completable): Completable {
        return completable.subscribeOn(facade.io())
    }

    fun <T> back(single: Single<T>): Single<T> {
        return single.subscribeOn(facade.io())
    }

    fun <T> back(flowable: Flowable<T>): Flowable<T> {
        return flowable.subscribeOn(facade.io())
    }

    fun <T> back(observable: Observable<T>): Observable<T> {
        return observable.subscribeOn(facade.io())
    }

    fun <T> compute(completable: Completable): Completable {
        return completable.subscribeOn(facade.compute())
    }

    fun <T> compute(single: Single<T>): Single<T> {
        return single.subscribeOn(facade.compute())
    }

    fun <T> io(single: Single<T>): Single<T> {
        return single.subscribeOn(facade.io())
    }

    fun <T> compute(maybe: Maybe<T>): Maybe<T> {
        return maybe.subscribeOn(facade.compute())
    }

    fun <T> compute(flowable: Flowable<T>): Flowable<T> {
        return flowable.subscribeOn(facade.compute())
    }

    fun <T> io(flowable: Flowable<T>): Flowable<T> {
        return flowable.subscribeOn(facade.io())
    }

    fun io(): Scheduler {
        return facade.io()
    }

    fun compute(): Scheduler {
        return facade.compute()
    }

    fun ui(): Scheduler {
        return facade.ui()
    }
}

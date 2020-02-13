package com.example.tprhelper.kotlin.data.source.api

import io.reactivex.Maybe

/**
 * Created by roman on 2020-01-02
 * Copyright (c) 2020 bjit. All rights reserved.
 * hawladar.roman@bjitgroup.com
 * Last modified $file.lastModified
 */
interface DataSource<T> {

    fun isEmpty(): Boolean

    fun isEmptyRx(): Maybe<Boolean>

    fun getCount(): Int

    fun getCountRx(): Maybe<Int>

    fun isExists(t: T): Boolean

    fun isExistsRx(t: T): Maybe<Boolean>

    fun putItem(t: T): Long

    fun putItemRx(t: T): Maybe<Long>

    fun putItems(ts: List<T>): List<Long>?

    fun putItemsRx(ts: List<T>): Maybe<List<Long>>

    fun delete(t: T): Int

    fun deleteRx(t: T): Maybe<Int>

    fun delete(ts: List<T>): List<Long>?

    fun deleteRx(ts: List<T>): Maybe<List<Long>>

    fun getItem(id: String): T?

    fun getItemRx(id: String): Maybe<T>

    fun getItems(): List<T>?

    fun getItemsRx(): Maybe<List<T>>

    fun getItems(limit: Long): List<T>?

    fun getItemsRx(limit: Long): Maybe<List<T>>
}
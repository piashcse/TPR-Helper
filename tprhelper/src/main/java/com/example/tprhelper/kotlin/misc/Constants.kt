package com.example.tprhelper.kotlin.misc

import android.content.Context
import com.example.tprhelper.kotlin.util.AndroidUtil
import com.google.common.base.Splitter
import com.google.common.collect.Iterables
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by roman on 2020-01-01
 * Copyright (c) 2020 bjit. All rights reserved.
 * hawladar.roman@bjitgroup.com
 * Last modified $file.lastModified
 */
class Constants {

    companion object {
        fun database(name: String): String {
            return Iterables.getLast(Splitter.on(Sep.DOT).trimResults().split(name))
                .plus(Sep.DOT).plus(Database.POST_FIX_DB)
        }

        fun database(name: String, type: String): String {
            return Iterables.getLast(Splitter.on(Sep.DOT).trimResults().split(name))
                .plus(Sep.DOT).plus(type).plus(Sep.DOT).plus(Database.POST_FIX_DB)
        }

        fun lastAppId(context: Context): String = AndroidUtil.getLastApplicationId(context)!!
        fun more(context: Context): String = lastAppId(context) + Sep.HYPHEN + Tag.MORE
        fun about(context: Context): String = lastAppId(context) + Sep.HYPHEN + Tag.ABOUT
        fun settings(context: Context): String = lastAppId(context) + Sep.HYPHEN + Tag.SETTINGS
        fun license(context: Context): String = lastAppId(context) + Sep.HYPHEN + Tag.LICENSE
        fun launch(context: Context): String = lastAppId(context) + Sep.HYPHEN + Tag.LAUNCH
        fun navigation(context: Context): String = lastAppId(context) + Sep.HYPHEN + Tag.NAVIGATION
        fun tools(context: Context): String = lastAppId(context) + Sep.HYPHEN + Tag.TOOLS
        fun web(context: Context): String = lastAppId(context) + Sep.HYPHEN + Tag.WEB
    }

    object Event {
        const val ERROR = "error"
        const val APPLICATION = "application"
        const val ACTIVITY = "activity"
        const val FRAGMENT = "fragment"
        const val NOTIFICATION = "notification"
    }

    object Param {
        const val PACKAGE_NAME = "package_name"
        const val VERSION_CODE = "version_code"
        const val VERSION_NAME = "version_name"
        const val SCREEN = "screen"
        const val ERROR_MESSAGE = "error_message"
        const val ERROR_DETAILS = "error_details"
    }

    object Tag {
        const val MORE = "more"
        const val ABOUT = "about"
        const val SETTINGS = "settings"
        const val LICENSE = "license"
        const val LAUNCH = "launch"
        const val NAVIGATION = "navigation"
        const val TOOLS = "tools"
        const val WEB = "web"

        const val NOTIFY_SERVICE = "notify_service"
        const val MORE_APPS = "more_apps"
        const val RATE_US = "rate_us"
    }

    object Notify {
        const val DEFAULT_ID = 101
        const val FOREGROUND_ID = 102
        const val GENERAL_ID = 103
        const val DEFAULT_CHANNEL_ID = "default_channel_id"
        const val FOREGROUND_CHANNEL_ID = "foreground_channel_id"
    }

    object Ad {
        const val BANNER = "banner"
        const val INTERSTITIAL = "interstitial"
        const val REWARDED = "rewarded"
    }

    object Pref {
        const val DEFAULT = "default"
        const val CONFIG = "config"
        const val AD = "ad"

        const val VERSION_CODE = "version_code"
        const val SCREEN = "screen"

        const val RANK = "rank"
        const val LEVEL = "level"

        const val NIGHT_MODE = "night_mode"
    }

    object AdTime {
        const val BANNER = "time-banner"
        const val INTERSTITIAL = "time-interstitial"
        const val REWARDED = "time-rewarded"
    }

    object Sep {
        const val DOT = '.'
        const val COMMA = ','
        const val COMMA_SPACE = ", "
        const val SPACE = " "
        const val HYPHEN = '-'
        const val SEMI_COLON = ';'
        const val EQUAL = '='
        const val SPACE_HYPHEN_SPACE = " - "
        const val LEAF_SEPARATOR = '|'
        const val PLUS = '+'
    }

    object Database {
        const val TYPE_FRAME = "frame"
        const val TYPE_TRANSLATION = "translation"
        const val POST_FIX_DB = "db"
    }

    object Key {
        const val ID = "id"
        const val TIME = "time"
        const val TYPE = "type"
        const val SUBTYPE = "subtype"
        const val STATE = "state"
        const val LEVEL = "level"
    }

    object Action {
        const val START_SERVICE = "start_service"
        const val STOP_SERVICE = "stop_service"
    }

    object Task {
        const val TASK = "task"
    }

    object Retrofit {
        const val CONNECTION_CLOSE = "Connection:close"
    }

    object Session {
        val EXPIRED_TIME = TimeUnit.MINUTES.toMillis(5)
    }

    object Link {
        const val ID = Key.ID
        const val REF = "ref"
        const val URL = "url"
    }

    object Point {
        const val ID = Key.ID
        const val TYPE = Key.TYPE
        const val SUBTYPE = Key.SUBTYPE
        const val LEVEL = Key.LEVEL
    }

    object Country {
        const val ID = Key.ID
         val CODE_US = Locale.ENGLISH.country
    }

    object Parser {
        const val PATTERN_IMAGE_TAG = "img"
        const val BASE_URL = "baseUrl"
        const val HREF = "href"
        const val SOURCE = "src"
        const val ALTERNATE = "alt"
        const val WIDTH = "width"
        const val HEIGHT = "height"
    }

    object Default {
        val NULL = null
        const val BOOLEAN = false
        const val CHARACTER = 0.toChar()
        const val INT = 0
        const val LONG = 0L
        const val FLOAT = 0f
        const val DOUBLE = 0.0
        const val STRING = ""
        val LIST = Collections.emptyList<Any>()
    }

    object Network {
        const val HTTP = "http:"
        const val HTTPS = "https:"
    }

    object Pattern {
        const val PATTERN_IMAGE = "img[src~=(?i)\\\\.(png|jpe?g|gif)]"
        const val PATTERN_IMAGE_URL =
            "^https?://(?:[a-z0-9\\-]+\\.)+[a-z0-9]{2,6}(?:/[^/#?]+)+\\.(?:jpg|gif|png)\$"
        val IMAGE_PATTERN = java.util.regex.Pattern.compile(PATTERN_IMAGE_URL)
    }

    object ResponseCode {
        const val NOT_FOUND = 404
    }

    object Count {
        const val THREAD_NETWORK = 5
    }

    object Delimiter {
        const val COMMA = ","
    }

    object Api {
        const val BASE_URL = "https://google.com/"
    }


}
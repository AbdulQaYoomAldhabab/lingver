/*
 * The MIT License (MIT)
 *
 * Copyright 2019 Yaroslav Berezanskyi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.yariksoffice.lingver.store

import android.content.Context
import android.content.SharedPreferences
import java.util.Locale

/**
 * Default implementation of [LocaleStore] using [SharedPreferences].
 *
 * <p>The default language value is a two or three-letter language code as defined in ISO639.
 * See the [Locale] class description for more information
 * about valid language values.
 */
class PreferenceLocaleStore(context: Context, private val defaultLanguage: String) : LocaleStore {

    private val prefs = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    override fun getLocal(): String {
        return prefs.getString(LANGUAGE_KEY, defaultLanguage) ?: defaultLanguage
    }

    override fun persistLocale(language: String) {
        prefs.edit().putString(LANGUAGE_KEY, language).apply()
    }

    companion object {
        private const val LANGUAGE_KEY = "language_key"
        private const val PREFERENCE_NAME = "lingver_preference"
    }
}

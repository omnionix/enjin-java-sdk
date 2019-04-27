/*
 * Copyright (C) 2016 Francisco José Montiel Navarro.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.enjincoin.sdk.http;

import okhttp3.Cookie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class decorates a Cookie to reimplement equals() and hashcode() methods in order to identify
 * the cookie by the following attributes: name, domain, path, secure & hostOnly.
 *
 * <p>This new behaviour will be useful in determining when an already existing cookie in session must be overwritten.
 *
 * @author Evan Lindsay
 * @see Cookie
 */
class IdentifiableCookie {

    private Cookie cookie;

    /**
     * Takes a list of {@link Cookie} and wraps them with {@link IdentifiableCookie}.
     *
     * @param cookies the cookies to wrap.
     * @return the wrapped cookies.
     */
    public static List<IdentifiableCookie> decorateAll(Collection<Cookie> cookies) {
        List<IdentifiableCookie> identifiableCookies = new ArrayList<>(cookies.size());
        for (Cookie cookie : cookies) {
            identifiableCookies.add(decorate(cookie));
        }
        return identifiableCookies;
    }

    /**
     * Wraps a {@link Cookie} with {@link IdentifiableCookie}.
     *
     * @param cookie the cookie to wrap.
     * @return the wrapped cookie.
     */
    public static IdentifiableCookie decorate(Cookie cookie) {
        return new IdentifiableCookie(cookie);
    }

    private IdentifiableCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    protected Cookie getCookie() {
        return cookie;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof IdentifiableCookie)) return false;
        IdentifiableCookie that = (IdentifiableCookie) other;
        return that.cookie.name().equals(this.cookie.name())
                && that.cookie.domain().equals(this.cookie.domain())
                && that.cookie.path().equals(this.cookie.path())
                && that.cookie.secure() == this.cookie.secure()
                && that.cookie.hostOnly() == this.cookie.hostOnly();
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + cookie.name().hashCode();
        hash = 31 * hash + cookie.domain().hashCode();
        hash = 31 * hash + cookie.path().hashCode();
        hash = 31 * hash + (cookie.secure() ? 0 : 1);
        hash = 31 * hash + (cookie.hostOnly() ? 0 : 1);
        return hash;
    }
}

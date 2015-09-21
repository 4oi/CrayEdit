/* 
 * The MIT License
 *
 * Copyright 2015 Toyblocks.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jp.llv.ce;

import java.util.function.Consumer;
import java.util.logging.Logger;
import jp.llv.ce.server.EditServer;

/**
 *
 *
 * @author Toyblocks
 */
public interface UnfixedAPI {

    static final String API_VERSION = "1.0";

    default String getAPIVersion() {
        return API_VERSION;
    }

    String getVersion();

    EditServer getServer();

    EditRegistry getRegistry();

    <E> void addListener(Object registrant, Class<? extends E> event, Consumer<E> listener);
    
    void callEvent(Object event);
    
    Logger getLogger();

    void debug(String message);

    void debug(String message, Throwable ex);

    static class Container {

        private static UnfixedAPI api;

        protected static void init(UnfixedAPI implementation) {
            if (api != null) {
                throw new IllegalStateException("API is already ready");
            }
            api = implementation;
        }

        public static UnfixedAPI getAPI() {
            if (api == null) {
                throw new IllegalStateException("API is not ready");
            }
            return api;
        }
    }

}

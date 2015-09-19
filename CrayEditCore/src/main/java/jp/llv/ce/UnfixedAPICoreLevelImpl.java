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

import java.util.logging.Level;
import jp.llv.ce.EditRegistry;
import jp.llv.ce.UnfixedAPI;

/**
 * API実装
 * @author Toyblocks
 */
public abstract class UnfixedAPICoreLevelImpl implements UnfixedAPI {

    private static final String VERSION = "1.0.0";
    
    private boolean debug = false;
    private final EditRegistry registry;
    
    /*package*/ UnfixedAPICoreLevelImpl() {
        this.registry = new EditRegistryImpl();
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    @Override
    public EditRegistry getRegistry() {
        return this.registry;
    }

    @Override
    public void debug(String message) {
        if (debug) {
            this.getLogger().log(Level.INFO, message);
        }
    }
    
    @Override
    public void debug(String message, Throwable ex) {
        if (debug) {
            this.getLogger().log(Level.INFO, message, ex);
        }
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

}

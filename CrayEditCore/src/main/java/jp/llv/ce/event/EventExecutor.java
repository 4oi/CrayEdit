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
package jp.llv.ce.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import jp.llv.ce.CrayAPI;

/**
 *
 * @author Toyblocks
 */
public class EventExecutor {

    private final Map<Class<?>, List<RegisteredListener>> listeners
            = Collections.synchronizedMap(new HashMap<>());

    public <E> void register(Object registrar, Class<? extends E> event, Consumer<E> listener) {
        synchronized (this) {
            List<RegisteredListener> l = this.listeners.get(event);
            if (l == null) {
                l = Collections.synchronizedList(new ArrayList<>());
                this.listeners.put(event, l);
            }
            l.add(new RegisteredListener(registrar, listener));
        }
    }

    public void unregisterAll(Object registrar) {
        synchronized (this) {
            for (Iterator<Map.Entry<Class<?>, List<RegisteredListener>>> it0 = this.listeners.entrySet().iterator(); it0.hasNext();) {
                Map.Entry<Class<?>, List<RegisteredListener>> e = it0.next();
                for (Iterator<RegisteredListener> it1 = e.getValue().iterator(); it1.hasNext();) {
                    RegisteredListener r = it1.next();
                    if (r.registrar == registrar) {
                        it1.remove();
                    }
                }
                if (e.getValue().isEmpty()) {
                    it0.remove();
                }
            }
        }
    }

    public <E> void callEvent(E event) {
        List<RegisteredListener> toExe = this.listeners.get(event.getClass());
        toExe.parallelStream().forEach(c -> {
            try {
                c.consumer.<E>accept(event);
            } catch (Throwable ex) {
                int id = System.identityHashCode(c.consumer);
                String o = c.registrar.toString();
                CrayAPI.Container.getAPI().debug("An error has ocurred by a listener#" + id + " handling " + event.getClass().getSimpleName() + " by " + o, ex);
            }
        });
    }

    private static final class RegisteredListener<E> {

        final Object registrar;
        final Consumer<E> consumer;

        RegisteredListener(Object registrar, Consumer<E> consumer) {
            this.registrar = registrar;
            this.consumer = consumer;
        }

    }

}

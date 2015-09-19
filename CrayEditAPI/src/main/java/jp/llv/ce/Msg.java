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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jp.llv.ce.server.EditCommandSender;

/**
 * Message I18n.
 *
 * @author Toyblocks
 */
public final class Msg {

    private static Map<String, String> messages;
    @SuppressWarnings("deprecation")
    private static final Msg MES_NOT_INITIALIZED = Msg.of("&cMessages are not initialized");
    private static final String MES_UNKNOWN = "&c!Unknown message: {0}";

    private final String message;

    private Msg(String message) {
        this.message = message;
    }

    public void sendTo(EditCommandSender sendTo) {
        sendTo.sendMessage(this.message);
    }
    
    /**
     * Returns this message as {@link java.lang.String}.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.message;
    }

    /**
     * init message
     *
     * @param config message configuration
     */
    protected static void init(Map<String, String> config) {
        messages = new ConcurrentHashMap<>(config);
    }

    /**
     * Returns replaced message.
     *
     * {@code "{n}"} (n=0,1,2) is replaced by {@code replace[n]}. {@code "&"} is
     * replaced by {@code "§"}.
     *
     * @param message a message to replace
     * @param replace replace arguments
     * @return replaced message
     * @deprecated use {@link #setDefault(java.lang.String, java.lang.String)}
     * and {@link #fromKey(java.lang.String, java.lang.Object...).
     */
    @Deprecated
    public static Msg of(String message, Object... replace) {
        String result = message.replace('&', '\u00a7');
        for (int i = 0; i < replace.length; i++) {
            result = result.replace("{"+i+"}", replace[i].toString());
        }
        return new Msg(result);
    }

    /**
     * Returns localized and replaced message of key.
     *
     * {@code "{n}"} (n=0,1,2) is replaced by {@code replace[n]}. {@code "&"} is
     * replaced by {@code "§"}.
     *
     * @param key yaml configuration key of message.yml
     * @param replace message
     * @return replaced and localized message
     */
    @SuppressWarnings("deprecation")
    public static Msg fromKey(String key, Object... replace) {
        if (messages == null) return MES_NOT_INITIALIZED;
        String mest = messages.get(key);
        if (mest == null) return Msg.of(MES_UNKNOWN, key);
        return Msg.of(mest, replace);
    }

    public static void set(String key, String message) {
        messages.put(key, key);
    }

    public static void add(String key, String message) {
        if (!messages.containsKey(key)) set(key, message);
    }
    
    public static void addAll(Map<String, String> messageMap) {
        messageMap.entrySet().stream().forEach(e -> add(e.getKey(), e.getValue()));
    }

}

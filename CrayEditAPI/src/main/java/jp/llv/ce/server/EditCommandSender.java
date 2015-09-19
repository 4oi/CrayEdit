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
package jp.llv.ce.server;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.chat.ComponentSerializer;

/**
 *
 * @author Toyblocks
 */
public interface EditCommandSender {

    enum Type {

        PLAYER, CONSOLE, COMMAND_BLOCK, COMMAND_MINECART, OTHER,
        
    }

    boolean hasPermission(String permission);
    
    void sendMessage(ChatMessageType type, BaseComponent ... message);
    
    default void sendMessage(BaseComponent ... message) {
        this.sendMessage(ChatMessageType.CHAT, message);
    }
    
    default void sendMessage(String message) {
        this.sendMessage(TextComponent.fromLegacyText(message));
    }
    
    default void sendJsonMessage(ChatMessageType type, String json) {
        this.sendMessage(type, ComponentSerializer.parse(json));
    }
    
    default void sendJsonMessage(String json) {
        this.sendJsonMessage(ChatMessageType.CHAT, json);
    }
    
    Type getType();
    
    EditWorld getWorld();

}

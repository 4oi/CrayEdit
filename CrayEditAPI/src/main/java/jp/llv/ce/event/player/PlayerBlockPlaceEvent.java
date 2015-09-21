/*
 * The MIT License
 *
 * Copyright 2015 toyblocks.
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
package jp.llv.ce.event.player;

import jp.llv.ce.event.Cancellable;
import jp.llv.ce.event.EditEvent;
import jp.llv.ce.server.EditBlock;
import jp.llv.ce.server.EditPlayer;

/**
 *
 * @author toyblocks
 */
@EditEvent
public class PlayerBlockPlaceEvent extends PlayerBlockEvent implements Cancellable {

    private boolean cancel;
    
    public PlayerBlockPlaceEvent(EditPlayer player, EditBlock block) {
        super(player, block);
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public boolean isCancelled() {
        return this.cancel;
    }
    
}

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

import java.util.Collection;
import java.util.UUID;

/**
 *
 * @author Toyblocks
 */
public interface EditServer {
    
    EditWorld getWorld(String name);
    
    EditWorld getWorld(UUID uuid);
    
    Collection<? extends EditWorld> getWorlds();
    
    @Deprecated
    EditPlayer getPlayer(String id);
    
    EditPlayer getPlayer(UUID uuid);
    
    Collection<? extends EditPlayer> getPlayers();
    
    EditCommandSender getConsole();
    
    EditMaterial getMaterial(String id);
    
    EditMaterialData getMaterialData(EditMaterial material, short meta);
    
    default EditMaterialData getMaterialData(String id, short meta) {
        return this.getMaterialData(this.getMaterial(id), meta);
    }
    
    String getAPIVersion();
    
    String getVersion();
    
}

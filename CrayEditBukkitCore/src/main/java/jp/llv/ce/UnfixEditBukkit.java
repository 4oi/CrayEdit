/*
 * Copyright (C) 2015 Toyblocks
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jp.llv.ce;

import jp.llv.ce.Msg;
import jp.llv.ce.UnfixedAPI;
import jp.llv.ce.UnfixedBukkitAPI;
import jp.llv.ce.listener.CommandListener;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Toyblocks
 */
public class UnfixEditBukkit extends JavaPlugin {

    private UnfixedAPIBukkitImpl api;
    
    @Override
    public void onEnable() {
        //init messages
        Msg.init(null);
        
        //init api
        this.api = new UnfixedAPIBukkitImpl(this);
        UnfixedAPI.Container.init(api);
        this.getServer().getServicesManager().register(UnfixedBukkitAPI.class, api, this, ServicePriority.Highest);
        
        //init listeners
        this.getServer().getPluginManager().registerEvents(new CommandListener(this, this.api.getRegistry().getCommand()), this);
    }

}

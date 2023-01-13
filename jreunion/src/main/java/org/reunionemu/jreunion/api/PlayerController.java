package org.reunionemu.jreunion.api;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.reunionemu.jreunion.game.Player;
import org.reunionemu.jreunion.server.LocalMap;
import org.reunionemu.jreunion.server.Map;
import org.reunionemu.jreunion.server.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/players")
public class PlayerController {
	@Autowired
	Server server;
	
	//@Cacheable(value="default")
	@RequestMapping(value="{mapId}", method = RequestMethod.GET)
	public @ResponseBody List<Object> getCount(@PathVariable int mapId) {
		Map map = server.getWorld().getMap(mapId);
		if(map instanceof LocalMap){
			List<Object> playersResponse = new LinkedList<Object>();
			List<Player> players = ((LocalMap) map).getPlayerList();

			for(final Player player: players){
				playersResponse.add(buildResponse(player));
			}
			return playersResponse;
		}
		throw new RuntimeException("");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Object> getCountTotal() {
		Collection<Map> maps = server.getWorld().getMaps();
		Iterator<Map> iter = maps.iterator();		
		List<Object> playersResponse = new LinkedList<Object>();
		while(iter.hasNext()){
			Map map = iter.next();
			if(map instanceof LocalMap){
				List<Player> players = ((LocalMap) map).getPlayerList();
				for(final Player player: players){
					playersResponse.add(buildResponse(player));
				}
			}
		}
		return playersResponse;
	}
	
	public Object buildResponse(final Player player) {
		return new Object() {
			public final String name = player.getName();
			public final int level = player.getLevel();
			public final Object position = new Object() {
				public final int x = player.getPosition().getX();
				public final int y = player.getPosition().getY();
				public final int z = player.getPosition().getZ();
				public final int map = player.getPosition().getMap().getId();
			};
		};
	}
}

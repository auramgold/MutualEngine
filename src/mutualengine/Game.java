/*
 * Copyright (C) 2019 auramgold
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
package mutualengine;

import java.util.List;
import mutualengine.commands.actions.CommandRunner;
import mutualengine.implementations.ImplPlayer;
import mutualengine.implementations.ImplWindow;
import mutualengine.interfaces.Command;
import mutualengine.interfaces.Player;
import mutualengine.interfaces.Window;
import mutualengine.interfaces.World;
import mutualengine.testworld.TestWorld;

/**
 *
 * @author auramgold
 */
public class Game
{
	private boolean finishedInitialization;
	private Player gamePlayer;
	private Window displayWindow;
	private World currentWorld;
	private CommandRunner commandRunner;
	
	/* Initialization methods */
	
	public void initializeDefaults()
	{
		if(finishedInitialization)
		{
			throw new IllegalAccessError("Initialization has already been completed.");
		}
		
		initializeWindow(new ImplWindow("Mutual Engine","Welcome to the mutual engine."));
		initializeWorld(new TestWorld());
		initializePlayer(new ImplPlayer("Jane Doe"));
		initializeCommandRunner(true);
		finishInitialization();
	}
	
	public void initializeWindow(Window window)
	{
		if(finishedInitialization)
		{
			throw new IllegalAccessError("Initialization has already been completed.");
		}
		
		displayWindow = window;
	}
	
	public void initializeWorld(World world)
	{
		if(finishedInitialization)
		{
			throw new IllegalAccessError("Initialization has already been completed.");
		}
		
		currentWorld = world;
	}
	
	public void initializePlayer(Player player)
	{
		if(finishedInitialization)
		{
			throw new IllegalAccessError("Initialization has already been completed.");
		}
		
		gamePlayer = player;
	}
	
	public void initializeCommandRunner(boolean includeDefaults)
	{
		if(finishedInitialization)
		{
			throw new IllegalAccessError("Initialization has already been completed.");
		}
		
		commandRunner = new CommandRunner(includeDefaults);
	}
	
	public void registerCommand(Command cmd)
	{
		commandRunner.registerCommand(cmd);
	}
	
	public void finishInitialization()
	{
		gamePlayer.moveToWorld(currentWorld);
		displayWindow.display();
		finishedInitialization = true;
	}
	
	public boolean getInitializationStatus()
	{
		return finishedInitialization;
	}
	
	
	/* Post-initialization methods */
	
	public World getWorld()
	{
		return currentWorld;
	}
	
	public boolean runCommand(List<String> inputList)
	{
		return commandRunner.runCommand(inputList, gamePlayer);
	}

	void addToLog(String string)
	{
		displayWindow.addToLog(string);
	}
	
}

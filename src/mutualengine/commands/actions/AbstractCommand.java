/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualengine.commands.actions;

import java.util.Arrays;
import java.util.List;
import mutualengine.interfaces.Command;

/**
 *
 * @author auramgold
 */
public abstract class AbstractCommand implements Command
{
	protected List<String> aliases;
	
	public AbstractCommand(String... aliasList)
	{
		aliases = Arrays.asList(aliasList);
	}
	
	@Override
	public boolean hasAlias(String str)
	{
		return aliases.contains(str);
	}
}

/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package l2tserver.gameserver.stats.effects;

import l2tserver.gameserver.model.L2Effect;
import l2tserver.gameserver.model.actor.instance.L2PcInstance;
import l2tserver.gameserver.model.actor.instance.L2SummonInstance;
import l2tserver.gameserver.stats.Env;
import l2tserver.gameserver.templates.skills.L2EffectTemplate;

public class EffectUnSummon extends L2Effect
{
	public EffectUnSummon(Env env, L2EffectTemplate template)
	{
		super(env, template);
	}
	
	/**
	 * 
	 * @see l2tserver.gameserver.model.L2Abnormal#onStart()
	 */
	@Override
	public boolean onStart()
	{
		if (getEffected() == null)
			return false;
		
		if (!(getEffected() instanceof L2SummonInstance))
			return false;
		
		L2SummonInstance summon = (L2SummonInstance) getEffected();
		
		if (summon == null)
			return false;
		
		if (summon.isDead())
			summon.decayMe();
		else
			summon.unSummon((L2PcInstance) getEffector());
		
		return true;
	}
	
	/**
	 * 
	 * @see l2tserver.gameserver.model.L2Abnormal#onActionTime()
	 */
	@Override
	public boolean onActionTime()
	{
		return false;
	}
}
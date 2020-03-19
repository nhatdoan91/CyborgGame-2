package com.mycompany.a2;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public class NonPlayerCyborg extends Cyborg{

	private Random random = new Random();
	private IStrategy currentStrategy;
	public NonPlayerCyborg() {
		this.setSteeringDirection(random.nextInt(40));
		this.setHeading(random.nextInt(360));
		this.setSpeed(25+random.nextInt(20));
		this.setMaximumSpeed(45);
		this.setEnergyConsumptionRate(0);;
		this.setDamageLevel(0);
		this.setEnergyLevel(100);;
		this.setLastBaseReached(1);;
		this.setColor(ColorUtil.YELLOW);
		this.setSize(20);
		this.setRandomLocation();
		if(random.nextInt(2)==0)
		{
			currentStrategy= new ReachToLastBaseStrategy(this);
		}else
		{
			currentStrategy = new AttackPlayerCyborgStrategy(this);
		}
	}
	
	public void collideWithPlayerCyborg()
	 {
		this.setDamageLevel(this.getDamageLevel()+2);
		this.setColor(ColorUtil.rgb(0, 0, (this.getDamageLevel()*250)/10));
	 }
	public void setStrategy(char a) {
		if(a=='a')
		{
			currentStrategy=new AttackPlayerCyborgStrategy(this);
		}else if(a =='b')
		{
			currentStrategy=new ReachToLastBaseStrategy(this);
		}
	}
	public void invokeStratergy() {
		currentStrategy.apply();
	}
	@Override 
	public String toString() {	
		String strategy = null;
		if(currentStrategy instanceof ReachToLastBaseStrategy)
		{
			strategy = "Reach To Last Base ,";
		}else if(currentStrategy instanceof AttackPlayerCyborgStrategy){
			strategy = "Attack Player Cyborg ,";
		}
		return ("NPC Cyborg: Straegy "+strategy+super.toString());
	}
}

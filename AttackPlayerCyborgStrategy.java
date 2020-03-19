package com.mycompany.a2;
import com.codename1.util.MathUtil;
public class AttackPlayerCyborgStrategy implements IStrategy {
	private GameWorld gw = new GameWorld();
	private NonPlayerCyborg npc;
	private Point playerLocation;
	float x,y;
	public AttackPlayerCyborgStrategy(NonPlayerCyborg npc) {
		this.npc=npc;
	}
	
	public void apply() {
		playerLocation = gw.findPlayerCyborg().getLocation();
		x=npc.getX()-playerLocation.getX();
		y=npc.getY()-playerLocation.getY();
		int angle = (int)Math.toDegrees( MathUtil.atan2(y, x));
		if(x>0)
		{
			if(y>0) {
				angle=180+angle;
			}else if(y<0){
				angle=360-angle;
			}else {
				angle = 270;
			}
		}else if(x<0){
			if(y>0) {
				angle=180-angle;
			}else if(y<0){
				
			}else {
				angle = 270;
			}
		}else {
			if(y>0) {
				angle=180;
			}else if(y<0){
				angle=0;
			}else {
			// right at player x=0, y= 0;
			}
		}
		// change heading of NPC
		int condition1 = npc.getHeading()-90;
		int condition2 = npc.getHeading()-90;
		if(condition1 < 0 )
		{
			condition1=360+condition1;
		}if(condition2 < 0 )
		{
			condition2=360+condition2;
		}
		if((Math.abs(condition1-angle))>(Math.abs(condition2-angle)))
		{
			if(Math.abs(npc.getHeading()-angle )<40)
			{	
				npc.setHeading(npc.getHeading()-Math.abs(npc.getHeading()-angle ));
			}else {
				npc.setHeading(npc.getHeading()-40);
			}
		}else {
			if(Math.abs(npc.getHeading()-angle )<40)
			{	
				npc.setHeading(npc.getHeading()+Math.abs(npc.getHeading()-angle ));
			}else {
				npc.setHeading(npc.getHeading()+40);
			}
		}
	}
}

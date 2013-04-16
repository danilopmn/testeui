package com.example.android.opengl;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.contacts.Contact;

public abstract class Player extends Entity{
	int cont;	
	private int contacts;
	public Player(float x, float y) {
		super(x, y);
		cont = 0;
		contacts = 0;
	}
	
	protected Vec2 getForcePoint(){
		return body.getWorldCenter();
	}
	
	public void jump() {
		System.out.println("----  " + contacts);
		if( cont > 0 || contacts <= 0) return;
		float impulseX = (12) * body.getMass();
		Vec2 direction = new Vec2((float)Math.cos(body.getAngle() + Math.PI/2),(float)Math.sin(body.getAngle()+ Math.PI/2));
		direction.normalize();
		direction.mulLocal(impulseX);
		body.applyLinearImpulse(direction, body.getWorldCenter());
		cont = 15;
	}

	public void run() {
		body.applyLinearImpulse(new Vec2((10 - body.m_linearVelocity.x) * body.getMass(), 0.0f), getForcePoint());
	}
	
	public void back() {
		body.applyLinearImpulse(new Vec2((-10 - body.m_linearVelocity.x) * body.getMass(), 0.0f), getForcePoint());
	}
	
	public void step(){
		if(cont > 0 ) cont--;
	}
	
	public void beginContact(Entity e, Contact contact) {
		contacts++;

		System.out.println("encostou " + contacts);
	}

	public void endContact(Entity e , Contact contact) {
		contacts--;

		System.out.println("DESencostou " + contacts);
	}
}

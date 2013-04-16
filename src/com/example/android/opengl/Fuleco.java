package com.example.android.opengl;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.joints.LineJoint;
import org.jbox2d.dynamics.joints.LineJointDef;
import org.jbox2d.dynamics.joints.PrismaticJoint;
import org.jbox2d.dynamics.joints.PrismaticJointDef;
import org.jbox2d.dynamics.joints.RevoluteJoint;
import org.jbox2d.dynamics.joints.RevoluteJointDef;


public class Fuleco extends Player{
	PrismaticJoint joint;
	int cont;
	public Fuleco() {
		super(-20.0f, 45.0f);
		cont = 0;
	
		body.setType(BodyType.DYNAMIC);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(2.0f, 0.1f);
		Fixture a = body.createFixture(shape, 200.0f);
		a.setFriction(0.0f);
		PolygonShape shape2 = new PolygonShape();
		shape2.setAsBox(2.0f, 1.8f, new Vec2(0.0f,2.0f),0.0f);
		Fixture b = body.createFixture(shape2, 0.0f);
		b.setFriction(0.5f);
		
		BodyDef bd = new BodyDef();
		bd.type = BodyType.DYNAMIC;
		bd.position = body.getPosition();
		Body body2 = world.createBody(bd);
		body.setFixedRotation(true);
		PolygonShape shape3 = new PolygonShape();
		shape3.setAsBox(1.8f, 0.1f);
		body2.createFixture(shape3,1.0f).setFriction(0.0f);
		
		PrismaticJointDef ljd = new PrismaticJointDef();
		ljd.bodyA = body2;
		ljd.bodyB = body;
		ljd.localAxis1.set(0,1);
		ljd.localAxis1.normalize();
		ljd.collideConnected = false;
		ljd.enableLimit = true;
		ljd.lowerTranslation = 0;
		ljd.upperTranslation = 2;
		joint = (PrismaticJoint) world.createJoint(ljd);
		
		/*
		body.setType(BodyType.DYNAMIC);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(2.0f, 2.0f);
		Fixture a = body.createFixture(shape, 30.0f);
		a.setFriction(0.0f);
		
		BodyDef bd = new BodyDef();
		bd.type = BodyType.DYNAMIC;
		bd.position = body.getPosition();
		Body body2 = world.createBody(bd);
		PolygonShape shape2 = new PolygonShape();
		shape2.setAsBox(1.0f, 1.0f);
		body2.createFixture(shape2,0.0000001f);
		body2.setFixedRotation(true);
		RevoluteJointDef rd = new RevoluteJointDef();
		rd.bodyA = body;
		rd.bodyB = body2;
		rd.enableLimit = true;
		rd.collideConnected = false;
		rd.lowerAngle = - MathUtils.PI / 6.0f;
		rd.upperAngle = MathUtils.PI / 6.0f;
		world.createJoint(rd);*/
	}
		public void jump(){
		if( cont == 0){
		cont = 6;
		joint.enableMotor(true);
		joint.setMaxMotorForce(20000000000000.0f);
		joint.setMotorSpeed(15.0f);
		}
	}
	
	public void step(){
		if( cont > 0) cont--;
		if(cont == 0){
			joint.enableMotor(false);
		}
	}
	
	/*@Override
	protected Vec2 getForcePoint(){
		return body.getWorldPoint(new Vec2(2.0f,-2.0f));
	}*/
	

}

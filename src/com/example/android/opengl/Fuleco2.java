package com.example.android.opengl;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
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


public class Fuleco2 extends Player{
	PrismaticJoint joint;
	int cont;
	PolygonShape shape;
	PolygonShape shape2;
	public Fuleco2() {
		super(-20.0f, 45.0f);
		cont = 0;
		body.setType(BodyType.DYNAMIC);
		shape = new PolygonShape();
		shape.setAsBox(2.0f, 0.1f);
		Fixture a = body.createFixture(shape, 200.0f);
		a.setFriction(0.5f);
		shape2 = new PolygonShape();
		shape2.setAsBox(2.0f, 1.8f, new Vec2(0.0f,2.0f),0.0f);
		Fixture b = body.createFixture(shape2, 0.0f);
		b.setFriction(0.5f);
	
		
	}
	public void draw(float[] mMVPMatrix) {
		(new Square(shape)).draw(mMVPMatrix);
		(new Square(shape2)).draw(mMVPMatrix);
	}
	

}

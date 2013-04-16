package com.example.android.opengl;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;

public class Map1 extends PhysicalMap{

	private PolygonShape polygon;
	private PolygonShape shape;
	
	public Map1() {
		super(0.0f,0.0f);
		
		Vec2 []vertices = new Vec2[10];
		vertices[0] = new Vec2(-20.0f, 35.0f);
		vertices[1] = new Vec2(-35.0f, 5.0f);
		vertices[2] = new Vec2(15.0f, 5.0f);
		vertices[3] = new Vec2(-5.0f, 28.0f);
		int count = 4;
		polygon = new PolygonShape();;
		polygon.set(vertices, count);
		body.createFixture(polygon,0.0f);
		
		shape = new PolygonShape();
		shape.setAsEdge(new Vec2(-60.0f, 0f), new Vec2(40.0f, 0f));		
		body.createFixture(shape, 0.0f);
		
		
	}
	
	public void draw(float[] mMVPMatrix) {
		(new Square(shape)).draw(mMVPMatrix);
		(new Square(polygon)).draw(mMVPMatrix);
	}

}

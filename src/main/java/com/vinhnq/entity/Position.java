package com.vinhnq.entity;

public class Position {
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Position(int type, double dx, double dy, double confidence, double radius) {
		super();
		this.type = type;
		this.dx = dx;
		this.dy = dy;
		this.confidence = confidence;
		this.radius = radius;
	}
	private int type;
	private double dx;
	private double dy;
	private double confidence;
	private double radius;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getDx() {
		return dx;
	}
	public void setDx(double dx) {
		this.dx = dx;
	}
	public double getDy() {
		return dy;
	}
	public void setDy(double dy) {
		this.dy = dy;
	}
	public double getConfidence() {
		return confidence;
	}
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	


}

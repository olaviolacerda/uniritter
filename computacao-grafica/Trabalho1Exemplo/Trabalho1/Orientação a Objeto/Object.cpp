#pragma once
#include "Object.h"
#include "Scene.h"

Object::Object() :r(0), g(0), b(0), Sx(1), Sy(1), Sz(1), angulo(0), Rx(0), Ry(0), Rz(0), Tx(0), Ty(0), Tz(0)
{
	Scene::addObject(this);
}


Object::~Object()
{
}


void Object::scale(float Rx, float Ry, float Rz)
{
	this->Sx *= Rx;
	this->Sy *= Ry;
	this->Sz *= Rz;
}


void Object::translate(float Rx, float Ry, float Rz)
{
	this->Tx += Rx;
	this->Ty += Ry;
	this->Tz += Rz;
}

void Object::rotate(float angulo, float Rx, float Ry, float Rz)
{
	this->angulo = angulo;
	this->Rx = Rx;
	this->Ry = Ry;
	this->Rz = Rz;
}

void Object::color(int r, int g, int b) {
	this->r = r;
	this->g = g;
	this->b = b;
}

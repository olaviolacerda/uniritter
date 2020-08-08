#pragma once
#include "Frog.h"


Frog::Frog(float vx, float vy, float vx1, float vy1, float vel) : r(0.36), g(0.84), b(0.46)
{

	this->vx = vx;
	this->vy = vy;
	this->vx1 = vx1;
	this->vy1 = vy1;
	this->vel = vel;
}


Frog::~Frog()
{
}


#pragma once
#include "Car.h"
#include <iostream>


Car::Car(float vx, float vy, float vx1, float vy1, float vel) : r(0), g(0), b(0)
{
	this->vx = vx;
	this->vy = vy;
	this->vx1 = vx1;
	this->vy1 = vy1;
	this->vel = vel/600;
}


Car::~Car()
{
}

void Car::color(float r, float g, float b) {
	this->r = r;
	this->g = g;
	this->b = b;
}



#pragma once
class Car
{
	
public:
	float r;
	float g;
	float b;
	float vx;
	float vy;
	float vx1;
	float vy1;
	float vel;
	Car(float vx, float vy, float vx1, float vy1, float vel);
	~Car();
	void color(float r, float g, float b);
};
	
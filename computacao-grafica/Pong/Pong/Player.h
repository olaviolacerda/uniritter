#pragma once
class Player
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
	Player(float vx, float vy, float vx1, float vy1, float vel);
	~Player();
};


#pragma once
#include "Object.h"
#include "Line.h"
#include <cmath>
class CircleRosi : public Object
{
	void bresenhamCircleRosi(int raio, int circle_c, int circle_y);
	float raio, xc, yc;
public:
	CircleRosi(int raio, int circle_x, int circle_y);
	~CircleRosi();
	void draw();
};

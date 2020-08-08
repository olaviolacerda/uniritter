#pragma once
#include "Object.h"
#include "GL\glew.h"
#include "GL\freeglut.h"
class Line :
	public Object
{
	void bresenham(int x, int y, int x1, int y1);
	int x1;
	int y1;
public:
	Line(int x, int y, int x1, int y1);
	~Line();

	void draw();
};


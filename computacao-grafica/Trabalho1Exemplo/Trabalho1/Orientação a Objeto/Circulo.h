#pragma once
#include "Object.h"
#include <stdio.h>
#include "GL\glew.h"
#include "GL\freeglut.h"
#include <cmath>


class Circulo : public Object
{
	void desenhaCircle(int raio, int lados);
	int raio, lados;
public:
	Circulo(int raio, int lados, int r, int g, int b);
	Circulo(int raio, int lados);
	~Circulo();

	void draw();
};
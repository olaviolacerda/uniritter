#pragma once
#include "Object.h"
#include "Scene.h"
#include "Line.h"
#include "main.h"
#include "Box.h"
#include "Circulo.h"

void main(int argc, char **argv)
{
	/*Line linha1(-250, 200, 250, 200);
	Line linha2(0, -300, 0 ,200);
	linha1.color(1, 0, 0);
	linha2.color(0, 0, 0);*/
	Box b;
	//Circulo c2(100, 100);
	Scene ceninha(argc, argv, "Janelinha", 600, 600);
	
	system("pause");

}
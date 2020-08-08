#pragma once
#include <vector>
#include "Object.h"
#include "GL\glew.h"
#include "GL\freeglut.h"

using namespace std; 

class Scene
{
	static vector<Object*> gajos;
public:
	Scene(int argc, char ** argv, string titulo = "Sem titulo", int w = 500, int h = 500);
	~Scene();
	static void draw();
	void inicio(void);
	static void addObject(Object *o);
};


#pragma once
#include "Scene.h"


Scene::Scene(int argc, char **argv, string titulo, int w, int h)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
	glutInitWindowSize(w, h);
	glutCreateWindow(titulo.c_str());
	glutDisplayFunc(draw);
	inicio();
	glutMainLoop();

}

Scene::~Scene()
{
}


void Scene::draw(void)
{
	for (int i = 0; i < gajos.size(); i++) {
		gajos[i]->draw();
	}
	glutSwapBuffers();
}

void Scene::inicio() {
	glClearColor(1, 1, 1, 1);
}

void Scene::addObject(Object *o) {
	gajos.push_back(o);

}

vector<Object*> Scene::gajos;
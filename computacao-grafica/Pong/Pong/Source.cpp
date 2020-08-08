#pragma once
#include "Metodos.h"


void main(int argc, char **argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
	glutInitWindowSize(600, 600);
	glutInitWindowPosition(600, 300);
	glutCreateWindow("PingPong");
	init();
	glutIdleFunc(colid);
	glutKeyboardFunc(keyboard);
	glutSpecialFunc(keyboard2);
	if (cont == 1) {
		glutDisplayFunc(venc1);
	}
	else if (cont == 2) {
		glutDisplayFunc(venc2);
	}
	else {
		glutDisplayFunc(draw);
	}
	glutMainLoop();
	system("pause");
}
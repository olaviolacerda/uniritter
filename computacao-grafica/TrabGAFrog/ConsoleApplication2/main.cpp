#pragma once
#include "Metodos.h"


int main(int argc, char **argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
	glutInitWindowSize(600, 600);
	glutInitWindowPosition(600, 300);
	glutCreateWindow("FROGG - Flávio e Olavio - CGIGA");
	initVar();
	glutKeyboardFunc(keyboard);
	glutIdleFunc(colid);
	PlaySound(snd, NULL, SND_LOOP | SND_ASYNC);
	if (cont == 1) {
		glutDisplayFunc(vic);
	}
	else if (cont == 2) {
		glutDisplayFunc(der);
	}
	else {
		glutDisplayFunc(draw);
	}
	glutMainLoop();
	return 0;
}


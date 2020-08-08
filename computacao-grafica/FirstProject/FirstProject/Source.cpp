#include "GL\glew.h"
#include "GL\freeglut.h"

void cena() {
	glClear(GL_COLOR_BUFFER_BIT);
	//corpo
	glBegin(GL_TRIANGLE_FAN);
	glColor3f(1.0, 0.0, 0.0);
	glVertex2d(-0.75, 0.25);
	glVertex2d(0.25, 0.25);
	glVertex2d(0.25, -0.13);
	glVertex2d(-0.75, -0.13);
	glEnd();
	//frente
	glBegin(GL_TRIANGLE_FAN);
	glColor3f(0.0, 0.0, 1.0);
	glVertex2d(0.3, 0.25);
	glVertex2d(0.5, 0.13);
	glVertex2d(0.5, 0);
	glVertex2d(0.3, -0.13);
	glEnd();
	//roda grande superior
	glBegin(GL_TRIANGLE_FAN);
	glColor3f(0.0, 0.0, 0.0);
	glVertex2d(-0.65, 0.5);
	glVertex2d(-0.4, 0.5);
	glVertex2d(-0.3, 0.4);
	glVertex2d(-0.4, 0.3);
	glVertex2d(-0.65, 0.3);
	glVertex2d(-0.75, 0.4);
	glEnd();
	//roda pequena superior
	glBegin(GL_TRIANGLE_FAN);
	glColor3f(0.0, 0.0, 0.0);
	glVertex2d(-0.1, 0.385);
	glVertex2d(0.0, 0.47);
	glVertex2d(0.15, 0.47);
	glVertex2d(0.25, 0.385);
	glVertex2d(0.15, 0.3);
	glVertex2d(0.0, 0.3);
	glEnd();
	//roda grande inferior
	glBegin(GL_TRIANGLE_FAN);
	glColor3f(0.0, 0.0, 0.0);
	glVertex2d(-0.65, -0.17);
	glVertex2d(-0.4, -0.17);
	glVertex2d(-0.3, -0.27);
	glVertex2d(-0.4, -0.37);
	glVertex2d(-0.65, -0.37);
	glVertex2d(-0.75, -0.27);
	glEnd();
	//roda pequena inferior
	glBegin(GL_TRIANGLE_FAN);
	glColor3f(0.0, 0.0, 0.0);
	glVertex2d(-0.1, -0.25);
	glVertex2d(0.0, -0.17);
	glVertex2d(0.15, -0.17);
	glVertex2d(0.25, -0.25);
	glVertex2d(0.15, -0.34);
	glVertex2d(0.0, -0.34);
	glEnd();

	/*cartesiano
		glBegin(GL_LINES);
		glColor3f(1, 0.0, 0.0);
		glVertex2d(1.0, 0.0);
		glVertex2d(-1.0, 0.0);
		glVertex2d(0.0, 1.0);
		glVertex2d(0.0, -1.0);
		glEnd();
	*/
	glutSwapBuffers();
}
void inicio() {
	glClearColor(1, 1, 1, 1);
}

int main(int argc, char **argv) {
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);

	glutCreateWindow("Janelinha");
	glutDisplayFunc(cena);

	inicio();
	glutMainLoop();

	return 0;
}
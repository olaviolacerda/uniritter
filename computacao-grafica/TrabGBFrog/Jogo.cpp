#include <gl/freeglut.h>
#include <iostream>
using namespace std;

GLfloat angle, fAspect;

// Fun��o callback chamada para fazer o desenho
void Desenha(void)
{
	// Limpa a janela e o depth buffer
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	//rua base
	glColor3f(0.190, 0.190, 0.190);
	glBegin(GL_QUADS);
	glVertex3f(-100.0, 0.0, 100.0);
	glVertex3f(-100.0, 0.0, -100.0);
	glVertex3f(100.0, 0.0, -100.0);
	glVertex3f(100.0, 0.0, 100.0);
	glEnd();

	//linha de cima
	glLineWidth(15);
	glColor3f(1.0, 1.0, 1.0);
	glBegin(GL_LINES);
	glVertex3f(-100.0, 0.0, -50.0);
	glVertex3f(100.0, 0.0, -50.0);
	glEnd();

	//linha central
	glLineWidth(2);
	glColor3f(1.0, 0.0, 0.0);
	glBegin(GL_LINES);
	glVertex3f(-100.0, 0.0, 0.0);
	glVertex3f(100.0, 0.0, 0.0);
	glEnd();

	//cubo
	glColor3f(0.0, 1.0, 0.0);
	//base
	glBegin(GL_QUADS);
	glVertex3f(-10.0,0.0,100.0);
	glVertex3f(-10.0, 0.0,90.0);
	glVertex3f(10.0, 0.0, 90.0);
	glVertex3f(10.0, 0.0, 100.0);
	glEnd();
	//cima
	glBegin(GL_QUADS);
	glVertex3f(-10.0, 10.0, 100.0);
	glVertex3f(-10.0, 10.0, 90.0);
	glVertex3f(10.0, 10.0, 90.0);
	glVertex3f(10.0, 10.0, 100.0);
	glEnd();
	//tras
	glBegin(GL_QUADS);
	glVertex3f(-10.0, 0.0, 100.0);
	glVertex3f(-10.0, 10.0, 100.0);
	glVertex3f(10.0, 10.0, 100.0);
	glVertex3f(10.0, 0.0, 100.0);
	glEnd();
	//frente
	glBegin(GL_QUADS);
	glVertex3f(-10.0, 0.0, 90.0);
	glVertex3f(-10.0, 10.0, 90.0);
	glVertex3f(10.0, 10.0, 90.0);
	glVertex3f(10.0, 0.0, 90.0);
	glEnd();
	glutSwapBuffers();

}

// Inicializa par�metros de rendering
void Inicializa(void)
{
	// Especifica que a cor de fundo da janela ser�
	glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
	// Habilita o modelo de coloriza��o de Gouraud
	//glShadeModel(GL_SMOOTH);
	glShadeModel(GL_FLAT);
	angle = 45;
}

// Fun��o usada para especificar o volume de visualiza��o
void EspecificaParametrosVisualizacao(void)
{
	// Especifica sistema de coordenadas de proje��o
	glMatrixMode(GL_PROJECTION);
	// Inicializa sistema de coordenadas de proje��o
	glLoadIdentity();

	// Especifica a proje��o perspectiva
	gluPerspective(angle, fAspect, 0.4, 500);

	// Especifica sistema de coordenadas do modelo
	glMatrixMode(GL_MODELVIEW);
	// Inicializa sistema de coordenadas do modelo
	glLoadIdentity();

	// Especifica posi��o do observador e do alvo
	gluLookAt(0, 100, 200, 0, 0, 0, 0, 1, 0);
}

// Fun��o callback chamada quando o tamanho da janela � alterado 
void AlteraTamanhoJanela(GLsizei w, GLsizei h)
{
	// Para previnir uma divis�o por zero
	if (h == 0) h = 1;

	// Especifica o tamanho da viewport
	glViewport(0, 0, w, h);

	// Calcula a corre��o de aspecto
	fAspect = (GLfloat)w / (GLfloat)h;

	EspecificaParametrosVisualizacao();
}

// Fun��o callback chamada para gerenciar eventos do mouse
void GerenciaMouse(int button, int state, int x, int y)
{
	if (button == GLUT_LEFT_BUTTON)
		if (state == GLUT_DOWN) {  // Zoom-in
			if (angle >= 10) angle -= 5;
		}
	if (button == GLUT_RIGHT_BUTTON)
		if (state == GLUT_DOWN) {  // Zoom-out
			if (angle <= 130) angle += 5;
		}
	EspecificaParametrosVisualizacao();
	glutPostRedisplay();
}

int main(int argc, char **argv)
{
	//Initialize GLUT
	glutInit(&argc, argv);

	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
	glutInitWindowSize(500, 500);
	glutCreateWindow("Frog3D");
	glutDisplayFunc(Desenha);
	glutReshapeFunc(AlteraTamanhoJanela);
	glutMouseFunc(GerenciaMouse);
	Inicializa();
	glutMainLoop();
}
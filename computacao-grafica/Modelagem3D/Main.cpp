#include <GL\freeglut.h>
#include <iostream>
using namespace std;

GLfloat xRotated, yRotated, zRotated;
GLfloat angle, fAspect, stepX, stepY, stepZ, PosCamX, PosCamZ, PosAngleX, PosAngleY, deltaAngle, ly, lz, aux, xr1, yr1, zr1, auxxr, auxyr, auxzr;
GLfloat posxcar, poszcar, movcarx, movcarz, angulo, sizex, sizeaux, aj = 1, poszcam, posxcam;

GLfloat escala = 50.0;
void desenha(void)
{
	glClear(GL_COLOR_BUFFER_BIT);
	glTranslatef(0.0, 0.0, 0.0); // Z -5.0
	glColor3f(0.0, 0.5, 0.0);

	//Inicio Cubo
	glPushMatrix();
	glBegin(GL_POLYGON);
	glVertex3f(0.5, -0.5, 0.5);
	glVertex3f(0.5, 0.5, 0.5);
	glVertex3f(-0.5, 0.5, 0.5);
	glVertex3f(-0.5, -0.5, 0.5);
	glEnd();

	glBegin(GL_POLYGON);
	glVertex3f(0.5, -0.5, -0.5);
	glVertex3f(0.5, 0.5, -0.5);
	glVertex3f(0.5, 0.5, 0.5);
	glVertex3f(0.5, -0.5, 0.5);
	glEnd();

	glBegin(GL_POLYGON);
	glVertex3f(-0.5, -0.5, 0.5);
	glVertex3f(-0.5, 0.5, 0.5);
	glVertex3f(-0.5, 0.5, -0.5);
	glVertex3f(-0.5, -0.5, -0.5);
	glEnd();

	glBegin(GL_POLYGON);
	glVertex3f(0.5, 0.5, 0.5);
	glVertex3f(0.5, 0.5, -0.5);
	glVertex3f(-0.5, 0.5, -0.5);
	glVertex3f(-0.5, 0.5, 0.5);
	glEnd();

	glBegin(GL_POLYGON);
	glVertex3f(0.5, -0.5, -0.5);
	glVertex3f(0.5, -0.5, 0.5);
	glVertex3f(-0.5, -0.5, 0.5);
	glVertex3f(-0.5, -0.5, -0.5);
	glEnd();
	glPopMatrix();
	//Final Cubo
	//glScalef(escala, escala, escala);
	glPushMatrix();
	//Carro Cima
	glBegin(GL_POLYGON);
	glVertex3f(0.75 + posxcar, -0.5, 0.5 + poszcar);
	glVertex3f(0.75 + posxcar, 0.5, 0.5 + poszcar);
	glVertex3f(-0.75 + posxcar, 0.5, 0.5 + poszcar);
	glVertex3f(-0.75 + posxcar, -0.5, 0.5 + poszcar);
	glEnd();

	// Lado DIREITA
	glBegin(GL_POLYGON);
	glVertex3f(0.75 + posxcar, -0.5, -0.5 + poszcar);
	glVertex3f(0.75 + posxcar, 0.5, -0.5 + poszcar);
	glVertex3f(0.75 + posxcar, 0.5, 0.5 + poszcar);
	glVertex3f(0.75 + posxcar, -0.5, 0.5 + poszcar);
	glEnd();

	// Lado v ESQUERDA
	glBegin(GL_POLYGON);
	glVertex3f(-0.75 + posxcar, -0.5, 0.5 + poszcar);
	glVertex3f(-0.75 + posxcar, 0.5, 0.5 + poszcar);
	glVertex3f(-0.75 + posxcar, 0.5, -0.5 + poszcar);
	glVertex3f(-0.75 + posxcar, -0.5, -0.5 + poszcar);
	glEnd();

	// Lado  TOPO
	glBegin(GL_POLYGON);
	glVertex3f(0.75 + posxcar, 0.5, 0.5 + poszcar);
	glVertex3f(0.75 + posxcar, 0.5, -0.5 + poszcar);
	glVertex3f(-0.75 + posxcar, 0.5, -0.5 + poszcar);
	glVertex3f(-0.75 + posxcar, 0.5, 0.5 + poszcar);
	glEnd();

	// Lado  BASE
	glBegin(GL_POLYGON);
	glVertex3f(0.75 + posxcar, -0.5, -0.5 + poszcar);
	glVertex3f(0.75 + posxcar, -0.5, 0.5 + poszcar);
	glVertex3f(-0.75 + posxcar, -0.5, 0.5 + poszcar);
	glVertex3f(-0.75 + posxcar, -0.5, -0.5 + poszcar);
	glEnd();
	glPopMatrix();

	//Carro Baixo
	glPushMatrix();
	glTranslatef(0.0, -0.5, 0.0);
	glBegin(GL_POLYGON);
	glVertex3f(1.0 + posxcar, -0.3, 0.5 + poszcar);
	glVertex3f(1.0 + posxcar, 0.3, 0.5 + poszcar);
	glVertex3f(-1.0 + posxcar, 0.3, 0.5 + poszcar);
	glVertex3f(-1.0 + posxcar, -0.3, 0.5 + poszcar);
	glEnd();

	// Lado DIREITA
	glBegin(GL_POLYGON);
	glVertex3f(1.0 + posxcar, -0.3, -0.5 + poszcar);
	glVertex3f(1.0 + posxcar, 0.3, -0.5 + poszcar);
	glVertex3f(1.0 + posxcar, 0.3, 0.5 + poszcar);
	glVertex3f(1.0 + posxcar, -0.3, 0.5 + poszcar);
	glEnd();

	// Lado ESQUERDA
	glBegin(GL_POLYGON);
	glVertex3f(-1.0 + posxcar, -0.3, 0.5 + poszcar);
	glVertex3f(-1.0 + posxcar, 0.3, 0.5 + poszcar);
	glVertex3f(-1.0 + posxcar, 0.3, -0.5 + poszcar);
	glVertex3f(-1.0 + posxcar, -0.3, -0.5 + poszcar);
	glEnd();

	// Lado  TOPO
	glBegin(GL_POLYGON);
	glVertex3f(1.0 + posxcar, 0.3, 0.5 + poszcar);
	glVertex3f(1.0 + posxcar, 0.3, -0.5 + poszcar);
	glVertex3f(-1.0 + posxcar, 0.3, -0.5 + poszcar);
	glVertex3f(-1.0 + posxcar, 0.3, 0.5 + poszcar);
	glEnd();

	// Lado BASE
	glBegin(GL_POLYGON);
	glVertex3f(1.0 + posxcar, -0.3, -0.5 + poszcar);
	glVertex3f(1.0 + posxcar, -0.3, 0.5 + poszcar);
	glVertex3f(-1.0 + posxcar, -0.3, 0.5 + poszcar);
	glVertex3f(-1.0 + posxcar, -0.3, -0.5 + poszcar);
	glEnd();
	glPopMatrix();

	//roda 1
	glPushMatrix();
	glTranslatef(xr1 + posxcar, -yr1, -zr1 + poszcar);
	glRotatef(zRotated, 0.0, 0.0, 1.0);

	glScalef(0.2, 0.2, 0.2);
	glutWireTorus(0.5, 0.5, 20, 20);
	glPopMatrix();
	//roda 2
	glPushMatrix();
	glTranslatef(-xr1 + posxcar, -yr1, -zr1 + poszcar);
	glRotatef(zRotated, 0.0, 0.0, 1.0);

	glScalef(0.2, 0.2, 0.2);
	glutWireTorus(0.5, 0.5, 20, 20);
	glPopMatrix();
	//roda 3
	glPushMatrix();
	glTranslatef(xr1 + posxcar, -yr1, zr1 + poszcar);
	glRotatef(zRotated, 0.0, 0.0, 1.0);

	glScalef(0.2, 0.2, 0.2);
	glutWireTorus(0.5, 0.5, 20, 20);
	glPopMatrix();
	//roda 4
	glPushMatrix();
	glTranslatef(-xr1 + posxcar, -yr1, zr1 + poszcar);
	glRotatef(zRotated, 0.0, 0.0, 1.0);

	glScalef(0.2, 0.2, 0.2);
	glutWireTorus(0.5, 0.5, 20, 20);
	glPopMatrix();

	glFlush();
	glutSwapBuffers();
}


void EspecificaParametrosVisualizacao(void)
{
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluPerspective(angle, fAspect, 0.1, 500.0);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	gluLookAt(0.0 + posxcam, 0.0, 0.0 + poszcam, posxcar, 0, poszcar, 0, 1, 0.0);
}



void AlteraTamanhoJanela(GLsizei w, GLsizei h)
{
	if (h == 0) h = 1;
	glViewport(0, 0, w, h);
	fAspect = (GLfloat)w / (GLfloat)h;
	EspecificaParametrosVisualizacao();
}

void GerenciaTeclado(unsigned char key, int x, int y)
{
	switch (key) {
	case '1':
		stepX = 0.01;
		stepY = 0;
		stepZ = 0;
		break;
	case '2':
		stepX = 0;
		stepY = 0.01;
		stepZ = 0;
		break;
	case '3':
		stepX = 0;
		stepY = 0;
		stepZ = 0.1;
		break;
	case '4':
		escala += 0.1;
		cout << escala << endl;
		break;
	case '5':
		escala -= 0.1;
		cout << escala << endl;
		break;
	case 'w':
		//PosCamZ += 0.5;
		poszcar += 0.5;
		break;
	case 'd':
		//PosCamX -= 0.5;
		posxcar += 0.5;
		break;
	case 's':
		//PosCamZ -= 0.5;
		poszcar -= 0.5;
		break;
	case 'a':
		//PosCamX += 0.5;
		posxcar -= 0.5;
		break;
	case 13:
		
	if (aj == 1) {
			aj = 0;
			
		}
		else {
			aj = 1;
		}
		
		break;
	}
	glutPostRedisplay();
	EspecificaParametrosVisualizacao();
}

void idleFunc(void)
{
	
	
	if (aj == 0) {
		posxcam = posxcar + 3.0;
		poszcam = poszcar;
	}
	else {
		posxcar = (10 * cos(angulo*(3.14 / 180)));
		poszcar = (10 * sin(angulo*(3.14 / 180)));
		angulo += 0.005;

		if (angulo > 360) {
			angulo = 0;
		}
	}
	cout << "X " << posxcar;
	cout << "| z " << poszcar <<endl;
	zRotated += stepZ;
	desenha();
	EspecificaParametrosVisualizacao();
}


void Inicializa(void)
{
	glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
	angle = 45;
	stepX = stepY = stepZ = 0;
	PosCamX = 0.0;
	PosCamZ = -10.0;
	PosAngleX = 0.0;
	PosAngleY = 0.0;
	aux = -0.75;
	xr1 = 0.75;
	yr1 = 0.9;
	zr1 = 0.5;
	posxcar = 0.0;
	poszcar = 0.0;
	movcarx = 0.0;
	movcarz = 0.0;
	angulo = 0.0;
	sizex = 1.0;
	sizeaux = 0.1;
	poszcam = 0.0;
	posxcam = 0.0;
}

void GerenciaMouse(int button, int state, int x, int y)
{
	if (button == GLUT_LEFT_BUTTON)
		if (state == GLUT_DOWN) {
			if (angle >= 10) angle -= 5;
		}
	if (button == GLUT_RIGHT_BUTTON)
		if (state == GLUT_DOWN) {
			if (angle <= 130) angle += 5;
		}
	EspecificaParametrosVisualizacao();
	glutPostRedisplay();
}


void GerenciaMovimento(int x, int y)
{

	PosAngleY = (y - 175) / -50.0;
	PosAngleX = (x - 175) / -50.0;
	EspecificaParametrosVisualizacao();
	glutPostRedisplay();

}

int main(int argc, char **argv)
{

	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
	glutInitWindowSize(350, 350);
	glutCreateWindow("Cube3d animation");
	glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
	xRotated = yRotated = zRotated = 0.0;
	glClearColor(0.0, 0.0, 0.0, 0.0);
	glutDisplayFunc(desenha);
	glutReshapeFunc(AlteraTamanhoJanela);
	glutKeyboardFunc(GerenciaTeclado);
	glutMouseFunc(GerenciaMouse);
	glutPassiveMotionFunc(GerenciaMovimento);
	Inicializa();
	glutIdleFunc(idleFunc);
	glutMainLoop();
	return 0;
}
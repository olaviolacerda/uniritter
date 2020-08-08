#include <GL\freeglut.h>
#include <iostream>
using namespace std;
GLfloat xRotated, yRotated, zRotated;
double angle, fAspect, stepX, stepY, stepZ, cX, cY, cZ, coX, coY, coZ, angulo = 0;
bool trigger = false;
void desenha(void)
{
	// limpa o bufffer de desenho
	glClear(GL_COLOR_BUFFER_BIT);
	// limpa a matriz identidade
	//glLoadIdentity();
	// traslada o desenho para z = -5.0
	// Quando trasladamos o desenho para x = -0.8 ele est� mais longe, e parece menor
	//glTranslatef(0.0, 0.0, -0.0);
	// Define a cor do desenho
	glColor3f(0.0, 0.5, 0.0);

	// Mudan�as na matriz de transforma��o
	// rota��o sobre o eixo X
	glRotatef(xRotated, 1.0, 0.0, 0.0);
	// rota��o sobre o eixo Y
	glRotatef(yRotated, 0.0, 1.0, 0.0);
	// rota��o sobre o eixo Z
	glRotatef(zRotated, 0.0, 0.0, 1.0);
	// Defini��o de escala
	glScalef(1.0, 1.0, 1.0);

	// Fun��o pr�pria da gut para desneoh de primitivas 3d
	//glutSolidTeapot(1);
	//void glutWireCube(GLdouble size);
	//glutWireCube(1);
	//void glutWireSphere(GLdouble radius, GLint slices, GLint stacks);
	//glutWireSphere(1, 5, 5);
	//void glutWireCone(GLdouble radius, GLdouble height, GLint slices, GLint stacks);
	//void glutWireTorus(GLdouble innerRadius, GLdouble outerRadius, GLint nsides, GLint rings);
	//void glutWireIcosahedron(void);
	//void glutWireOctahedron(void);
	//void glutWireTetrahedron(void);
	//void glutWireDodecahedron(GLdouble radius);

	//Questão 01
	//Desenhando carro
	glColor3f(1, 0, 0);
	//parte inferior

	glBegin(GL_QUADS);
	glVertex3f(-2.0, 0.3, 1.0);
	glVertex3f(-2.0, 0.3, -1.0);
	glVertex3f(-2.0, -0.3, -1.0);
	glVertex3f(-2.0, -0.3, 1.0);
	glEnd();
	glBegin(GL_QUADS);
	glVertex3f(2.0, 0.3, 1.0);
	glVertex3f(2.0, -0.3, 1.0);
	glVertex3f(2.0, -0.3, -1.0);
	glVertex3f(2.0, 0.3, -1.0);
	glEnd();
	glBegin(GL_QUADS);
	glVertex3f(-2.0, 0.3, -1.0);
	glVertex3f(-2.0, 0.3, 1.0);
	glVertex3f(2.0, 0.3, 1.0);
	glVertex3f(2.0, 0.3, -1.0);
	glEnd();
	glBegin(GL_QUADS);
	glVertex3f(-2.0, -0.3, -1.0);
	glVertex3f(2.0, -0.3, -1.0);
	glVertex3f(2.0, -0.3, 1.0);
	glVertex3f(-2.0, -0.3, 1.0);
	glEnd();

	//parte superior
	glPushMatrix();
	glTranslatef(0.2, 0.6, 0.0);
	glScalef(0.8, 1.0, 1.0);
	glBegin(GL_QUADS);
	glVertex3f(-2.0, 0.3, 1.0);
	glVertex3f(-2.0, 0.3, -1.0);
	glVertex3f(-2.0, -0.3, -1.0);
	glVertex3f(-2.0, -0.3, 1.0);
	glEnd();
	glBegin(GL_QUADS);
	glVertex3f(2.0, 0.3, 1.0);
	glVertex3f(2.0, -0.3, 1.0);
	glVertex3f(2.0, -0.3, -1.0);
	glVertex3f(2.0, 0.3, -1.0);
	glEnd();
	glBegin(GL_QUADS);
	glVertex3f(-2.0, 0.3, -1.0);
	glVertex3f(-2.0, 0.3, 1.0);
	glVertex3f(2.0, 0.3, 1.0);
	glVertex3f(2.0, 0.3, -1.0);
	glEnd();
	glBegin(GL_QUADS);
	glVertex3f(-2.0, -0.3, -1.0);
	glVertex3f(2.0, -0.3, -1.0);
	glVertex3f(2.0, -0.3, 1.0);
	glVertex3f(-2.0, -0.3, 1.0);
	glEnd();

	glPopMatrix();
	//rodas
	glColor3f(0, 0, 0);
	glPushMatrix();
	glTranslatef(1.6, -0.3, 1.1);
	glScalef(0.9, 0.9, 0.9);
	glutWireTorus(0.1, 0.3, 20, 20);
	glPopMatrix();
	glPushMatrix();
	glTranslatef(1.6, -0.3, -1.1);
	glScalef(0.9, 0.9, 0.9);
	glutWireTorus(0.1, 0.3, 20, 20);
	glPopMatrix();
	glPushMatrix();
	glTranslatef(-1.6, -0.3, 1.1);
	glScalef(0.9, 0.9, 0.9);
	glutWireTorus(0.1, 0.3, 20, 20);
	glPopMatrix();
	glPushMatrix();
	glTranslatef(-1.6, -0.3, -1.1);
	glScalef(0.9, 0.9, 0.9);
	glutWireTorus(0.1, 0.3, 20, 20);
	glPopMatrix();
	//fim rodas

	//Questão 02
	glColor3f(0, 1, 0);
	//desenha cubo
	glPushMatrix();
	glBegin(GL_QUADS);
	glVertex3f(-0.5, 0.5, 0.5);
	glVertex3f(-0.5, 0.5, -0.5);
	glVertex3f(-0.5, -0.5, -0.5);
	glVertex3f(-0.5, -0.5, 0.5);
	glEnd();
	glBegin(GL_QUADS);
	glVertex3f(0.5, 0.5, 0.5);
	glVertex3f(0.5, -0.5, 0.5);
	glVertex3f(0.5, -0.5, -0.5);
	glVertex3f(0.5, 0.5, -0.5);
	glEnd();
	glBegin(GL_QUADS);
	glVertex3f(-0.5, 0.5, -0.5);
	glVertex3f(-0.5, 0.5, 0.5);
	glVertex3f(0.5, 0.5, 0.5);
	glVertex3f(0.5, 0.5, -0.5);
	glEnd();
	glBegin(GL_QUADS);
	glVertex3f(-0.5, -0.5, -0.5);
	glVertex3f(0.5, -0.5, -0.5);
	glVertex3f(0.5, -0.5, 0.5);
	glVertex3f(-0.5, -0.5, 0.5);
	glEnd();
	glPopMatrix();
	//fim desenha cubo

	// Esvazia o buffer na tela
	glFlush();
	// troca o buffer pois estamos usando double buffering 
	glutSwapBuffers();
}


// Especifica��o do volume de visualiza��o
void EspecificaParametrosVisualizacao(void)
{
	// Especifica sistema de coordenadas de proje��o
	glMatrixMode(GL_PROJECTION);

	// Inicializa sistema de coordenadas de proje��o
	glLoadIdentity();

	// Especifica a proje��o perspectiva
	gluPerspective(angle, fAspect, 0.1, 500);

	/*	Esta fun��o estabelece os par�metros da Proje��o Perspectiva,
	atualizando a matriz de proje��o perspectiva.
	Seu prot�tipo �:
	void gluPerspective(GLdouble fovy, GLdouble aspect, GLdouble zNear, GLdouble zFar);
	Descri��o dos par�metros:
	1) fovy � o �ngulo, em graus, na dire��o y (usada para determinar a
	"altura" do volume de visualiza��o);
	2) aspect � a raz�o de aspecto que determina a �rea de visualiza��o
	na dire��o x, e seu valor � a raz�o em x(largura) e y(altura);
	3) zNear, que sempre deve ter um valor positivo maior do que zero,
	� a dist�ncia do observador at� o plano de corte mais pr�ximo(em z);
	4) zFar, que tamb�m sempre tem um valor positivo maior do que zero,
	� a dist�ncia do observador at� o plano de corte mais afastado(em z).
	Esta fun��o sempre deve ser definida ANTES da fun��o gluLookAt, e no modo GL_PROJECTION  */

	// Especifica sistema de coordenadas do modelo
	glMatrixMode(GL_MODELVIEW);

	// Inicializa sistema de coordenadas do modelo
	glLoadIdentity();

	// Especifica posi��o do observador e do alvo
	if (trigger) {

		cX = (20 * cos(angulo * (3.14 / 180)));
		cZ = (20 * sin(angulo * (3.14 / 180)));
	}
	gluLookAt(cX, cY, cZ, coX, coY, coZ, 0, 1, 0);

	/*Descri��o dos par�metros:
	1) eyex, eyey e eyez s�o usados para definir as
	coordenadas x, y e z, respectivamente, da posi��o
	da c�mera(ou observador);
	2) centerx, centery e centerz s�o usados para
	definir as coordenadas x, y e z, respectivamente,
	da posi��o do alvo, isto �, para onde o
	observador est� olhando  (normalmente, o centro da cena);
	3) upx, upy e upz s�o as coordenadas x, y e z,
	que estabelecem o vetor up(indica o
	"lado de cima" de uma cena 3D)*/
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

// Fun��o callback chamada para gerenciar eventos de teclado
void GerenciaTeclado(unsigned char key, int x, int y)
{
	switch (key) {
	case '1':
		stepX = 0.03;
		stepY = 0;
		stepZ = 0;
		break;
	case '2':
		stepX = 0;
		stepY = 0.03;
		stepZ = 0;
		break;
	case '3':
		stepX = 0;
		stepY = 0;
		stepZ = 0.03;
		break;
		//pos camera com wasd
	case 'w':

		if (cZ < 50) {
			cZ += 5.0;
		}
		else {
			break;
		}
		break;
	case 'a':
		if (cX > -50) {
			cX -= 5.0;
		}
		else {
			break;
		}
		break;
	case 's':
		if (cZ > -100) {
			cZ -= 5.0;
		}
		else {
			break;
		}
		break;
	case 'd':
		if (cX < 50) {
			cX += 5.0;
		}
		else {
			break;
		}
		break;
		//gira câmera
	case 'g':
		angulo += 36;
		if (angulo > 360) {
			angulo = 0;
		}
		cout << angulo << " | " << cX << " " << cZ << endl;
		break;
	case 'r':
		trigger = !trigger;
		break;
	case 'h':
		angulo -= 36;
		if (angulo < 0) {
			angulo = 360;
		}
		cout << angulo << " | " << cX << " " << cZ << endl;
		break;
	}
	glutPostRedisplay();
	EspecificaParametrosVisualizacao();
}

void idleFunc(void)
{
	xRotated += stepX;
	yRotated += stepY;
	zRotated += stepZ;
	desenha();
}


// Inicializa par�metros de rendering
void Inicializa(void)
{
	glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
	angle = 45;
	stepX = stepY = stepZ = 0;
	cX = 20;
	cY = 0;
	cZ = 20;
	coX = 0.0;
	coY = 0.0;
	coZ = 0.0;
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

void GerenciaMovimentoMouse(int x, int y) {
	x = x - 200.0;
	y = y - 200.0;
	coY = -0.04 * y;
	coX = 0.04 * x;
	EspecificaParametrosVisualizacao();
	glutPostRedisplay();
}

int main(int argc, char **argv)
{
	//Initialize GLUT
	glutInit(&argc, argv);
	//double buffering used to avoid flickering problem in animation
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
	// window size
	glutInitWindowSize(400, 400);
	// create the window 
	glutCreateWindow("Modelagem 3D");
	glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
	xRotated = yRotated = zRotated = 0.0;

	glClearColor(0.0, 0.0, 0.0, 0.0);
	//Assign  the function used in events
	glutDisplayFunc(desenha);
	glutReshapeFunc(AlteraTamanhoJanela);
	glutKeyboardFunc(GerenciaTeclado);
	glutMouseFunc(GerenciaMouse);
	glutPassiveMotionFunc(GerenciaMovimentoMouse);
	Inicializa();
	glutIdleFunc(idleFunc);
	//Let start glut loop
	glutMainLoop();
	return 0;
}
#include "GL\glew.h"
#include "GL\freeglut.h"
#include <stdio.h>
#include "conio.h"
#include <windows.h> 
#include <stdlib.h> //Fundamental para chamada de sistemas. 



float p1x, p1y;
float p2x, p2y;
float largura, altura;
float bolax, bolay, bola;
float velocidadeX, velocidadeY, aumentaVelocidade;
int contador;

void init(void)
{
	p1x = -1.5f;
	p1y = 3.5f;
	p2x = -1.5f;
	p2y = -3.8f;
	velocidadeX = 0.0005f;
	velocidadeY = 0.0005f;

	bolax = 0.0f;
	bolay = 0.0f;
	bola = 0.25f;

	largura = 3.0f;
	altura = 0.25f;

	glClearColor(1.0, 1.0, 1.0, 0.0);

	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();

	glOrtho(-5.0, 5.0, -5.0, 5.0, -5.0, 5.0);
}

void jogo()
{
	//Player Vermelho
	if (bolax >= p1x && bolax <= p1x + largura) {
		if (bolay >= p1y && bolay <= p1y + altura) {
			velocidadeY = velocidadeY*-1;
		}
	}
	else {
		if (bolax >= p1x && bolax <= p1x + largura) {
			if (bolay + bola >= p1y && bolay + bola <= p1y + altura) {
				velocidadeY = velocidadeY*-1;
			}
		}
		else {
			if (bolax + bola >= p1x && bolax + bola <= p1x + largura) {
				if (bolay >= p1y && bolay <= p1y + altura) {
					velocidadeY = velocidadeY*-1;
				}
			}
			else {
				if (bolax + bola >= p1x && bolax + bola <= p1x + largura) {
					if (bolay + bola >= p1y && bolay + bola <= p1y + altura) {
						velocidadeY = velocidadeY*-1;
					}
				}
			}
		}
	}

	//Player Azul
	if (bolax >= p2x && bolax <= p2x + largura) {
		if (bolay >= p2y && bolay <= p2y + altura) {
			velocidadeY = velocidadeY*-1;
		}
	}
	else {
		if (bolax >= p2x && bolax <= p2x + largura) {
			if (bolay + bola >= p2y && bolay + bola <= p2y + altura) {
				velocidadeY = velocidadeY*-1;
			}
		}
		else {
			if (bolax + bola >= p2x && bolax + bola <= p2x + largura) {
				if (bolay >= p2y && bolay <= p2y + altura) {
					velocidadeX = velocidadeX*-1;
				}
			}
			else {
				if (bolax + bola >= p2x && bolax + bola <= p2x + largura) {
					if (bolay + bola >= p2y && bolay + bola <= p2y + altura) {
						velocidadeX = velocidadeX*-1;
					}
				}
			}
		}
	}

	//Reverter ao bater na laterais
	if (bolax + largura > 7.8f) {
		velocidadeX = velocidadeX*-1;
	}

	if (bolax < -5.0f) {
		velocidadeX = velocidadeX*-1;
	}

	glutPostRedisplay();

}

void teclado(unsigned char c, int x, int y)
{
	//Movimento dos "jogadores"
	switch (c)
	{
	case 'a':
		Beep(660, 100);
		if (p1x > -5)
		{
			p1x -= 0.5f;
		}
		break;
	case 'd':
		if (p1x < 2)
		{
			p1x += 0.5f;
		}
		break;
	}
}

void teclasEspeciais(int tecla, int x, int y)
{
	switch (tecla) {

	case GLUT_KEY_LEFT:
		if (p2x > -5)
		{
			p2x -= 0.5f;
		}
		break;

	case GLUT_KEY_RIGHT:
		if (p2x < 2)
		{
			p2x += 0.5f;
		}
		break;
	}
}


void display() {

	glClear(GL_COLOR_BUFFER_BIT);

	// Vermelho
	glColor3f(1.0f, 0.0f, 0.0f);
	glBegin(GL_POLYGON);
	{
		glVertex2f(p1x, p1y + altura);
		glVertex2f(p1x, p1y);
		glVertex2f(p1x + largura, p1y);
		glVertex2f(p1x + largura, p1y + altura);

	}
	glEnd();

	// Azul
	glColor3f(0.0f, 0.0f, 1.0f);
	glBegin(GL_POLYGON);
	{
		glVertex2f(p2x, p2y + altura);
		glVertex2f(p2x, p2y);
		glVertex2f(p2x + largura, p2y);
		glVertex2f(p2x + largura, p2y + altura);

	}
	glEnd();

	glColor3f(0.0, 1.0, 0.0);

	//Desenha bolinha
	glBegin(GL_POLYGON);
	{

		glVertex2f(bolax, bolay);
		glVertex2f(bolax + bola, bolay);
		glVertex2f(bolax + bola, bolay + bola);
		glVertex2f(bolax, bolay + bola);
	}
	glEnd();

	bolax += velocidadeX;
	bolay += velocidadeY;

	glFlush();

	glutPostRedisplay();
}

int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(500, 500);
	glutInitWindowPosition(100, 100);
	glutCreateWindow("PONG!");
	init();

	glutIdleFunc(jogo);
	glutSpecialFunc(teclasEspeciais);
	glutKeyboardFunc(teclado);
	glutDisplayFunc(display);
	glutMainLoop();
	return 0;
}
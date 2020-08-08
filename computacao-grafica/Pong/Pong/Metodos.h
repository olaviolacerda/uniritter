#pragma once
#include <iostream>
#include "GL\glew.h"
#include "GL\freeglut.h"
#include <vector>
#include "Player.h"
#include "Bola.h"
#include "conio.h"
#include <windows.h> 
#include <stdlib.h>

using namespace std;
GLfloat win = 300.0f;
//manipula vetor
vector<Player*> players;
char texto[50];
int cont = 0;

//escrever na tela
void DesenhaTexto(char *string)
{
	glPushMatrix();
	// Posiçăo no universo onde o texto será colocado          
	glRasterPos2f(win - 100.0, win);
	// Exibe caracter a caracter
	while (*string)
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, *string++);
	glPopMatrix();
}
//fim escrever na tela


void venc1() {
	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(0.0f, 0.0f, 0.0f);
	strcpy(texto, "Player 1 VENCEU!!");
	DesenhaTexto(texto);
	cont = 1;
	Beep(300, 400);
	glutSwapBuffers();
	system("pause");
};

void venc2() {
	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(0.0f, 0.0f, 0.0f);
	strcpy(texto, "Player 2 VENCEU!!");
	DesenhaTexto(texto);
	cont = 2;
	Beep(300, 400);
	glutSwapBuffers();
	system("pause");
};

void addPlayer(Player *p) {
	players.push_back(p);
}

//instancia players e bola
Player p1(200.0, 75.0, 400.0, 50.0, 10.0); //baixo verde
Player p2(200.0, 525.0, 400.0, 500.0, 10.0); // cima vermelho
Bola b(200.0, 100.0, 220.0, 80.0);

//desenha
void draw() {
	p1.r = 1.0;
	p2.g = 1.0;
	addPlayer(&p2);
	addPlayer(&p1);
	//desenhandooo
	glClear(GL_COLOR_BUFFER_BIT);

	//bola
	glBegin(GL_QUADS);
	glColor3f(0.0, 0.0, 1.0);
	glVertex2d(b.vx, b.vy);
	glVertex2d(b.vx, b.vy1);
	glVertex2d(b.vx1, b.vy1);
	glVertex2d(b.vx1, b.vy);
	glEnd();

	//movimenta bola
	b.vx += b.velx;
	b.vx1 += b.velx;
	b.vy += b.vely;
	b.vy1 += b.vely;

	//fimmovimenta bola
	//fim bola

	//players
	for (int i = 0; i < players.size(); i++) {
		glColor3f(players[i]->r, players[i]->g, players[i]->b);
		glBegin(GL_POLYGON);
		glVertex2d(players[i]->vx, players[i]->vy);
		glVertex2d(players[i]->vx, players[i]->vy1);
		glVertex2d(players[i]->vx1, players[i]->vy1);
		glVertex2d(players[i]->vx1, players[i]->vy);
		glEnd();
	}

	glutSwapBuffers();
	glFlush();
	glutPostRedisplay();
}

//colisão entre objetos
void colid()
{
	//p1 de baixo	
	if (b.vx >= players[0]->vx && b.vx <= players[0]->vx1) {
		if (b.vy >= players[0]->vy1) {
			b.vely *= -1.0;
		}
	}
	else {
		if (b.vx1 >= players[0]->vx && b.vx1 <= players[0]->vx1) {
			if (b.vy >= players[0]->vy1) {
				b.vely *= -1.0;
			}
		}
	}

	//p2 de cima
	if (b.vx >= players[1]->vx && b.vx <= players[1]->vx1) {
		if (b.vy1 >= players[1]->vy1 && b.vy1 <= players[1]->vy) {
			b.vely *= -1.0;
		}
	}
	else {
		if (b.vx1 >= players[1]->vx && b.vx1 <= players[1]->vx1) {
			if (b.vy1 >= players[1]->vy1 && b.vy1 <= players[1]->vy) {
				b.vely *= -1.0;
			}
		}
	}

	//limites bola parede
	if (b.vx1 > 600.0) {
		b.velx *= -1.0;
	}

	if (b.vx < 0.0) {
		b.velx *= -1.0;
	}
	//limites teto e chão, pra conferir vitória
	if (b.vy > 530.0) {
		venc2();
	}

	if (b.vy1 < 45.0) {
		venc1();
	}
	glutPostRedisplay();
}


//colisão entre objetos

//init
void init(void)
{
	glClearColor(1, 1, 1, 1);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluOrtho2D(0, 600, 600, 0);
}

//teclado p2
void keyboard(unsigned char c, int x, int y)
{
	switch (c)
	{
	case 'a':
		if (p1.vx > 0.0)
		{
			p1.vx -= p1.vel;
			p1.vx1 -= p1.vel;
		}
		break;
	case 'd':
		if (p1.vx1 < 600.0)
		{
			p1.vx += p1.vel;
			p1.vx1 += p1.vel;
		}
		break;
	}
}

//teclado p1
void keyboard2(int key, int x, int y)
{
	switch (key) {

	case GLUT_KEY_LEFT:
		if (p2.vx > 0.0)
		{
			p2.vx -= p2.vel;
			p2.vx1 -= p2.vel;
		}
		break;

	case GLUT_KEY_RIGHT:
		if (p2.vx1 < 600.0)
		{
			p2.vx += p2.vel;
			p2.vx1 += p2.vel;
		}
		break;
	}
}


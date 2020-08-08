#pragma once
#include <iostream>
#include "GL\glew.h"
#include "GL\freeglut.h"
#include <vector>
#include "Car.h"
#include "Frog.h"
#include <iostream>  
#include <windows.h>
#include <conio.h>
#include <dos.h>
#include <stdio.h>
#include <mmsystem.h>
using namespace std;

//variaveis
int cont = 0;
char texto[50];
LPCWSTR snd = L"..\\snd\\sound.WAV";
LPCWSTR dead = L"..\\snd\\dead.wav";
LPCWSTR winner = L"..\\snd\\win.wav";
GLfloat sizes[2], step;

//manipula vetor
vector<Car*> carros;
void addCar(Car *c) {
	carros.push_back(c);
}

//instancia sapo
Frog cururu(-35.0, -530.0, 35.0, -600.0, 14.0);
//fimsapo

//instancia carrros
Car c1(-600.0, -100.0, -500.0, -150.0, 22.0);
Car c2(-600.0, -200.0, -400.0, -250.0, 4.0);
Car c3(-600.0, -300.0, -500.0, -350.0, 18.0);
Car c4(-600.0, -400.0, -400.0, -450.0, 16.0);
Car c5(-600.0, 100.0, -500.0, 50.0, 18.0);
Car c6(-600.0, 200.0, -400.0, 150.0, 12.0);
Car c7(-600.0, 270.0, -500.0, 225.0, 14.0);
//fimcarro

//fim variaveis

//escrever na tela
void DesenhaTexto(char *string)
{
	glPushMatrix();
	glRasterPos2f(-450.0, 525.0);
	while (*string)
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, *string++);
	glPopMatrix();
}
void DesenhaTextoCentro(char *string)
{
	glPushMatrix();
	glRasterPos2f(-300.0, 50.0);
	while (*string)
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, *string++);
	glPopMatrix();
}
//fim escrever na tela


//desenha sapo
void drawF() {
	//	//limite sapo para guia e colisão
	//	glBegin(GL_POLYGON);
	//	glVertex2d(cururu.vx, cururu.vy);
	//	glVertex2d(cururu.vx, cururu.vy1);
	//	glVertex2d(cururu.vx1, cururu.vy1);
	//	glVertex2d(cururu.vx1, cururu.vy);
	//	glEnd();
	//	//fim limite sapo
		//braço esquerdo1
	glBegin(GL_POLYGON);
	glVertex2d(cururu.vx + 4, (cururu.vy - 7));
	glVertex2d(cururu.vx + 4, (cururu.vy - 30.0));
	glVertex2d((cururu.vx + 14.0), (cururu.vy - 30.0));
	glVertex2d((cururu.vx + 14.0), (cururu.vy - 7));
	glEnd();

	////braço direito2
	glBegin(GL_POLYGON);
	glVertex2d((cururu.vx1 - 14.0), (cururu.vy - 7));
	glVertex2d((cururu.vx1 - 14.0), (cururu.vy - 30.0));
	glVertex2d((cururu.vx1 - 4), (cururu.vy - 30.0));
	glVertex2d((cururu.vx1 - 4), (cururu.vy - 7));
	glEnd();

	////perna esquerda3
	glBegin(GL_POLYGON);
	glVertex2d((cururu.vx), (cururu.vy1 + 20.0));
	glVertex2d((cururu.vx), cururu.vy1);
	glVertex2d((cururu.vx + 10.0), cururu.vy1);
	glVertex2d((cururu.vx + 10.0), (cururu.vy1 + 20.0));
	glEnd();

	////perna direita4
	glBegin(GL_POLYGON);
	glVertex2d((cururu.vx1 - 10.0), (cururu.vy1 + 20.0));
	glVertex2d((cururu.vx1 - 10.0), cururu.vy1);
	glVertex2d((cururu.vx1), cururu.vy1);
	glVertex2d((cururu.vx1), (cururu.vy1 + 20.0));
	glEnd();

	//ombros5
	glBegin(GL_POLYGON);
	glVertex2d((cururu.vx + 4.0), (cururu.vy - 30.0));
	glVertex2d((cururu.vx + 4.0), cururu.vy1 + 30.0);
	glVertex2d((cururu.vx1 - 5.0), cururu.vy1 + 30.0);
	glVertex2d((cururu.vx1 - 5.0), (cururu.vy - 30.0));
	glEnd();

	////corpo6
	glBegin(GL_POLYGON);
	glVertex2d((cururu.vx + 20.0), (cururu.vy - 20.0));
	glVertex2d((cururu.vx + 20.0), (cururu.vy1 + 10.0));
	glVertex2d((cururu.vx1 - 20.0), (cururu.vy1 + 10.0));
	glVertex2d((cururu.vx1 - 20.0), (cururu.vy - 20.0));
	glEnd();

	////cabeça7
	glBegin(GL_POLYGON);
	glVertex2d((cururu.vx + 26.0), (cururu.vy - 10.0));
	glVertex2d((cururu.vx + 26.0), (cururu.vy - 20.0));
	glVertex2d((cururu.vx1 - 26.0), (cururu.vy - 20.0));
	glVertex2d((cururu.vx1 - 26.0), (cururu.vy - 10.0));
	glEnd();

	////cauda8
	glBegin(GL_POLYGON);
	glVertex2d((cururu.vx + 30.0), (cururu.vy1 + 10.0));
	glVertex2d((cururu.vx + 30.0), (cururu.vy1 + 4.0));
	glVertex2d((cururu.vx1 - 30.0), (cururu.vy1 + 4.0));
	glVertex2d((cururu.vx1 - 30.0), (cururu.vy1 + 10.0));
	glEnd();

	//coxas9
	glBegin(GL_POLYGON);
	glVertex2d((cururu.vx + 10.0), (cururu.vy1 + 20.0));
	glVertex2d((cururu.vx + 10.0), cururu.vy1 + 10.0);
	glVertex2d((cururu.vx1 - 10.0), cururu.vy1 + 10.0);
	glVertex2d((cururu.vx1 - 10.0), (cururu.vy1 + 20.0));
	glEnd();

	//fim sapo
}
//fim desenhasapo

//desenhacarro
void drawC() {
	//add car no carros
	addCar(&c7);
	addCar(&c6);
	addCar(&c5);
	addCar(&c4);
	addCar(&c3);
	addCar(&c2);
	addCar(&c1);
	//fim add car no carros
	//carros
	for (int i = 0; i < carros.size(); i++) {
		//desenha carro
		glColor3f(carros[i]->r, carros[i]->g, carros[i]->b);
		//corpo
		glBegin(GL_POLYGON);
		glVertex2d(carros[i]->vx, carros[i]->vy);
		glVertex2d(carros[i]->vx, carros[i]->vy1);
		glVertex2d(carros[i]->vx1, carros[i]->vy1);
		glVertex2d(carros[i]->vx1, carros[i]->vy);

		glEnd();

		//movimenta carros 
		carros[i]->vx += carros[i]->vel;
		carros[i]->vy += 0.0;
		carros[i]->vx1 += carros[i]->vel;
		carros[i]->vy1 += 0.0;
		//fimmovimenta carros

		//tratamento de colisão com parede
		if (carros[i]->vx > 600.0 || carros[i]->vx1 < -600.0) {
			if (i % 2 == 0) {
				carros[i]->vx = -600.0;
				carros[i]->vx1 = -500.0;
			}
			else {
				carros[i]->vx = -600.0;
				carros[i]->vx1 = -400.0;
			}
			//carros[i]->vel = carros[i]->vel*-1;
			//cout << "ai ";
			break;
		}
		////fim colisão parede
	}
	//fim carros
}
//fim desenha carro

//func condições
void der() {
	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(1.0f, 1.0f, 1.0f);
	cout << "Termina jogo." << endl;
	strcpy(texto, "              YOU LOSE!");
	DesenhaTextoCentro(texto);
	PlaySound(dead, NULL, SND_FILENAME | SND_ASYNC);
	cont = 2;
	glutSwapBuffers();
	system("pause");
}

void vic() {
	glClearColor(0.155, 0.545, 0.655, 1);
	glClear(GL_COLOR_BUFFER_BIT);
	cout << "Termina jogo." << endl;
	glColor3f(cururu.r, cururu.g, cururu.b);
	drawF();
	glColor3f(0.0, 0.0, 0.0);
	strcpy(texto, "               YOU WIN!");
	DesenhaTextoCentro(texto);
	PlaySound(winner, NULL, SND_FILENAME | SND_ASYNC);
	cont = 1;
	glutSwapBuffers();
	system("pause");
}
//fim func condicoes


//desenha
void draw() {
	glClear(GL_COLOR_BUFFER_BIT);
	glGetFloatv(GL_LINE_WIDTH_RANGE, sizes);
	glGetFloatv(GL_LINE_WIDTH_GRANULARITY, &step);

	glLineWidth(10);

	//faixas amarelas
	glEnable(GL_LINE_STIPPLE);
	glLineStipple(5, 0x00FF);
	glColor3f(1.0, 1.0, 0.0);
	glBegin(GL_LINES);
	glVertex2d(-600.0, 0.0);
	glVertex2d(600.0, 0.0);
	glEnd();

	glColor3f(1.0, 1.0, 0.0);
	glBegin(GL_LINES);
	glVertex2d(-600.0, -100.0);
	glVertex2d(600.0, -100.0);
	glEnd();
	glDisable(GL_LINE_STIPPLE);
	//fim faixas

	//laguinho
	glColor3f(0.155, 0.545, 0.655);
	glBegin(GL_POLYGON);
	glVertex2d(-600.0, 600.0);
	glVertex2d(-600.0, 300.0);
	glVertex2d(600.0, 300.0);
	glVertex2d(600.0, 600.0);
	glEnd();
	//fimlago

	//terra cima e baixo
	glColor3f(0.244, 0.222, 0.141);
	glBegin(GL_POLYGON);
	glVertex2d(-600.0, 375.0);
	glVertex2d(-600.0, 300.0);
	glVertex2d(600.0, 300.0);
	glVertex2d(600.0, 375.0);
	glEnd();

	glColor3f(0.244, 0.222, 0.141);
	glBegin(GL_POLYGON);
	glVertex2d(-600.0, -470.0);
	glVertex2d(-600.0, -600.0);
	glVertex2d(600.0, -600.0);
	glVertex2d(600.0, -470.0);
	glEnd();
	//fimterra

	//desenha limite pista branco
	glLineWidth(15);
	glColor3f(1.0, 1.0, 1.0);
	glBegin(GL_LINES);
	glVertex2d(-600.0, 300.0);
	glVertex2d(600.0, 300.0);
	glEnd();

	glColor3f(1.0, 1.0, 1.0);
	glBegin(GL_LINES);
	glVertex2d(-600.0, -480.0);
	glVertex2d(600.0, -480.0);
	glEnd();
	//fim desenha limite pista

	//elementos desenho
	glColor3f(cururu.r, cururu.g, cururu.b);
	drawF(); //sapo
	glColor3f(0.0f, 0.0f, 0.0f);
	drawC(); //carros
	DesenhaTexto(texto);
	glutSwapBuffers();
	glFlush();
	glutPostRedisplay();
}


//colisão entre objetos
void colid()
{
	//começo
	for (int i = 0; i < carros.size(); i++) {
		if (carros[i]->vx >= cururu.vx && carros[i]->vx <= cururu.vx1) {
			if (carros[i]->vy >= cururu.vy1 && carros[i]->vy <= cururu.vy) {
				cout << "ops 1" << endl;
				der();
			}
		}
		else {
			if (carros[i]->vx1 >= cururu.vx && carros[i]->vx1 <= cururu.vx1) {
				if (carros[i]->vy >= cururu.vy1 && carros[i]->vy <= cururu.vy) {
					cout << "ops 2" << endl;
					der();
				}
			}
			else {
				if (carros[i]->vx >= cururu.vx && carros[i]->vx <= cururu.vx1) {
					if (carros[i]->vy1 >= cururu.vy1 && carros[i]->vy1 <= cururu.vy) {
						cout << "ops 3" << endl;
						der();
					}
				}
				else {
					if (carros[i]->vx1 >= cururu.vx && carros[i]->vx1 <= cururu.vx1) {
						if (carros[i]->vy1 >= cururu.vy1 && carros[i]->vy1 <= cururu.vy) {
							cout << "ops 4" << endl;
							der();
						}
					}
				}
			}
		}
		if (cururu.vx >= carros[i]->vx && cururu.vx <= carros[i]->vx1) {
			if (cururu.vy >= carros[i]->vy1 && cururu.vy <= carros[i]->vy) {
				cout << "ops 5" << endl;
				der();
			}
		}
		else {
			if (cururu.vx1 >= carros[i]->vx && cururu.vx1 <= carros[i]->vx1) {
				if (cururu.vy >= carros[i]->vy1 && cururu.vy <= carros[i]->vy) {
					cout << "ops 6" << endl;
					der();
				}
			}
			else {
				if (cururu.vx >= carros[i]->vx && cururu.vx <= carros[i]->vx1) {
					if (cururu.vy1 >= carros[i]->vy1 && cururu.vy1 <= carros[i]->vy) {
						cout << "ops 7" << endl;
						der();
					}
				}
				else {
					if (cururu.vx1 >= carros[i]->vx && cururu.vx1 <= carros[i]->vx1) {
						if (cururu.vy1 >= carros[i]->vy1 && cururu.vy1 <= carros[i]->vy) {
							cout << "ops 8" << endl;
							der();
						}
					}
				}
			}
		}
	}
	glutPostRedisplay();
	//fim

}
//colisão entre objetos

//init
void initVar(void)
{
	glClearColor(0.190, 0.190, 0.190, 1);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	strcpy(texto, "FROG: Get to the lake without being hit.");
	gluOrtho2D(-600, 600, -600, 600);
}

//teclado
void keyboard(unsigned char c, int x, int y)
{
	switch (c)
	{
	case 'a':
		if (cururu.vx1 > -600.0)
		{
			cururu.vx -= cururu.vel;
			cururu.vx1 -= cururu.vel;
		}
		break;
	case 'd':
		if (cururu.vx < 600.0)
		{
			cururu.vx += cururu.vel;
			cururu.vx1 += cururu.vel;
		}
		break;
	case 'w':
		if (cururu.vy < 600.0)
		{
			cururu.vy += cururu.vel;
			cururu.vy1 += cururu.vel;
		}
		break;
	case 's':
		if (cururu.vy1 > -600.0)
		{
			cururu.vy -= cururu.vel;
			cururu.vy1 -= cururu.vel;
		}
		break;
	}
	if (cururu.vy1 > 375.0) {
		vic();
	}
}


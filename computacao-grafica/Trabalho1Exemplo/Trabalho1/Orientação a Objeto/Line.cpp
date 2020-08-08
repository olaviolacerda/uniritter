
#pragma once
#include "Line.h"




Line::Line(int x, int y, int x1, int y1)
{
	this->x = x;
	this->y = y;
	this->x1 = x1;
	this->y1 = y1;
}


Line::~Line()
{
}

void Line::bresenham(int x1, int y1, int x2, int y2) {
	int slope;
	int dx, dy, incE, incNE, d, x, y;
	if (x1 > x2) {
		bresenham(x2, y2, x1, y1);
		return;
	}
	else if (x1 == x2) {
		if (y1 < y2) {
			for (int i = y1; i <= y2; i++) {
				glVertex2d(x1 / 300.0, i / 300.0);
			}
		}
		else {
			for (int i = y2; i <= y1; i++) {
				glVertex2d(x1 / 300.0, i / 300.0);
			}
		}
		return;
	}
	dx = x2 - x1;
	dy = y2 - y1;

	if (dy < 0) {
		slope = -1;
		dy = -dy;
	}
	else {
		slope = 1;
	}
	incE = 2 * dy;
	incNE = 2 * dy - 2 * dx;
	d = 2 * dy - dx;
	y = y1;
	for (x = x1; x <= x2; x++) {
		glVertex2d(x / 300.0, y / 300.0);
		if (d <= 0) {
			d += incE;
		}
		else {
			d += incNE;
			y += slope;
		}
	}
}

void Line::draw() {
	glColor3f(r, g, b);
	glBegin(GL_POINTS);
	bresenham(x1, y1, x, y);
	glEnd();
}
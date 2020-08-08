#include "CircleRosi.h"

CircleRosi::CircleRosi(int raio, int CircleRosi_x, int CircleRosi_y)
{
	this->raio = raio;
	this->xc = CircleRosi_x;
	this->yc = CircleRosi_y;
}

CircleRosi::~CircleRosi()
{
}


void CircleRosi::bresenhamCircleRosi(int raio, int xc, int yc)
{
	int x = 0, y = raio;
	float pk = (5.0 / 4.0) - raio;

	glVertex2d((xc + x) / 300.0, (yc + y) / 300.0);
	glVertex2d((xc + x) / 300.0, (yc - y) / 300.0);
	glVertex2d((xc + y) / 300.0, (yc + x) / 300.0);
	glVertex2d((xc + y) / 300.0, (yc - x) / 300.0);
	glVertex2d((xc - x) / 300.0, (yc - y) / 300.0);
	glVertex2d((xc - y) / 300.0, (yc - x) / 300.0);
	glVertex2d((xc - x) / 300.0, (yc + y) / 300.0);
	glVertex2d((xc - y) / 300.0, (yc + x) / 300.0);
	
	int k;

	while (x < y)
	{
		x = x + 1;
		if (pk < 0)
			pk = pk + 2 * x + 1;
		else
		{
			y = y - 1;
			pk = pk + 2 * (x - y) + 1;
		}

		glVertex2d((xc + x) / 300.0, (yc + y) / 300.0);
		glVertex2d((xc + x) / 300.0, (yc - y) / 300.0);
		glVertex2d((xc + y) / 300.0, (yc + x) / 300.0);
		glVertex2d((xc + y) / 300.0, (yc - x) / 300.0);
		glVertex2d((xc - x) / 300.0, (yc - y) / 300.0);
		glVertex2d((xc - y) / 300.0, (yc - x) / 300.0);
		glVertex2d((xc - x) / 300.0, (yc + y) / 300.0);
		glVertex2d((xc - y) / 300.0, (yc + x) / 300.0);

	}
}


void CircleRosi::draw()
{
	glColor3f(r, g, b);
	glBegin(GL_POINTS);
	bresenhamCircleRosi(raio, xc, yc);
	glEnd();
}
#include "Box.h"
#include "Line.h"


Box::Box()
{
	srand(time(0));
	for (int i = 0; i < 50; i++) {
		pontos.push_back(point(rand() % 250 - 125, rand() % 250 - 125));
	}
}


Box::~Box()
{
}

void Box::draw() {
	int max = -99999, mex = 99999, may = -99999, mey = 99999;
	glColor3f(0, 0, 0);
	glPointSize(5);
	glBegin(GL_POINTS);
	for (int i = 0; i < 50;i++) {
		glVertex2d(pontos[i].x / 300.0, pontos[i].y / 300.0);
		if (pontos[i].x > max) {
			max = pontos[i].x;
		}
		if (pontos[i].y > may)
		{
			may = pontos[i].y;
		}
		if (pontos[i].x < mex) {
			mex = pontos[i].x;
		}
		if (pontos[i].y < mey)
		{
			mey = pontos[i].y;
		}
	}
	glEnd();
	glBegin(GL_POINTS);
	Line *line1 = new Line(mex, may, max, may);
	Line *line2 = new Line(max, may, max, mey);
	Line *line3 = new Line(mex, may, mex, mey);
	Line *line4 = new Line(mex, mey, max, mey);
	glEnd();


}

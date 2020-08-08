#pragma once
#include "Object.h"
#include <vector>
#include <stdlib.h>
#include <time.h> 
using namespace std;

struct point {
	int x;
	int y;
	point(int x, int y) {
		this->x = x;
		this->y = y;
	}
};

class Box :
	public Object
{
	vector<point> pontos;
public:
	Box() ;
	~Box();
	void draw();
};


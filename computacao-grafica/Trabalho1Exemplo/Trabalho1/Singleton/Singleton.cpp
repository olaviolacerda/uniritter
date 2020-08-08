#include "Singleton.h"

#include <iostream>
using namespace std;

Singleton* Singleton::_instance = 0;

Singleton::Singleton()
{

}

Singleton::~Singleton()
{
}


Singleton* Singleton::Instance() {
	if (_instance == 0) {
		_instance = new Singleton;
	}
	return _instance;
}

void Singleton::minhaFuncao()
{
	cout << "Minha Funcao legal que nao funciona" << endl;
	system("pause");
}

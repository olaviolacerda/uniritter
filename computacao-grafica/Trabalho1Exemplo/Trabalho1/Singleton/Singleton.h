#pragma once

class Singleton {
public:
	static Singleton* Instance();
	void minhaFuncao();
	~Singleton();
protected:
	Singleton();
private:
	static Singleton* _instance;
};


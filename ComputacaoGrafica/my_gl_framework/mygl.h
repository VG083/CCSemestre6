#ifndef _MYGL_H_
#define _MYGL_H_
#endif

#include "definitions.h"

//-----------------------------------------------------------------------------
void MyGlDraw(void);

//*****************************************************************************
// Defina aqui as suas funções gráficas
//*****************************************************************************

void PutPixel(int x, int y, int R, int G, int B, int A);
void DrawLine(int x0, int y0, int R0, int G0, int B0, int A0, int x1, int y1, int R1, int G1, int B1, int A1);
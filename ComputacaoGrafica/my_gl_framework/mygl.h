#ifndef _MYGL_H_
#define _MYGL_H_
#endif

#include "definitions.h"

void MyGlDraw(void);

void PutPixel(
    int x, int y, int R, int G, int B, int A
);
void DrawLine(
    int x0, int y0, int R0, int G0, int B0, int A0, 
    int x1, int y1, int R1, int G1, int B1, int A1
);
void DrawTriangle(
    int x0, int y0, int R0, int G0, int B0, int A0, 
    int x1, int y1, int R1, int G1, int B1, int A1, 
    int x2, int y2, int R2, int G2, int B2, int A2
);
#include "definitions.h"
#include <iostream>
#include <cmath>
#include <stdio.h>

using namespace std;

void MyGlDraw(void) {
    DrawTriangle(0, 0, 0, 255, 0, 255,
                 256, 256, 0, 0, 255, 255,
                 128, 0, 255, 0, 0, 255);
    DrawTriangle(128, 0, 0, 255, 0, 255,
                 256, 256, 0, 0, 255, 255,
                 256, 0, 255, 0, 0, 255);
    DrawTriangle(256, 0, 0, 255, 0, 255,
                 256, 256, 0, 0, 255, 255,
                 384, 0, 255, 0, 0, 255);
    DrawTriangle(384, 0, 0, 255, 0, 255,
                 256, 256, 0, 0, 255, 255,
                 512, 0, 255, 0, 0, 255);
    DrawTriangle(512, 0, 0, 255, 0, 255,
                 256, 256, 0, 0, 255, 255,
                 512, 128, 255, 0, 0, 255);
    DrawTriangle(512, 128, 0, 255, 0, 255,
                 256, 256, 0, 0, 255, 255,
                 512, 256, 255, 0, 0, 255);
    DrawTriangle(512, 256, 0, 255, 0, 255,
                 256, 256, 0, 0, 255, 255,
                 512, 384, 255, 0, 0, 255);
    DrawTriangle(512, 384, 0, 255, 0, 255,
                 256, 256, 0, 0, 255, 255,
                 512, 512, 255, 0, 0, 255);
    DrawTriangle(512, 512, 0, 255, 0, 255,
                 256, 256, 0, 0, 255, 255,
                 384, 512, 255, 0, 0, 255);
    DrawTriangle(384, 512, 0, 255, 0, 255,
                 256, 256, 0, 0, 255, 255,
                 256, 512, 255, 0, 0, 255);
    DrawTriangle(256, 512, 0, 255, 0, 255,
                 256, 256, 0, 0, 255, 255,
                 128, 512, 255, 0, 0, 255);
    DrawTriangle(128, 512, 0, 255, 0, 255,
                 256, 256, 0, 0, 255, 255,
                 0, 512, 255, 0, 0, 255);
    DrawTriangle(0, 512, 0, 255, 0, 255,
                 256, 256, 0, 0, 255, 255,
                 0, 384, 255, 0, 0, 255);
    DrawTriangle(0, 384, 0, 255, 0, 255,
                 256, 256, 0, 0, 255, 255,
                 0, 255, 255, 0, 0, 255);
    DrawTriangle(0, 256, 0, 255, 0, 255,
                 256, 256, 0, 0, 255, 255,
                 0, 128, 0, 255, 0, 255);
}

void PutPixel(int x, int y, int R, int G, int B, int A) {
    int index = 4 * (x + y * IMAGE_WIDTH);
    FBptr[index + 0] = R;
    FBptr[index + 1] = G;
    FBptr[index + 2] = B;
    FBptr[index + 3] = A;
}

void DrawLine(int x0, int y0, int R0, int G0, int B0, int A0,
              int x1, int y1, int R1, int G1, int B1, int A1) {
    int dx = abs(x1 - x0), dy = abs(y1 - y0);
    int sx = (x0 < x1) ? 1 : -1, sy = (y0 < y1) ? 1 : -1;
    int err = dx - dy, e2;
    float t;

    while (x0 != x1 || y0 != y1) {
        t = static_cast<float>(x0 - x1) / dx;
        PutPixel(
            x0, y0, R0 + static_cast<int>(t * (R1 - R0)),
            G0 + static_cast<int>(t * (G1 - G0)),
            B0 + static_cast<int>(t * (B1 - B0)),
            A0 + static_cast<int>(t * (A1 - A0))
        );
        e2 = 2 * err;
        if (e2 > -dy) {
            err -= dy;
            x0 += sx;
        }
        if (e2 < dx) {
            err += dx;
            y0 += sy;
        }
    }
}

void DrawTriangle(int x0, int y0, int R0, int G0, int B0, int A0,
                  int x1, int y1, int R1, int G1, int B1, int A1,
                  int x2, int y2, int R2, int G2, int B2, int A2) {
    DrawLine(x0, y0, R0, G0, B0, A0, x1, y1, R1, G1, B1, A1);
    DrawLine(x1, y1, R1, G1, B1, A1, x2, y2, R2, G2, B2, A2);
    DrawLine(x2, y2, R2, G2, B2, A2, x0, y0, R0, G0, B0, A0);
}

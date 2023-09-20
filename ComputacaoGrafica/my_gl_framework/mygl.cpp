#include "definitions.h"
#include <iostream>
#include <cmath>
#include <stdio.h>

using namespace std;

//-----------------------------------------------------------------------------
void MyGlDraw(void)
{
    //*************************************************************************
    // Chame aqui as funções do mygl.h
    //*************************************************************************
    // Exemplo de uso da função DrawLine para desenhar uma linha vermelha de (10, 10) a (100, 100):
    DrawLine(10, 10, 255, 0, 0, 255,
            500, 500, 255, 0, 0, 255);
}

void PutPixel(int x, int y, int R, int G, int B, int A)
{
    // Calcula o índice do pixel no framebuffer com base nas coordenadas (x, y):
    int index = 4 * (x + y * IMAGE_WIDTH);

    // Define as componentes RGBA do pixel no framebuffer:
    FBptr[index + 0] = R; // componente R
    FBptr[index + 1] = G; // componente G
    FBptr[index + 2] = B; // componente B
    FBptr[index + 3] = A; // componente A
}

void DrawLine(int x0, int y0, int R0, int G0, int B0, int A0,
              int x1, int y1, int R1, int G1, int B1, int A1)
{
    // Calcula as diferenças entre as coordenadas x e y dos pontos iniciais e finais
    int dx = abs(x1 - x0);  // Diferença no eixo x
    int dy = abs(y1 - y0);  // Diferença no eixo y
    // Determina a direção da linha (1 ou -1) ao longo dos eixos x e y
    int sx = (x0 < x1) ? 1 : -1;  // Direção no eixo x
    int sy = (y0 < y1) ? 1 : -1;  // Direção no eixo y
    // Calcula o erro inicial
    int err = dx - dy;
    // Loop principal para desenhar a linha pixel a pixel
    while (true)
    {
        // Calcula o fator de interpolação (t) entre os pontos iniciais e finais
        float t = static_cast<float>(dx + dy - err) / (2 * dx + 2 * dy);
        // Interpola as componentes R, G, B e A da cor entre os pontos iniciais e finais
        int R = static_cast<int>(R0 + t * (R1 - R0));  // Interpolação da componente R
        int G = static_cast<int>(G0 + t * (G1 - G0));  // Interpolação da componente G
        int B = static_cast<int>(B0 + t * (B1 - B0));  // Interpolação da componente B
        int A = static_cast<int>(A0 + t * (A1 - A0));  // Interpolação da componente A
        // Chama a função PutPixel para definir a cor do pixel atual
        PutPixel(x0, y0, R, G, B, A);

        // Verifica se chegamos ao ponto final da linha
        if (x0 == x1 && y0 == y1)
            break;
        // Calcula o erro para o próximo pixel e atualiza as coordenadas x e y
        int e2 = 2 * err;
        if (e2 > -dy)
        {
            err -= dy;
            x0 += sx;  // Atualiza a coordenada x
        }
        if (e2 < dx)
        {
            err += dx;
            y0 += sy;  // Atualiza a coordenada y
        }
    }
}

# Proposta da atividade
Os arquivos mygl.h e mygl.cpp são os únicos arquivos que devem ser alteradosdurante a realização deste exercício. O arquivo mygl.h contém a declaração da funçãoMyGlDraw(), responsável por invocar as funções de rasterização que os alunos irãodesenvolver. É neste arquivo que os alunos também deverão declarar as funções a seremdesenvolvidas. O arquivo mygl.cpp é o lugar onde serão definidas as funções derasterização. Este arquivo contém também a definição da função MyGlDraw(), cujo corpo oaluno deverá alterar de forma que suas funções de rasterização sejam devidamenteinvocadas

As funções a serem criadas são:

    1. PutPixel(): Rasteriza um ponto na memória de vídeo recebendo comoparâmetros as coordenadas (x,y) do pixel na tela e sua cor (RGBA).
    
    2. DrawLine(): Rasteriza uma linha na tela, recebendo como parâmetros ascoordenadas dos seus vértices inicial e final (representados respectivamente pelastuplas (x0,y0) e (x1,y1)) e as cores (no formato RGBA) de cada vértice. O algoritmo derasterização de linha a ser implementado deve ser o Algoritmo de Bresenham!

    3. DrawTriangle(): Função que desenha as arestas de um triângulo na tela, recebendocomo parâmetros as posições dos três vértices (x0,y0), (x1,y1) e (x2,y2) bem como ascores (RGBA) de cada um dos vértices. Não é necessário o preenchimento do triângulo!

# Github da Atividade
https://gitlab.com/maelso/icg

# Comando para Compilar o Arquivo OpenGL
g++ main.cpp -o main -lglut -lGLU -lGL -lm

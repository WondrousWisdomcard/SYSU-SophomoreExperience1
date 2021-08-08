// snake_eat.c
// Create by YouWei Zheng on 18-Dec-2020
//
// Copyright (c) 2020年 Nothing. All rights reserved.

#include<stdio.h>
#include<stdlib.h>
#include<time.h>

#define SNAKE_MAX_LENGTH 50
#define MAP_LENGTH 12
#define SNAKE_HEAD 'H'
#define SNAKE_BODY 'X'
#define BLANK_CELL ' '
#define SNAKE_FOOD '$'
#define WALL_CELL '*'
#define EAT_ITSELF -2
#define HIT_WALL -1

//snake stepping: dy = -1(up),1(down); dx = -1(left),1(right),0(no move)
int snakeMove(int dx, int dy);
//put a food randomized on a blank cell
void putFood(void);
//out cells of the grid
void showGird(void);
//outs when gameover
void gameover(int sign);
//create initial map
void initMap(void);

char map[MAP_LENGTH][MAP_LENGTH];

int snakeLength = 5;
int snakeY[SNAKE_MAX_LENGTH] = {1,1,1,1,1};
int snakeX[SNAKE_MAX_LENGTH] = {1,2,3,4,5};
//the last position (snakeX[snakeLength-1],snakeY[snakeLength-1]) is the head position of snake

void showGird(void){
    printf("\n");
    putFood(); //putfood to update the map
    for(int i = 0; i < MAP_LENGTH; i++){
        for(int j = 0; j < MAP_LENGTH; j++){
            printf("%c", map[i][j]);
        }
        printf("\n");
    }
}

void initMap(void){
    //create the frame of map
    for(int i = 0; i < MAP_LENGTH; i++){
        if(i == 0 || i == MAP_LENGTH-1){
            for(int j = 0; j < MAP_LENGTH; j++){
                map[i][j] = WALL_CELL;
            }
        }
        else{
            for(int j = 0; j < MAP_LENGTH; j++){
                if(j == 0 || j == MAP_LENGTH-1){
                    map[i][j] = WALL_CELL;
                }
                else{
                    map[i][j] = BLANK_CELL;
                }
            }
        }
    }
    //create a snake
    map[1][1] = SNAKE_BODY;
    map[1][2] = SNAKE_BODY;
    map[1][3] = SNAKE_BODY;
    map[1][4] = SNAKE_BODY;
    map[1][5] = SNAKE_HEAD;
}

void gameover(int sign){
    if(sign == HIT_WALL){
        printf("The snake hit the wall!!!\n");
    }
    else if(sign == EAT_ITSELF){
        printf("The snake bite itself!!!\n");
    }

    printf("Game Over!!!\n");
    printf("The snake has %d meter long!",snakeLength);
}

int snakeMove(int dx, int dy){
    // destination position of snake head
    int desSnakeHeadX = snakeX[snakeLength-1] + dx;
    int desSnakeHeadY = snakeY[snakeLength-1] + dy;
    if(map[desSnakeHeadY][desSnakeHeadX] == SNAKE_BODY){
        return EAT_ITSELF;
    }
    else if(map[desSnakeHeadY][desSnakeHeadX] == WALL_CELL){
        return HIT_WALL;
    }
    else if(map[desSnakeHeadY][desSnakeHeadX] == SNAKE_FOOD){
        //update the map
        map[snakeY[snakeLength-1]][snakeX[snakeLength-1]] = SNAKE_BODY;
        map[desSnakeHeadY][desSnakeHeadX] = SNAKE_HEAD;

        snakeLength++;
        //update the coordinate array
        snakeX[snakeLength-1] = desSnakeHeadX;
        snakeY[snakeLength-1] = desSnakeHeadY;
    }
    else{
        //我们可以发现蛇运动的轨迹满足头部占一个原本为空的格子，原来尾巴占据的格子边为空，新的尾巴在是原来的倒数第二个格子，
        //所以对于map的更新，我们只需要更新三个格子，新的头由空变为‘H’，原来的头变为身体‘H’，原来的尾巴变为空。
        int tailX = snakeX[0];
        int tailY = snakeY[0];

        map[tailY][tailX] = BLANK_CELL;
        map[snakeY[snakeLength-1]][snakeX[snakeLength-1]] = SNAKE_BODY;
        map[desSnakeHeadY][desSnakeHeadX] = SNAKE_HEAD;

        for(int i = 0; i < MAP_LENGTH - 1; i++){
            snakeX[i] = snakeX[i+1];
            snakeY[i] = snakeY[i+1];
        }
        snakeX[snakeLength-1] = desSnakeHeadX;
        snakeY[snakeLength-1] = desSnakeHeadY;
    }
    return 0;
}

void putFood(void){
    srand(time(NULL));
    int n = rand() % 2;
    //每次随机生成一个小于二的数n来模拟这次更新新生成的食物总数
    int count = 500;
    for(int i = 0; i < n; i++){
        while(count){
            //随机数获取x坐标和y坐标
            int x = rand() % (MAP_LENGTH - 1) + 1;
            int y = rand() % (MAP_LENGTH - 1) + 1;
            if(map[y][x] == BLANK_CELL){
                map[y][x] = SNAKE_FOOD;
                break;
            }
            count--;
        }
    }
}

int main(){
    initMap();
    showGird();
    int sign = 0;
    char direction[2];
    while(sign == 0){

        printf("NEXT DIRECTION: ");
        scanf("%s",direction);

        switch(direction[0]){
            case 'A': sign = snakeMove(-1,0); break;
            case 'D': sign = snakeMove(1,0); break;
            case 'W': sign = snakeMove(0,-1); break;
            case 'S': sign =snakeMove(0,1); break;
            default : printf("...\n"); break;
        }
        showGird();
    }
    gameover(sign);
    return 0;
}
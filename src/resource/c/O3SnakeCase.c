//
//  O3SnakeCase.c
//  O3cLib
//
//  Created by Hudson Luiz Sales Schumaker on 14.08.20.
//  Copyright © 2020 SchumakerTeam. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <ctype.h>

char* o3snakeCase(char string[]) {
    int i = 0;
    long len = strlen(string);
    char strSnake[len];
    
    while(string[i]) {
        if (string[i] == ' ' || string[i] == '-') {
            strSnake[i] = '_';
        } else {
            strSnake[i] = string[i];
        }
        i++;
    }
    return strSnake;
}

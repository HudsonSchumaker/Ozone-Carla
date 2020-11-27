//
//  O3ReverseCase.c
//  O3cLib
//
//  Created by Hudson Luiz Sales Schumaker on 14.08.20.
//  Copyright © 2020 SchumakerTeam. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <ctype.h>

char* o3reverseCase(char *str) {
    long len = strlen(str);
    char reverse[len];
    int strIndex = len - 1;
    int revIndex = 0;
    while(strIndex >= 0) {
        reverse[revIndex] = str[strIndex];
        strIndex--;
        revIndex++;
    }
    reverse[revIndex] = '\0';
    //printf("%s", ""); // does not work without this line.
    return reverse;
}


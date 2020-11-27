//
//  O3KebabCase.c
//  O3cLib
//
//  Created by Hudson Luiz Sales Schumaker on 14.08.20.
//  Copyright © 2020 SchumakerTeam. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <ctype.h>

char* o3kebabCase(char string[]) {
    int i = 0;
    long len = strlen(string);
    char strKebab[len];
    
    while(string[i]) {
        if (string[i] == ' ' || string[i] == '_') {
            strKebab[i] = '-';
        } else {
            strKebab[i] = string[i];
        }
        i++;
    }
    return strKebab;
}

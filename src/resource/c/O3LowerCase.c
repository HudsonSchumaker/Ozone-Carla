//
//  O3LowerCase.c
//  O3cLib
//
//  Created by Hudson Luiz Sales Schumaker on 14.08.20.
//  Copyright © 2020 SchumakerTeam. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <ctype.h>

char* o3lowerCase(char string[]) {
    
    int i = 0;
    long len = strlen(string);
    char strLower[len];
    
    while(string[i]) {
       strLower[i] = tolower(string[i]);
       i++;
    }
    return strLower;
}

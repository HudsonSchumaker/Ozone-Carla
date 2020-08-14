//
//  O3UpperCase.c
//  O3cLib
//
//  Created by Hudson Luiz Sales Schumaker on 14.08.20.
//  Copyright © 2020 SchumakerTeam. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <ctype.h>

char* o3upperCase(char string[]) {
    
    int i = 0;
    long len = strlen(string);
    char strUpper[len];
    
    while(string[i]) {
       strUpper[i] = toupper(string[i]);
       i++;
    }
    return strUpper;
}

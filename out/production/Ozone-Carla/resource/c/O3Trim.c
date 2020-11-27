//
//  O3Trim.c
//  O3cLib
//
//  Created by Hudson Luiz Sales Schumaker on 14.08.20.
//  Copyright © 2020 SchumakerTeam. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <ctype.h>

const char* o3trim(char *str) {
    while(isspace(*str)) str++;
    long len = strlen(str);
    char* back = str + len;
    while(isspace(*--back));
    *(back+1) = '\0';
       
    long len_trim = strlen(str);
    char *buffer = malloc(len_trim);
    strcpy(buffer, str);
    return buffer;
}
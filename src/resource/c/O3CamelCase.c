//
//  O3CamelCase.c
//  O3cLib
//
//  Created by Hudson Luiz Sales Schumaker on 14.08.20.
//  Copyright © 2020 SchumakerTeam. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <ctype.h>

char* o3camelCase(char value[]) {
    long len = strlen(value);
    char srtCapitalLetters[len];
    srtCapitalLetters[0] = value[0];
    
    int i = 1;
    while (value[i]) {
        if (value[i-1] == ' ' || value[i-1] == '_' || value[i-1] == '-') {
            srtCapitalLetters[i] = toupper(value[i]);
        } else {
            srtCapitalLetters[i] = value[i];
        }
        i++;
    }
    
    int writer = 0, reader = 0;
    char strCamel[len];
    while (srtCapitalLetters[reader]) {
        if (srtCapitalLetters[reader] != ' ' && srtCapitalLetters[reader] != '_' && srtCapitalLetters[reader] != '-') {
            strCamel[writer++] = srtCapitalLetters[reader];
        }
        
        reader++;
    }
    strCamel[writer] = 0;
    return strCamel;
}

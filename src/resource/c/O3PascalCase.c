//
//  O3PascalCase.c
//  O3cLib
//
//  Created by Hudson Luiz Sales Schumaker on 14.08.20.
//  Copyright © 2020 SchumakerTeam. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <ctype.h>

char* o3pascalCase(char value[]) {
    long len = strlen(value);
    char srtCapitalLetters[len];
    srtCapitalLetters[0] = toupper(value[0]);
    
    int i = 1;
    while (value[i]) {
        if (value[i-1] == ' ' || value[i-1] == '_' || value[i-1] == '-') {
            srtCapitalLetters[i] = toupper(value[i]);
        } else {
            srtCapitalLetters[i] = value[i];
        }
        i++;
    }
    
    i = 0;
    long remove = 0;
    while (srtCapitalLetters[i]) {
        if (srtCapitalLetters[i] == ' ' || srtCapitalLetters[i] == '_' || srtCapitalLetters[i] == '-') {
            remove++;
        }
        i++;
    }
    long size = len - remove;
    char strPascal[size];
    
    int writer = 0, reader = 0;
    while (srtCapitalLetters[reader]) {
        if (srtCapitalLetters[reader] != ' ' && srtCapitalLetters[reader] != '_' && srtCapitalLetters[reader] != '-') {
            if (writer < size) {
                strPascal[writer++] = srtCapitalLetters[reader];
            }
        }
        reader++;
    }
    
    strPascal[writer] = 0;
    return strPascal;
}

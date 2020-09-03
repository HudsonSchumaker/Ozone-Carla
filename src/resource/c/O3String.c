//
//  O3String.c - methods for string manipulation.
//
//  Created by Hudson Schumaker on 14.08.20.
//  Copyright © 2020 SchumakerTeam. All rights reserved.
//

#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>

// UPPERCASE
const char* o3upperCase(char *str) {
    int i = 0;
    long len = strlen(str);
    char strUpper[len];

    while(str[i]) {
       strUpper[i] = toupper(str[i]);
       i++;
    }
    char *buffer = malloc(len);
    strcpy(buffer, strUpper);
    return buffer;
}

// lowercase
const char* o3lowerCase(char *str) {
    int i = 0;
    long len = strlen(str);
    char strLower[len];

    while(str[i]) {
       strLower[i] = tolower(str[i]);
       i++;
    }
    char *buffer = malloc(len);
    strcpy(buffer, strLower);
    return buffer;
}

// camelCase
const char* o3camelCase(char *str) {
    long len = strlen(str);
    char srtCapitalLetters[len];
    srtCapitalLetters[0] = tolower(str[0]);

    int i = 1;
    while (str[i]) {
        if (str[i-1] == ' ' || str[i-1] == '_' || str[i-1] == '-') {
            srtCapitalLetters[i] = toupper(str[i]);
        } else {
            srtCapitalLetters[i] = str[i];
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
    char *buffer = malloc(len);
    strcpy(buffer, strCamel);
    return buffer;
}

// PascalCase
const char* o3pascalCase(char *str) {
    long len = strlen(str);
    char srtCapitalLetters[len];
    srtCapitalLetters[0] = toupper(str[0]);

    int i = 1;
    while (str[i]) {
        if (str[i-1] == ' ' || str[i-1] == '_' || str[i-1] == '-') {
            srtCapitalLetters[i] = toupper(str[i]);
        } else {
            srtCapitalLetters[i] = tolower(str[i]);
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
    char *buffer = malloc(size);
    strcpy(buffer, strPascal);
    return buffer;
}

// snake_case
const char* o3snakeCase(char *str) {
    int i = 0;
    long len = strlen(str);
    char strSnake[len];

    while(str[i]) {
        if (str[i] == ' ' || str[i] == '-') {
            strSnake[i] = '_';
        } else {
            strSnake[i] = str[i];
        }
        i++;
    }
    char *buffer = malloc(len);
    strcpy(buffer, strSnake);
    return buffer;
}

// kebab-case
const char* o3kebabCase(char *str) {
    int i = 0;
    long len = strlen(str);
    char strKebab[len];

    while(str[i]) {
        if (str[i] == ' ' || str[i] == '_') {
            strKebab[i] = '-';
        } else {
            strKebab[i] = str[i];
        }
        i++;
    }
    char *buffer = malloc(len);
    strcpy(buffer, strKebab);
    return buffer;
}

// reverse
const char* o3reverseCase(char *str) {
    long len = strlen(str);
    char reverse[len];
    int strIndex = 0;
    int revIndex = len - 1;
    while(strIndex >= 0) {
        reverse[revIndex] = str[strIndex];
        strIndex--;
        revIndex++;
    }
    reverse[revIndex] = '\0';
    char *buffer = malloc(len);
    strcpy(buffer, reverse);
    return buffer;
}

//
//  O3String.c - methods for string manipulation.
//
//  Created by Hudson Luiz Sales Schumaker on 14.08.20.
//  Copyright © 2020 SchumakerTeam. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <ctype.h>

// UPPERCASE
char* o3upperCase(char *str) {
    int i = 0;
    long len = strlen(str);
    char strUpper[len];

    while(str[i]) {
       strUpper[i] = toupper(str[i]);
       i++;
    }
    //fflush(stdout);
    printf("%s", ""); // does not work without this line.
    return strUpper;
}

// lowercase
char* o3lowerCase(char *str) {
    int i = 0;
    long len = strlen(str);
    char strLower[len];

    while(str[i]) {
       strLower[i] = tolower(str[i]);
       i++;
    }
    printf("%s", ""); // does not work without this line.
    return strLower;
}

// camelCase
char* o3camelCase(char *str) {
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
    printf("%s", ""); // does not work without this line.
    return strCamel;
}

// PascalCase
char* o3pascalCase(char *str) {
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
    printf("%s", ""); // does not work without this line.
    return strPascal;
}

// snake_case
char* o3snakeCase(char *str) {
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
    printf("%s", ""); // does not work without this line.
    return strSnake;
}

// kebab-case
char* o3kebabCase(char *str) {
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
    printf("%s", ""); // does not work without this line.
    return strKebab;
}

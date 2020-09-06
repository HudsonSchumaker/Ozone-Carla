//
//  O3RightTrim.c
//  O3cLib
//
//  Created by Hudson Luiz Sales Schumaker on 14.08.20.
//  Copyright © 2020 SchumakerTeam. All rights reserved.
//

const char* o3rtrim(char *str) {
    long len = strlen(str);
    char* back = str + len;
    while(isspace(*--back));
    *(back+1) = '\0';

    char *buffer = malloc(len);
    strcpy(buffer, str);
    return buffer;
}
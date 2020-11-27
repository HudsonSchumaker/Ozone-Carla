//
//  O3LeftTrim.c
//  O3cLib
//
//  Created by Hudson Luiz Sales Schumaker on 14.08.20.
//  Copyright © 2020 SchumakerTeam. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <ctype.h>

const char* o3ltrim(char *str) {
   while(isspace(*str)) str++;
   long len = strlen(str);

   char *buffer = malloc(len);
   strcpy(buffer, str);
   return buffer;
}
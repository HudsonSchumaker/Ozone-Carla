//
//  O3Print.c - print methods 
//
//  Created by Hudson Schumaker on 14.08.20.
//  Copyright © 2020 SchumakerTeam. All rights reserved.
//

#include <stdio.h>

void o3prtStr(char *str) {
   printf("%s", str);
   fflush(stdout);
}

void o3prtStrLn(char *str) {
   printf("%s\n", str);
   fflush(stdout);
}

void o3prtInt(int i) {
   printf("%d", i);
   fflush(stdout);
}

void o3prtIntLn(int i) {
   printf("%d\n", i);
   fflush(stdout);
}

void o3prtFloat(float f) {
   printf("%lf", f);
   fflush(stdout);
}

void o3prtFloatLn(float f) {
   printf("%lf\n", f);
   fflush(stdout);
}

void o3prtDouble(double d) {
   printf("%f", d);
   fflush(stdout);
}

void o3prtDoubleLn(double d) {
   printf("%f\n", d);
   fflush(stdout);
}

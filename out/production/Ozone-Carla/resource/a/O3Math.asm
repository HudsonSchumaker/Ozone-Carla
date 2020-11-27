; O3 Ozone Project Lab
; O3Math.asm - math function
; Created by Hudson Schumaker on 07.09.20.
; Copyright © 2020 SchumakerTeam. All rights reserved.

bits 64
section .data
section .bss

section .text
  global _o3addi, _o3subi, _o3muli, _o3powi, _o3divi, _o3inci, _o3deci

_o3addi:
  mov	 rax, rdi
  add	 rax, rsi
  ret

_o3subi:
  mov	 rax, rdi
  sub	 rax, rsi
  ret

_o3muli:
  mov	 rax, rdi
  imul rsi
  ret

_o3powi:
  mov  rax, rdi
  imul rdi
  ret

_o3divi:
  mov  rax, rdi
  mov  rdx, 0
  idiv rsi
  ret

_o3inci:
  mov  rax, rdi
  inc  rax
  ret

_o3deci:
  mov  rax, rdi
  dec  rax
  ret

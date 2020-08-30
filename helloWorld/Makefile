all:
	chmod 777 /Users/schumaker/NetBeansProjects/CarlaCompiler/helloWorld/nasm/*
	/Users/schumaker/NetBeansProjects/CarlaCompiler/helloWorld/nasm/nasm -f macho64 helloWorld.asm
	ld -macosx_version_min 10.12 -no_pie -lSystem -o helloWorld helloWorld.o O3Print.o O3String.o
clear:
	rm -r nasm rm *.o rm *.asm rm *.c rm *.zip
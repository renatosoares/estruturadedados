# pilha com push, pop e o tamanho.
.data 
endPilha:	.word 	0:10	# Espaço reservado na memória para armazenar endereço
size:		.word 	0	# quantidade de elemento do array
espaco:		.asciiz	" "
quebra:		.asciiz	"\n"

.text
main:
#--------------------------------------------------------------------------------------------
###################	Enderços das memorias para registradores ###########################|
#--------------------------------------------------------------------------------------------

# carregue endereço da memória para armazenar endereço da memória de dados
lui	$at, 0x1001
add	$s0, $zero, $at

# carregue endereço da memória de dados
lui	$at, 0x1001
addi	$s1, $at, 0x4C

add	$t7, $t7, $s0		# ponteiro para o inicio da pilha


# carrega quantidade de elementos do array
lui	$at, 0x1001
addi 	$s5, $at, 0x50
lw	$s5, 0($s5)

#============================================================================================

#--------------------------------------------------------------------------------------------
###################	loop para chamar funções	####################################|
#--------------------------------------------------------------------------------------------
	functionSelecao:
		addi	$v0, $zero, 5
		syscall
		add	$s2, $zero, $v0
		
		addi 	$t0, $zero, 9		# sair do sistema
		beq	$s2, $t0, functionFim
		addi 	$t0, $zero, 1		# chama a função push()
		beq	$s2, $t0, functionPush	# <<<<<<<<<<<<<<<<<<<
		addi	$t0, $zero, 2		# chama a função pop()
		beq	$s2, $t0, functionPop	# <<<<<<<<<<<<<<<<<<<
		addi	$t0, $zero, 3		# chama a função size()
		beq	$s2, $t0, functionSize	# <<<<<<<<<<<<<<<<<<<
	j functionSelecao
#============================================================================================
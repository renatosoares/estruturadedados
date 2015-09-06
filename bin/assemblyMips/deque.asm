# fila
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

add	$t7, $t7, $s0		# ponteiro para o inicio da filha

add	$t8, $zero, $t7		# ponteiro para o final da filha

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
		
		addi 	$t0, $zero, 9			# sair do sistema
		beq	$s2, $t0, functionFim
		addi 	$t0, $zero, 1			# chama a função inCalda()
		beq	$s2, $t0, functioninCalda	# <<<<<<<<<<<<<<<<<<<
		addi	$t0, $zero, 2			# chama a função outCabeca()
		beq	$s2, $t0, functionoutCabeca	# <<<<<<<<<<<<<<<<<<<
		addi	$t0, $zero, 3			# chama a função size()
		beq	$s2, $t0, functionSize		# <<<<<<<<<<<<<<<<<<<
		addi	$t0, $zero, 4			# chama a função cabeca()
		beq	$s2, $t0, functionHead		# <<<<<<<<<<<<<<<<<<<
		addi	$t0, $zero, 5			# chama a função vazia()
		beq	$s2, $t0, functionVazia		# <<<<<<<<<<<<<<<<<<<
		
		addi	$t0, $zero, 6			# chama a função outCalda()
		beq	$s2, $t0, functionoutCalda	# <<<<<<<<<<<<<<<<<<<
	j functionSelecao
#============================================================================================

#--------------------------------------------------------------------------------------------
###################	função inCalda()		####################################|
#--------------------------------------------------------------------------------------------	
	
	functioninCalda:
		addi	$v0, $zero, 5
		syscall
		
		sw	$v0, 0($s0)	#armazena dados na memória
		
		addi 	$t9, $t9, 1	#contador de elementos
		
		addi	$s0, $s0, 4	# passa para proxima memória

		addi	$t8, $t8, 4	# aponta para o fim da fila

	j	functionSelecao
#============================================================================================

#--------------------------------------------------------------------------------------------
###################	função outCabeca()		####################################|
#--------------------------------------------------------------------------------------------	
	functionoutCabeca:
		lw 	$t1, 0($t7)
		# imprima o topo da pilha
		add	$a0, $zero, $t1 
		addi	$v0, $zero, 1
		syscall				
		
		sw	$zero, 0($t7)
		
		addi	$t7, $t7, 4
		addi 	$t9, $t9, -1

	j	functionSelecao
#============================================================================================

#--------------------------------------------------------------------------------------------
###################	função outCalda()		####################################|
#--------------------------------------------------------------------------------------------	
	functionoutCalda:
	
		lw 	$t1, -4($t7)
		# imprima o topo da pilha
		add	$a0, $zero, $t1 
		addi	$v0, $zero, 1
		syscall				
		
		sw	$zero, -4($t7)
		
		addi	$s0, $s0, -4
		addi	$t7, $t7, -4
		addi 	$t9, $t9, -1
		
	j	functionSelecao
#============================================================================================

#--------------------------------------------------------------------------------------------
###################	função head()			####################################|
#--------------------------------------------------------------------------------------------	
	functionHead:
		lw 	$t1, 0($t7)
		# imprima o topo da pilha
		add	$a0, $zero, $t1 
		addi	$v0, $zero, 1
		syscall		

	j	functionSelecao
#============================================================================================

#--------------------------------------------------------------------------------------------
###################	função vazia()			####################################|
#--------------------------------------------------------------------------------------------	
	functionVazia:
		beq	$t7, $t8, verdadeiro	# se os ponteiros estiverem com ponteiros iguais
						# retorne verdadeiro	
		
		# falso
		add	$a0, $zero, $zero 
		addi	$v0, $zero, 1
		syscall	
		j functionSelecao
		
		# verdadeiro
		verdadeiro:
		addi	$a0, $zero, 1 
		addi	$v0, $zero, 1
		syscall					

	j	functionSelecao
#============================================================================================


#--------------------------------------------------------------------------------------------
###################	função size()			####################################|
#--------------------------------------------------------------------------------------------	
	functionSize:

	# imprima o topo da pilha
		add	$a0, $zero, $t9 
		addi	$v0, $zero, 1
		syscall						

	j	functionSelecao
#============================================================================================

#--------------------------------------------------------------------------------------------
###################	função fim()			####################################|
#--------------------------------------------------------------------------------------------		
	functionFim:
		addi	$v0, $zero, 10
		syscall

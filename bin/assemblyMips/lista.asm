# lista
.data 
endLista:	.word 	0:10	# Espaço reservado na memória para armazenar endereço
dadosLista:	.word 	0:10	# Espaço reservado na memória para armazenar endereço
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
addi	$s1, $at, 0x28

add	$t7, $t7, $s0		# ponteiro para o inicio da lista

add	$t8, $zero, $t7		# ponteiro para o final da lista

#============================================================================================

#--------------------------------------------------------------------------------------------
###################	loop para chamar funções	####################################|
#--------------------------------------------------------------------------------------------
	functionSelecao:
		addi	$v0, $zero, 5
		syscall
		add	$s2, $zero, $v0
		
		addi 	$t0, $zero, 9			# sair do sistema
		beq	$s2, $t0, functionFim		# <<<<<<<<<<<<<<<<<<<
		addi 	$t0, $zero, 1			# chama a função Adicionar()
		beq	$s2, $t0, functionAdicionar	# <<<<<<<<<<<<<<<<<<<
		addi 	$t0, $zero, 2			# chama a função outCalda()
		beq 	$s2, $t0, functionoutCalda	# <<<<<<<<<<<<<<<<<<<
	j functionSelecao
#============================================================================================

#--------------------------------------------------------------------------------------------
###################	função adicionar()		####################################|
#--------------------------------------------------------------------------------------------	
	
	functionAdicionar:
		addi	$v0, $zero, 5
		syscall
		
		sw	$s1, 0($s0)	# armazena endereço da memória
		sw	$v0, 0($s1)	# armazena dados da memória
		addi 	$t9, $t9, 1	# contador de elementos
		
		addi	$s0, $s0, 4	# passa para proxima memória endereço
		addi	$s1, $s1, 4	# passa para proxima memória dados

		addi	$t8, $t8, 4	# aponta para o fim da fila

	j	functionSelecao
#============================================================================================

#--------------------------------------------------------------------------------------------
###################	função outCalda()		####################################|
#--------------------------------------------------------------------------------------------	
	functionoutCalda:
	
		lw 	$t1, -4($s0)
		lw	$t1, 0($t1)
		# imprima o topo da pilha
		add	$a0, $zero, $t1 
		addi	$v0, $zero, 1
		syscall				
		lw	$s1, -4($s0)	# a memória de dados recebe o endereço liberado
		sw	$zero, -4($s0)	# volta uma memória e armazena zero no ponteiro
		
		addi	$s0, $s0, -4	# ajusta o ponteiro para o lugar liberado
		
	j	functionSelecao
#============================================================================================

#--------------------------------------------------------------------------------------------
###################	função fim()			####################################|
#--------------------------------------------------------------------------------------------		
	functionFim:
		addi	$v0, $zero, 10
		syscall

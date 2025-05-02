import datetime

#Comandos basicos python
soma = 15
qualquercoisa = True
a = 15 % 3
raio = 5
area = 3.14 * (raio ** 2) 
print(area)
nome = 'Fabio Adriano'
nomeCompleto = nome + 'Jr'
tamanhoVariavelNome = len(nomeCompleto)
primeiroCaracterVarNome = nome[0]
ultimoCaracterVarNome = nome[-1]
penultimoCaracterVarNome = nome[-2]
qualquerCaracterVarNome = nome[7]
print(tamanhoVariavelNome)
print(primeiroCaracterVarNome)
print(ultimoCaracterVarNome)
print(penultimoCaracterVarNome)
print(qualquerCaracterVarNome)
print(nome)
print(nomeCompleto)
a = True
b = True
resultadoLogicoAND = a and b 
resultadoLogicoOR = a or b
resultadoLogicoNOT = not a
print(resultadoLogicoAND)
print(resultadoLogicoOR)
print(resultadoLogicoNOT)
#Comandos python if elif else com ou sem parenteses
if a == True:
    print("Show de bola")
    if(a == b):
        print("a e b são iguais")
if a == b:
    print()
elif():
    print()
else:
    print()

print("Show de bola")
#armazenamento de dados listas, tuplas, dicionarios, arquivos e banco de dados
dicionarioTest = {'sair': 'ação de deixar um lugar', 'entrar': 'ir para dentro de um lugar'}
print(dicionarioTest)#imprimi o dicionario
print(dicionarioTest['sair'])#busca o valor da chave, se nao encontrar o prog para
nomes = []
comida = ['Abacaxi', 'feijão', 'arroz', 'tomate']
print(comida)
comida.append('Alface')
print(comida[2])
print(comida)
comida.clear()
print(comida)

horaAtual = datetime.datetime.now()
print(horaAtual)

while(True):
    horaAtual = datetime.datetime.now()
    print(horaAtual)
    break

print()
i = 1
while i <= 5:
    print(i)
    i += 1
    if i == 5:
        continue
    print(i)

def funcao_vazia():
    pass
    
def imprimi():
    print('imprimir')

funcao_vazia()
imprimi()

def funcComRetornoSemParametro():
    return 2023
result = funcComRetornoSemParametro()
print("Ano Atual: ", result)

def funcSemRetornoComParametro(a, b):
    soma = a + b
    print('A soma de a + b é: ', soma)
funcSemRetornoComParametro(1, 1)

def funcComRetornoComParametro(lista):
    tamanho = len(lista)
    return tamanho

lista1 = [1, 2, 3, 4, 5]
resultado = funcComRetornoComParametro(lista1)
print(resultado)

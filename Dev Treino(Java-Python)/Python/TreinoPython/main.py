from Carro import Carro


passada = 0
print('1 - Cadastrar Veiculo a CNH')
listaCarros = []
var = ''
opcao = int(input('Digite a opção desejada: '))

while passada != 3:
    if opcao == 1: #Cadastra novo veiculo a CNH
        Carro1 = Carro(None, None, None, None, None, None, None, None, None)
        var = str(input('Digite o nome da marca: '))
        Carro1.setMarca(var)
        listaCarros.append(Carro1)
        passada += 1
        if passada == 2:
            opcao = 2
    
    if opcao == 2: #Mostra Lista Objetos Carros
        for imprimi in listaCarros:
            #print(imprimi)
            print(listaCarros)
            #print(Carro1.__str__())
            passada += 1


    if opcao == 0: #Sai do sistema
        pass

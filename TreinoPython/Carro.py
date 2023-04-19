from datetime import date

class Carro:
    def __init__(self, marca, nome, chassi, placa, aro, qtdePortas, pais, preco, ano):
        self._marca = marca
        self._nome = nome
        self._placa = placa
        self._aro = aro
        self._pais = pais
        self._preco = preco
        self._qtdePortas = qtdePortas
        self._chassi = chassi
        self._ano = ano

    def getMarca(self):
        return self._marca

    def setMarca(self, value):
        if not isinstance(value, str):
            raise ValueError('A marca é do tipo String')
        self._marca = value
    
    def getNome(self):
        return self._nome

    def setNome(self, value):
        self._nome = value

    def getPlaca(self):
        return self._placa
        
    def setPlaca(self, value):
        self._placa = value
 
    def getAro(self):
        return self._aro

    def setAro(self, value):
        self._aro = value

    def getPais(self):
        return self._pais

    def setPais(self, value):
        self._pais = value

    def getPreco(self):
        return self._preco

    def setPreco(self, value):
        self._preco = value

    def getqtdePortas(self):
        return self._qtdePortas

    def setqtdePortas(self, value):
        self._qtdePortas = value

    def getChassi(self):
        return self._chassi

    def setChassi(self, value):
        self._chassi = value

    def getAno(self):
        return self._ano

    def setAno(self, value):
        self._ano = value

    def __str__(self):
        self._marca, self._nome
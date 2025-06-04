package com.backEnd.AtacadoEletronico.dto;

import java.util.Date;

/*Nem tudo que esta no meu Banco de Dados eu quero expor para minha API,
 * ENTÃO CRIAMOS A DTO (DATA TRANSFER OBJECT), passamos apenas o necessário para operação
 * 
 * 
 * Classe RECORD -> representa dados apenas para leitura e simples(tipo DTO) e são uma classe normal compacta,
 * com dados final imutaveis.
 * */

public record CreateUserDTO(String cpfCnpj, String name, Date dateBirth, String email, String password, String phome, String gender, String typePeolpe) {

}

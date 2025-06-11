package com.backEnd.AtacadoEletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backEnd.AtacadoEletronico.entities.Address;

public interface AddressRepository extends JpaRepository<Address, String> {

}

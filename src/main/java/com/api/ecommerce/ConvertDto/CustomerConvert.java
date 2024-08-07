package com.api.ecommerce.ConvertDto;

import com.api.ecommerce.DTOs.CustomerDto;
import com.api.ecommerce.entities.CustomerEntity;

public class CustomerConvert {
    public CustomerDto customerEntityToDto(CustomerEntity customerEntity) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customerEntity.getId());
        customerDto.setName(customerEntity.getName());
        customerDto.setAddress(customerEntity.getAddress());
        customerDto.setEmail(customerEntity.getEmail());
        return customerDto;
    }

    public CustomerEntity customerDtoToEntity(CustomerDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerDto.getId());
        customerEntity.setName(customerDto.getName());
        customerEntity.setAddress(customerDto.getAddress());
        customerEntity.setEmail(customerDto.getEmail());
        return customerEntity;
    }
}

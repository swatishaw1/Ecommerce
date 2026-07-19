package com.ecommerce.ECommerceBackend.Payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    public String message;
    private boolean status;
}
/*This is the Structure for How we Get the Exceptions*/
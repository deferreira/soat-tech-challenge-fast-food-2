package com.postechfiap_group130.techchallenge_fastfood.core.usecases;

import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.request.UpdateProductRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.core.domainExceptions.InvalidPropertyProductException;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Product;
import com.postechfiap_group130.techchallenge_fastfood.core.gateways.ProductGateway;

public class UpdateProductUseCase {
     private final ProductGateway productGateway;

    public UpdateProductUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public Product execute(UpdateProductRequestDto productRequestDto) throws InvalidPropertyProductException{
        Product product = new Product(productRequestDto.getId(), 
                                      productRequestDto.getName(), 
                                      productRequestDto.getDescription(), 
                                      productRequestDto.getPrice(), 
                                      productRequestDto.getCategory(),
                                      productRequestDto.getAvaliable());
        product.Validate();
        product = productGateway.updateProduct(product);
        return product;
    }
}

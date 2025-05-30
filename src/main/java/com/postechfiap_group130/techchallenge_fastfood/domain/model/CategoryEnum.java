package com.postechfiap_group130.techchallenge_fastfood.domain.model;

public class CategoryEnum {
    
    public enum Category {
        LANCHE,
        BEBIDA,
        ACOMPANHAMENTO,
        SOBREMESA;

        private Category category;

        public Category getStatus() {
            return category;
        }

        public void setStatus(Category category) {
            this.category = category;
        }
    }
}


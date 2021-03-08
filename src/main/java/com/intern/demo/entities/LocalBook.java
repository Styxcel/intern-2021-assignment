package com.intern.demo.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class LocalBook extends Book{

    private String store;

    public LocalBook(String author, String title, String store) {
        super(author, title);
        this.store = store;
    }
}

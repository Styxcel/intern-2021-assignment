package com.intern.demo.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ImportedBook extends Book{

    private String translator;

    public ImportedBook(String author, String title, String translator) {
        super(author, title);
        this.translator = translator;
    }
}

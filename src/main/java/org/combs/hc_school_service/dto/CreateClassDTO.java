package org.combs.hc_school_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateClassDTO {
    @NotNull(message = "Имя класс обязательно")
    @Size(min = 2, max = 15, message = "Длина имени класса должно быть в районе 2 - 15 символов")
    private String name;

}

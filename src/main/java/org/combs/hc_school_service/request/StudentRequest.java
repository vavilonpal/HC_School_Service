package org.combs.hc_school_service.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.combs.hc_school_service.entity.Class;
import org.combs.hc_school_service.entity.School;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    @NotNull(message = "Введите свой номер или номер родителя")
    @Size(min = 10,max = 20)
    private String phoneNumber;
    @NotNull(message = "Укажите дату рождения")
    private LocalDate birthday;
    @NotNull(message = "Укажите идентификатор школы")
    private School school;
    @NotNull(message = "Укажите идентификатор класса")
    private Class clazz;

}

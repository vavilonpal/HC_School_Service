package org.combs.hc_school_service.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.combs.hc_school_service.entity.Class;
import org.combs.hc_school_service.entity.School;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequest {
    @NotBlank(message = "Заполните это поле")
    @Pattern(regexp = "^(\\+373|0)(6\\d{7}|7\\d{7}|2\\d{7})$")
    private String phoneNumber;
    @NotBlank(message = "Заполните это поле")
    private String speciality;
    @NotBlank(message = "Заполните это поле")
    private LocalDate birthday;
}

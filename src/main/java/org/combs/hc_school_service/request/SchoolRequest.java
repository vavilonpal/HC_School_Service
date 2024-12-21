package org.combs.hc_school_service.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchoolRequest {
    @NotBlank(message = "Заполните это поле")
    private String schoolName;
    @NotBlank(message = "Заполните это поле")
    @Pattern(regexp = "^(\\+373|0)(6\\d{7}|7\\d{7}|2\\d{7})$")
    private String phoneNumber;
    @NotBlank(message = "Заполните это поле")
    private String street;
    private Integer houseNumber;
}

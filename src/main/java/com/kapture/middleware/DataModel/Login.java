package com.kapture.middleware.DataModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @NotNull
    @Size(min = 2, max = 30)
    private String userName;

    @NotNull
    @Min(5)
    private String password;
}


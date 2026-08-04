package com.umar.studentmanagementsystem.DTOS;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Address",
        description = "Address details of the student"
)
public class AddressDTO {

    @Schema(
            description = "6-digit postal PIN code",
            example = "517501",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Pincode is required")
    @Pattern(
            regexp = "^[0-9]{6}$",
            message = "Pincode must contain exactly 6 digits"
    )
    private String pincode;

    @Schema(
            description = "State where the student resides",
            example = "Andhra Pradesh",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "State is required")
    private String state;

    @Schema(
            description = "District where the student resides",
            example = "Chittoor",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "District is required")
    private String district;
}
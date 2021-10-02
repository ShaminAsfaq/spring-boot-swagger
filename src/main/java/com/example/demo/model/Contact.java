package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Contact Details")
public class Contact {
    @ApiModelProperty(notes = "Unique ID of a contact")
    String id;
    @ApiModelProperty(notes = "Name of the contact")
    String name;
    @ApiModelProperty(notes = "Phone number of the contact")
    String phone;
}

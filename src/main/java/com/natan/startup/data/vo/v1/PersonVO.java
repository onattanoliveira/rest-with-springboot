package com.natan.startup.data.vo.v1;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
public class PersonVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    public PersonVO() {};
}

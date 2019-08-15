package com.example.demo.entitys;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class FormDetails implements Serializable {
	private Integer form_details_id;
	private String form_name;
	private String from_details;
}

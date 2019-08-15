package com.example.demo.entitys;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class FormClounmnInfo implements Serializable{
	private Integer form_id;
	private Integer column_id;
	private String column_name;
	private String form_name;
	private String column_type;
}

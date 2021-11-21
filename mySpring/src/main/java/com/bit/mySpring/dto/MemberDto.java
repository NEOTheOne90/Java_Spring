package com.bit.mySpring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*@Getter @Setter*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

	private String id;
	private String pwd;
	private String name;
	private String email;

}

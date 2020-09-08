package com.javaeasy.application.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Biswa.Sahoo
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LimitConfigurationDto implements Serializable {

	private static final long serialVersionUID = -1884297407877378763L;

	private int minimium;

	private int maximium;

}

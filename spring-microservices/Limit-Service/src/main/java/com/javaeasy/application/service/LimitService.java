package com.javaeasy.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaeasy.application.config.LimitServiceAppConfig;
import com.javaeasy.application.dto.LimitConfigurationDto;

/**
 * 
 * @author Biswa.Sahoo
 *
 */
@Service
public class LimitService {

	@Autowired
	private LimitServiceAppConfig limitServiceAppConfig;

	public LimitConfigurationDto getLimitConfigs() {

		LimitConfigurationDto lLimitConfigurationDto = new LimitConfigurationDto(limitServiceAppConfig.getMinimium(),
				limitServiceAppConfig.getMaximium());
		return lLimitConfigurationDto;
	}
}

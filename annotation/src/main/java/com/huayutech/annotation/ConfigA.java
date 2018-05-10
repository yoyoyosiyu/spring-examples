package com.huayutech.annotation;

import com.huayutech.annotation.annotation.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(ComponentA.class)
public class ConfigA {
}

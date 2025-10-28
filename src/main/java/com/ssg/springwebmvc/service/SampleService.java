package com.ssg.springwebmvc.service;

import com.ssg.springwebmvc.dao.SampleDAO;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SampleService {
    private final SampleDAO sampleDAO;
}

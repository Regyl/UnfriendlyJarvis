package com.github.regyl.unfriendlyjarvis.annotation;

import com.github.regyl.unfriendlyjarvis.entity.enums.Source;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SourceSynced {

    Source source();
}

package com.lb.portfolio.api.controller;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Objects;

public abstract class BaseController {

    /**
     * Returns the response with 200 OK if present, or 204 NO CONTENT otherwise.
     */
    <T> ResponseEntity<T> response(T result) {
        if (Objects.isNull(result) || result instanceof Collection<?> && CollectionUtils.isEmpty((Collection<?>) result))
            return ResponseEntity.noContent().build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentLanguage(LocaleContextHolder.getLocale());
        return ResponseEntity.ok().headers(headers).body(result);
    }
}

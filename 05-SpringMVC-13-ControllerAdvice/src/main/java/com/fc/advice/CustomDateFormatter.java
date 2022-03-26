package com.fc.advice;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CustomDateFormatter implements Formatter<Date> {
    String pattern = "yyyy/MM/dd";
    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        if (text.contains("-")) {
            pattern = "yyyy-MM-dd";
        }

        return new SimpleDateFormat(pattern, locale).parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        return new SimpleDateFormat(pattern, locale).format(object);
    }
}

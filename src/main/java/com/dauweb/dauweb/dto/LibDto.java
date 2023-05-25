package com.dauweb.dauweb.dto;

import java.util.List;

public record LibDto(
        String title,
        String subTitle,
        List<String> header,
        List<String> t_body,
        List<String> links
) {


}

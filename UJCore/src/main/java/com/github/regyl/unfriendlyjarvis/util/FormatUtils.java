package com.github.regyl.unfriendlyjarvis.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FormatUtils {

    public String getUrlDomain(String url) {
        if (url.startsWith("http")) {
            url = url.substring(url.indexOf("://") + 3);
        }

        int index = url.indexOf("/");
        if (index != -1) {
            url = url.substring(0, index);
        }
        return url;
    }
}

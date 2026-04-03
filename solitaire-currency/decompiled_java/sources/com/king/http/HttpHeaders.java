package com.king.http;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class HttpHeaders {
    private List<Header> mHeaders = new ArrayList();

    @Keep
    public static class Header {
        public String key;
        public String value;

        public Header(String str) {
            this.key = str;
        }

        public void add(String str) {
            if (this.value != null) {
                str = this.value + ", " + str;
            }
            this.value = str;
        }

        public void set(String str) {
            this.value = str;
        }

        public Header(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    private Header find(String str) {
        for (Header header : this.mHeaders) {
            if (str.equalsIgnoreCase(header.key)) {
                return header;
            }
        }
        return null;
    }

    public void add(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return;
        }
        Header headerFind = find(str);
        if (headerFind == null) {
            this.mHeaders.add(new Header(str, str2));
        } else {
            headerFind.add(str2);
        }
    }

    public Header[] array() {
        List<Header> list = this.mHeaders;
        return (Header[]) list.toArray(new Header[list.size()]);
    }

    public void set(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return;
        }
        Header headerFind = find(str);
        if (headerFind == null) {
            this.mHeaders.add(new Header(str, str2));
        } else {
            headerFind.set(str2);
        }
    }
}

package com.king.usdk.kdid;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class TokenMetaData {
    public final String action;
    public final String key;
    public final List<String> packageNames;
    public final String remoteApp;

    TokenMetaData() {
        this(null, null, null, null);
    }

    TokenMetaData(String str, String str2, String str3, List<String> list) {
        this.key = str;
        this.action = str2;
        this.remoteApp = str3;
        this.packageNames = list;
    }
}

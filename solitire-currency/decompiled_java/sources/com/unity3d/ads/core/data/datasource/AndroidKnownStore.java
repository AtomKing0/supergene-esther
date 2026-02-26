package com.unity3d.ads.core.data.datasource;

import com.ironsource.un;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidKnownStore.kt */
/* JADX INFO: loaded from: classes4.dex */
public enum AndroidKnownStore {
    GOOGLE("com.android.vending"),
    GOOGLE_MARKET(un.f15599a),
    AMAZON("com.amazon.venezia"),
    SAMSUNG("com.sec.android.app.samsungapps"),
    XIAOMI("com.xiaomi.market"),
    HUAWEI("com.huawei.appmarket"),
    OPPO("com.oppo.market"),
    VIVO("com.bbk.appstore"),
    UNKNOWN("unknown");


    @NotNull
    private final String packageName;

    AndroidKnownStore(String str) {
        this.packageName = str;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }
}

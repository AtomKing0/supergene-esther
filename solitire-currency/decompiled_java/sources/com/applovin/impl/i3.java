package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.mediation.MaxAdFormat;

/* JADX INFO: loaded from: classes2.dex */
public class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f5373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5374b;

    public enum a {
        AD_UNIT_ID,
        AD_FORMAT,
        AD
    }

    private i3(a aVar, String str) {
        this.f5373a = aVar;
        this.f5374b = str;
    }

    public a a() {
        return this.f5373a;
    }

    public String b() {
        return this.f5374b;
    }

    public static i3 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new i3(a.AD_UNIT_ID, str);
    }

    public static i3 a(MaxAdFormat maxAdFormat) {
        String label = maxAdFormat.getLabel();
        if (TextUtils.isEmpty(label)) {
            return null;
        }
        return new i3(a.AD_FORMAT, label);
    }

    public static i3 a(q2 q2Var) {
        String strN = q2Var.N();
        if (TextUtils.isEmpty(strN)) {
            return null;
        }
        return new i3(a.AD, strN);
    }
}

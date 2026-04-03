package com.ironsource.sdk.utils;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class IronSourceQaProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static IronSourceQaProperties f15296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, String> f15297b = new HashMap();

    private IronSourceQaProperties() {
    }

    public static IronSourceQaProperties getInstance() {
        if (f15296a == null) {
            f15296a = new IronSourceQaProperties();
        }
        return f15296a;
    }

    public static boolean isInitialized() {
        return f15296a != null;
    }

    public Map<String, String> getParameters() {
        return f15297b;
    }

    public void setQaParameter(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        f15297b.put(str, str2);
    }
}

package com.facebook.ads.redexgen.core;

import java.lang.reflect.Proxy;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1950Qw {
    public static <T> T A00(T impl, Class<T> clazz) {
        ClassLoader classLoader = impl.getClass().getClassLoader();
        return clazz.cast(Proxy.newProxyInstance(classLoader, new Class[]{clazz}, new C1949Qv(impl, classLoader)));
    }
}

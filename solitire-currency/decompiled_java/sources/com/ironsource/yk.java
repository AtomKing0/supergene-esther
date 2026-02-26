package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class yk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f16332d;

    public yk(@NotNull JSONObject applicationLogger) {
        kotlin.jvm.internal.t.i(applicationLogger, "applicationLogger");
        this.f16329a = applicationLogger.optInt(zk.f16431a, 3);
        this.f16330b = applicationLogger.optInt(zk.f16432b, 3);
        this.f16331c = applicationLogger.optInt("console", 3);
        this.f16332d = applicationLogger.optBoolean(zk.f16434d, false);
    }

    public final int a() {
        return this.f16331c;
    }

    public final int b() {
        return this.f16330b;
    }

    public final int c() {
        return this.f16329a;
    }

    public final boolean d() {
        return this.f16332d;
    }
}

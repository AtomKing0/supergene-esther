package com.moloco.sdk.acm;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    @NotNull
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<d> f17318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f17319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17320c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public c(@NotNull String eventName) {
        t.i(eventName, "eventName");
        this.f17318a = new ArrayList();
        this.f17319b = eventName;
        this.f17320c = 1;
    }

    public final int a() {
        return this.f17320c;
    }

    @NotNull
    public List<d> b() {
        return this.f17318a;
    }

    @NotNull
    public String c() {
        return this.f17319b;
    }

    @NotNull
    public c d(@NotNull String key, @NotNull String value) {
        t.i(key, "key");
        t.i(value, "value");
        if (b().size() < 10 && key.length() <= 50 && value.length() <= 50) {
            b().add(new d(key, value));
        }
        return this;
    }
}

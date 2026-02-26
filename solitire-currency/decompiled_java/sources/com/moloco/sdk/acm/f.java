package com.moloco.sdk.acm;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    @NotNull
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final com.moloco.sdk.acm.services.f f17420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f17421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<d> f17422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final String f17423d;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final f a(@NotNull String eventName) {
            t.i(eventName, "eventName");
            return new f(eventName, new com.moloco.sdk.acm.services.f(new com.moloco.sdk.acm.services.h()), null);
        }

        public a() {
        }
    }

    public /* synthetic */ f(String str, com.moloco.sdk.acm.services.f fVar, kotlin.jvm.internal.k kVar) {
        this(str, fVar);
    }

    @NotNull
    public List<d> a() {
        return this.f17422c;
    }

    @NotNull
    public String b() {
        return this.f17423d;
    }

    public final long c() {
        return this.f17421b;
    }

    public final void d() {
        this.f17420a.b();
    }

    public final void e() {
        if (this.f17421b == 0) {
            this.f17421b = this.f17420a.a();
        }
    }

    @NotNull
    public f f(@NotNull String key, @NotNull String value) {
        t.i(key, "key");
        t.i(value, "value");
        if (a().size() < 10 && key.length() <= 50 && value.length() <= 50) {
            a().add(new d(key, value));
        }
        return this;
    }

    private f(String str, com.moloco.sdk.acm.services.f fVar) {
        this.f17420a = fVar;
        this.f17422c = new ArrayList();
        this.f17423d = str;
    }
}

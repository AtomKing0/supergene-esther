package com.moloco.sdk.acm.http;

import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.l;
import v8.n;
import y7.g0;
import y7.y;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f17441a = n.a(a.f17442g);

    public static final class a extends v implements h9.a<s7.a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f17442g = new a();

        /* JADX INFO: renamed from: com.moloco.sdk.acm.http.c$a$a, reason: collision with other inner class name */
        public static final class C0292a extends v implements h9.l<s7.b<?>, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0292a f17443g = new C0292a();

            public C0292a() {
                super(1);
            }

            public final void a(@NotNull s7.b<?> HttpClient) {
                t.i(HttpClient, "$this$HttpClient");
                s7.b.j(HttpClient, g0.f36694b, null, 2, null);
                s7.b.j(HttpClient, y.f36881d, null, 2, null);
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(s7.b<?> bVar) {
                a(bVar);
                return k0.f35197a;
            }
        }

        public a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final s7.a invoke() {
            return s7.d.a(C0292a.f17443g);
        }
    }

    public static final s7.a a() {
        return (s7.a) f17441a.getValue();
    }

    @NotNull
    public static final s7.a b() {
        return a();
    }
}

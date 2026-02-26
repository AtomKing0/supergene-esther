package com.moloco.sdk.internal;

import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v8.l f17815a = v8.n.a(a.f17816g);

    public static final class a extends kotlin.jvm.internal.v implements h9.a<kotlinx.serialization.json.a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f17816g = new a();

        /* JADX INFO: renamed from: com.moloco.sdk.internal.p$a$a, reason: collision with other inner class name */
        public static final class C0309a extends kotlin.jvm.internal.v implements h9.l<kotlinx.serialization.json.c, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0309a f17817g = new C0309a();

            public C0309a() {
                super(1);
            }

            public final void a(@NotNull kotlinx.serialization.json.c Json) {
                kotlin.jvm.internal.t.i(Json, "$this$Json");
                Json.g(true);
                Json.f(true);
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(kotlinx.serialization.json.c cVar) {
                a(cVar);
                return k0.f35197a;
            }
        }

        public a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlinx.serialization.json.a invoke() {
            return kotlinx.serialization.json.m.b(null, C0309a.f17817g, 1, null);
        }
    }

    @NotNull
    public static final kotlinx.serialization.json.a a() {
        return b();
    }

    public static final kotlinx.serialization.json.a b() {
        return (kotlinx.serialization.json.a) f17815a.getValue();
    }
}

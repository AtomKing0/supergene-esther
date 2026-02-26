package com.vungle.ads.internal.network.converters;

import ga.e0;
import h9.l;
import java.io.IOException;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlin.reflect.KType;
import kotlinx.serialization.json.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: JsonConverter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c<E> implements com.vungle.ads.internal.network.converters.a<e0, E> {

    @NotNull
    public static final b Companion = new b(null);

    @NotNull
    private static final kotlinx.serialization.json.a json = m.b(null, a.INSTANCE, 1, null);

    @NotNull
    private final KType kType;

    /* JADX INFO: compiled from: JsonConverter.kt */
    static final class a extends v implements l<kotlinx.serialization.json.c, k0> {
        public static final a INSTANCE = new a();

        a() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(kotlinx.serialization.json.c cVar) {
            invoke2(cVar);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull kotlinx.serialization.json.c Json) {
            t.i(Json, "$this$Json");
            Json.f(true);
            Json.d(true);
            Json.e(false);
            Json.c(true);
        }
    }

    /* JADX INFO: compiled from: JsonConverter.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k kVar) {
            this();
        }
    }

    public c(@NotNull KType kType) {
        t.i(kType, "kType");
        this.kType = kType;
    }

    @Override // com.vungle.ads.internal.network.converters.a
    @Nullable
    public E convert(@Nullable e0 e0Var) throws IOException {
        if (e0Var != null) {
            try {
                String strString = e0Var.string();
                if (strString != null) {
                    E e10 = (E) json.b(z9.l.b(kotlinx.serialization.json.a.f30033d.a(), this.kType), strString);
                    f9.c.a(e0Var, null);
                    return e10;
                }
            } finally {
            }
        }
        f9.c.a(e0Var, null);
        return null;
    }
}

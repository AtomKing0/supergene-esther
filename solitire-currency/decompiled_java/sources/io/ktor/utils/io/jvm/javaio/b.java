package io.ktor.utils.io.jvm.javaio;

import java.io.InputStream;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: Blocking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final l f26891a = n.a(a.f26894g);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Object f26892b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Object f26893c = new Object();

    /* JADX INFO: compiled from: Blocking.kt */
    static final class a extends v implements h9.a<xa.a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f26894g = new a();

        a() {
            super(0);
        }

        @Override // h9.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final xa.a invoke() {
            return xa.b.i(io.ktor.utils.io.jvm.javaio.a.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xa.a b() {
        return (xa.a) f26891a.getValue();
    }

    @NotNull
    public static final InputStream c(@NotNull io.ktor.utils.io.g gVar, @Nullable b2 b2Var) {
        t.i(gVar, "<this>");
        return new d(b2Var, gVar);
    }
}

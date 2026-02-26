package com.moloco.sdk.internal.ortb;

import com.moloco.sdk.internal.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.l;
import v8.n;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f17675a = n.a(a.f17676g);

    public static final class a extends v implements h9.a<b> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f17676g = new a();

        public a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return new b(p.a());
        }
    }

    @NotNull
    public static final com.moloco.sdk.internal.ortb.a a() {
        return b();
    }

    public static final com.moloco.sdk.internal.ortb.a b() {
        return (com.moloco.sdk.internal.ortb.a) f17675a.getValue();
    }
}

package com.moloco.sdk.internal;

import androidx.compose.runtime.internal.StabilityInferred;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public abstract class t<R, E> {

    @StabilityInferred(parameters = 2)
    public static final class a<R, E> extends t<R, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final E f18829a;

        public a(E e10) {
            super(null);
            this.f18829a = e10;
        }

        public final E a() {
            return this.f18829a;
        }
    }

    @StabilityInferred(parameters = 1)
    public static final class b<R, E> extends t<R, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R f18830a;

        public b(R r10) {
            super(null);
            this.f18830a = r10;
        }

        public final R a() {
            return this.f18830a;
        }
    }

    public /* synthetic */ t(kotlin.jvm.internal.k kVar) {
        this();
    }

    public t() {
    }
}

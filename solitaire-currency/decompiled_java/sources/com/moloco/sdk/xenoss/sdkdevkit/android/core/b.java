package com.moloco.sdk.xenoss.sdkdevkit.android.core;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import y7.y;
import y7.z;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    public static final class a extends v implements l<y.a, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f21667g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10) {
            super(1);
            this.f21667g = j10;
        }

        public final void a(@NotNull y.a timeout) {
            t.i(timeout, "$this$timeout");
            timeout.g(Long.valueOf(this.f21667g));
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(y.a aVar) {
            a(aVar);
            return k0.f35197a;
        }
    }

    public static final void a(@NotNull a8.c cVar, long j10) {
        t.i(cVar, "<this>");
        z.e(cVar, new a(j10));
    }
}

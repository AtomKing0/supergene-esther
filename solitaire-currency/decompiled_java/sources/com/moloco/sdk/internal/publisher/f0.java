package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.MolocoInitStatus;
import com.moloco.sdk.publisher.MolocoInitializationListener;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 {

    public static final class a extends kotlin.jvm.internal.v implements h9.a<k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MolocoInitializationListener f17977g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ MolocoInitStatus f17978h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MolocoInitializationListener molocoInitializationListener, MolocoInitStatus molocoInitStatus) {
            super(0);
            this.f17977g = molocoInitializationListener;
            this.f17978h = molocoInitStatus;
        }

        public final void b() {
            this.f17977g.onMolocoInitializationStatus(this.f17978h);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            b();
            return k0.f35197a;
        }
    }

    public static final void a(@NotNull MolocoInitializationListener molocoInitializationListener, @NotNull MolocoInitStatus initStatus) {
        kotlin.jvm.internal.t.i(molocoInitializationListener, "<this>");
        kotlin.jvm.internal.t.i(initStatus, "initStatus");
        com.moloco.sdk.internal.scheduling.e.a(new a(molocoInitializationListener, initStatus));
    }
}

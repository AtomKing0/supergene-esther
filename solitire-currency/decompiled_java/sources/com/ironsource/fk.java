package com.ironsource;

import com.ironsource.gk;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class fk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final hk f12145a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private fk f12146a = new fk(null);

        @NotNull
        public final a a(@NotNull jk listener) {
            kotlin.jvm.internal.t.i(listener, "listener");
            this.f12146a.a(listener);
            return this;
        }

        @NotNull
        public final a b(@NotNull String placementName) {
            kotlin.jvm.internal.t.i(placementName, "placementName");
            this.f12146a.b(placementName);
            return this;
        }

        @NotNull
        public final a a(@NotNull String adUnitId) {
            kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
            this.f12146a.a(adUnitId);
            return this;
        }

        @NotNull
        public final fk a() {
            return this.f12146a;
        }
    }

    private fk() {
        this.f12145a = new hk(this);
    }

    public final void a() {
        this.f12145a.f();
    }

    @Nullable
    public final String b() {
        return this.f12145a.g();
    }

    @Nullable
    public final String c() {
        return this.f12145a.h();
    }

    @Nullable
    public final String d() {
        return this.f12145a.i();
    }

    @Nullable
    public final gk.a e() {
        return this.f12145a.j();
    }

    @Nullable
    public final AdapterNativeAdViewBinder f() {
        return this.f12145a.k();
    }

    @Nullable
    public final String g() {
        return this.f12145a.l();
    }

    public final void h() {
        this.f12145a.m();
    }

    public /* synthetic */ fk(kotlin.jvm.internal.k kVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str) {
        this.f12145a.b(str);
    }

    public final void a(@Nullable jk jkVar) {
        this.f12145a.a(jkVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.f12145a.a(str);
    }
}

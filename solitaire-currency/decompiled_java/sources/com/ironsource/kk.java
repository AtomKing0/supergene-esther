package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class kk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final lk f12878a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private kk f12879a = new kk(null);

        @NotNull
        public final a a(@Nullable mk mkVar) {
            this.f12879a.a(mkVar);
            return this;
        }

        @NotNull
        public final a a(@NotNull String adUnitId) {
            kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
            this.f12879a.a(adUnitId);
            return this;
        }

        @NotNull
        public final kk a() {
            return this.f12879a;
        }
    }

    private kk() {
        this.f12878a = new lk(this);
    }

    @NotNull
    public final String a() {
        return this.f12878a.b();
    }

    public final boolean b() {
        return this.f12878a.e();
    }

    public final void c() {
        this.f12878a.f();
    }

    public /* synthetic */ kk(kotlin.jvm.internal.k kVar) {
        this();
    }

    public final void a(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "activity");
        a(this, activity, null, 2, null);
    }

    public final void a(@NotNull Activity activity, @Nullable String str) {
        kotlin.jvm.internal.t.i(activity, "activity");
        this.f12878a.a(activity, str);
    }

    public static /* synthetic */ void a(kk kkVar, Activity activity, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        kkVar.a(activity, str);
    }

    public final void a(@Nullable ImpressionDataListener impressionDataListener) {
        this.f12878a.a(impressionDataListener);
    }

    public final void a(@Nullable mk mkVar) {
        this.f12878a.a(mkVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.f12878a.a(str);
    }
}

package com.moloco.sdk.internal.publisher;

import androidx.annotation.VisibleForTesting;
import com.moloco.sdk.publisher.AdShowListener;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting(otherwise = 2)
public final class c0<T extends AdShowListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> f17892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.internal.ortb.model.q f17893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public r f17894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public b2 f17895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public h0 f17896e;

    public c0(@Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> jVar, @Nullable com.moloco.sdk.internal.ortb.model.q qVar, @Nullable r rVar, @Nullable b2 b2Var, @Nullable h0 h0Var) {
        this.f17892a = jVar;
        this.f17893b = qVar;
        this.f17894c = rVar;
        this.f17895d = b2Var;
        this.f17896e = h0Var;
    }

    @Nullable
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> a() {
        return this.f17892a;
    }

    public final void b(@Nullable com.moloco.sdk.internal.ortb.model.q qVar) {
        this.f17893b = qVar;
    }

    public final void c(@Nullable r rVar) {
        this.f17894c = rVar;
    }

    public final void d(@Nullable h0 h0Var) {
        this.f17896e = h0Var;
    }

    public final void e(@Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> jVar) {
        this.f17892a = jVar;
    }

    public final void f(@Nullable b2 b2Var) {
        this.f17895d = b2Var;
    }

    @Nullable
    public final b2 g() {
        return this.f17895d;
    }

    @Nullable
    public final r h() {
        return this.f17894c;
    }

    @Nullable
    public final h0 i() {
        return this.f17896e;
    }

    @Nullable
    public final com.moloco.sdk.internal.ortb.model.q j() {
        return this.f17893b;
    }

    public /* synthetic */ c0(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j jVar, com.moloco.sdk.internal.ortb.model.q qVar, r rVar, b2 b2Var, h0 h0Var, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : jVar, (i10 & 2) != 0 ? null : qVar, (i10 & 4) != 0 ? null : rVar, (i10 & 8) != 0 ? null : b2Var, (i10 & 16) != 0 ? null : h0Var);
    }
}

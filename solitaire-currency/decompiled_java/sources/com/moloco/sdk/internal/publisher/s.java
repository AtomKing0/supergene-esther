package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class s<L extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u<L> f18271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.internal.ortb.model.q f18272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public r f18273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public b2 f18274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public String f18275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public String f18276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18277g;

    public s(@Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u<L> uVar, @Nullable com.moloco.sdk.internal.ortb.model.q qVar, @Nullable r rVar, @Nullable b2 b2Var, @Nullable String str, @Nullable String str2, boolean z10) {
        this.f18271a = uVar;
        this.f18272b = qVar;
        this.f18273c = rVar;
        this.f18274d = b2Var;
        this.f18275e = str;
        this.f18276f = str2;
        this.f18277g = z10;
    }

    @Nullable
    public final b2 a() {
        return this.f18274d;
    }

    public final void b(@Nullable com.moloco.sdk.internal.ortb.model.q qVar) {
        this.f18272b = qVar;
    }

    public final void c(@Nullable r rVar) {
        this.f18273c = rVar;
    }

    public final void d(@Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u<L> uVar) {
        this.f18271a = uVar;
    }

    public final void e(@Nullable String str) {
        this.f18276f = str;
    }

    public final void f(@Nullable b2 b2Var) {
        this.f18274d = b2Var;
    }

    public final void g(boolean z10) {
        this.f18277g = z10;
    }

    @Nullable
    public final r h() {
        return this.f18273c;
    }

    public final void i(@Nullable String str) {
        this.f18275e = str;
    }

    @Nullable
    public final String j() {
        return this.f18276f;
    }

    @Nullable
    public final String k() {
        return this.f18275e;
    }

    @Nullable
    public final com.moloco.sdk.internal.ortb.model.q l() {
        return this.f18272b;
    }

    @Nullable
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u<L> m() {
        return this.f18271a;
    }

    public final boolean n() {
        return this.f18277g;
    }

    public /* synthetic */ s(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u uVar, com.moloco.sdk.internal.ortb.model.q qVar, r rVar, b2 b2Var, String str, String str2, boolean z10, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : uVar, (i10 & 2) != 0 ? null : qVar, (i10 & 4) != 0 ? null : rVar, (i10 & 8) != 0 ? null : b2Var, (i10 & 16) != 0 ? null : str, (i10 & 32) == 0 ? str2 : null, (i10 & 64) != 0 ? false : z10);
    }
}

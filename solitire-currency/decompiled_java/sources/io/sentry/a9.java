package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TransactionOptions.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a9 extends p8 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f26986g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f26987h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Long f26988i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private Long f26989j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private z8 f26990k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @ApiStatus.Internal
    @Nullable
    private o1 f26991l = null;

    @Nullable
    public l j() {
        return null;
    }

    @ApiStatus.Internal
    @Nullable
    public Long k() {
        return this.f26989j;
    }

    @Nullable
    public Long l() {
        return this.f26988i;
    }

    @ApiStatus.Internal
    @Nullable
    public o1 m() {
        return this.f26991l;
    }

    @Nullable
    public z8 n() {
        return this.f26990k;
    }

    @ApiStatus.Internal
    public boolean o() {
        return this.f26986g;
    }

    public boolean p() {
        return f4.ON == b();
    }

    public boolean q() {
        return this.f26987h;
    }

    @ApiStatus.Internal
    public void r(boolean z10) {
        this.f26986g = z10;
    }

    @ApiStatus.Internal
    public void s(@Nullable Long l10) {
        this.f26989j = l10;
    }

    public void t(@Nullable Long l10) {
        this.f26988i = l10;
    }

    public void u(@Nullable z8 z8Var) {
        this.f26990k = z8Var;
    }

    public void v(boolean z10) {
        this.f26987h = z10;
    }
}

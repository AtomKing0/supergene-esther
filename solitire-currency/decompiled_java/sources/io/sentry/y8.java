package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TransactionContext.java */
/* JADX INFO: loaded from: classes5.dex */
public final class y8 extends j8 {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NotNull
    private static final TransactionNameSource f28515r = TransactionNameSource.CUSTOM;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private String f28516n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private TransactionNameSource f28517o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private x8 f28518p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f28519q;

    public y8(@NotNull String str, @NotNull String str2) {
        this(str, str2, (x8) null);
    }

    @ApiStatus.Internal
    public static y8 v(@NotNull z3 z3Var) {
        Boolean boolI = z3Var.i();
        d dVarD = z3Var.d();
        return new y8(z3Var.h(), z3Var.g(), z3Var.e(), boolI == null ? null : new x8(boolI, dVarD.o(), z3Var.f()), dVarD);
    }

    @NotNull
    public String w() {
        return this.f28516n;
    }

    @Nullable
    public x8 x() {
        return this.f28518p;
    }

    @NotNull
    public TransactionNameSource y() {
        return this.f28517o;
    }

    @ApiStatus.Internal
    public void z(boolean z10) {
        this.f28519q = z10;
    }

    @ApiStatus.Internal
    public y8(@NotNull String str, @NotNull TransactionNameSource transactionNameSource, @NotNull String str2) {
        this(str, transactionNameSource, str2, null);
    }

    public y8(@NotNull String str, @NotNull String str2, @Nullable x8 x8Var) {
        this(str, TransactionNameSource.CUSTOM, str2, x8Var);
    }

    @ApiStatus.Internal
    public y8(@NotNull String str, @NotNull TransactionNameSource transactionNameSource, @NotNull String str2, @Nullable x8 x8Var) {
        super(str2);
        this.f28519q = false;
        this.f28516n = (String) io.sentry.util.w.c(str, "name is required");
        this.f28517o = transactionNameSource;
        s(x8Var);
        this.f27957m = io.sentry.util.k0.g(null, x8Var);
    }

    @ApiStatus.Internal
    public y8(@NotNull SentryId sentryId, @NotNull o8 o8Var, @Nullable o8 o8Var2, @Nullable x8 x8Var, @Nullable d dVar) {
        super(sentryId, o8Var, "default", o8Var2, null);
        this.f28519q = false;
        this.f28516n = "<unlabeled transaction>";
        this.f28518p = x8Var;
        this.f28517o = f28515r;
        this.f27957m = io.sentry.util.k0.g(dVar, x8Var);
    }
}

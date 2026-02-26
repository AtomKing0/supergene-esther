package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.TransactionNameSource;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NoOpTransaction.java */
/* JADX INFO: loaded from: classes5.dex */
public final class g3 implements p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g3 f27825a = new g3();

    private g3() {
    }

    public static g3 v() {
        return f27825a;
    }

    @Override // io.sentry.n1
    @NotNull
    public u7 a() {
        return new u7(SentryId.EMPTY_ID, o8.f28034b, Boolean.FALSE);
    }

    @Override // io.sentry.n1
    @Nullable
    public Boolean d() {
        return null;
    }

    @Override // io.sentry.n1
    public boolean g() {
        return true;
    }

    @Override // io.sentry.n1
    @Nullable
    public String getDescription() {
        return null;
    }

    @Override // io.sentry.p1
    @NotNull
    public SentryId getEventId() {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.p1
    @NotNull
    public String getName() {
        return "";
    }

    @Override // io.sentry.n1
    @Nullable
    public q8 getStatus() {
        return null;
    }

    @Override // io.sentry.n1
    @NotNull
    public k1 h() {
        return w2.a();
    }

    @Override // io.sentry.n1
    @NotNull
    public v8 i() {
        return new v8(SentryId.EMPTY_ID, "");
    }

    @Override // io.sentry.n1
    public boolean isFinished() {
        return true;
    }

    @Override // io.sentry.n1
    @Nullable
    public e l(@Nullable List<String> list) {
        return null;
    }

    @Override // io.sentry.n1
    @NotNull
    public n1 m(@NotNull String str, @Nullable String str2, @Nullable n5 n5Var, @NotNull u1 u1Var) {
        return e3.v();
    }

    @Override // io.sentry.p1
    @Nullable
    public n1 o() {
        return null;
    }

    @Override // io.sentry.n1
    @NotNull
    public n1 p(@NotNull String str, @Nullable String str2, @Nullable n5 n5Var, @NotNull u1 u1Var, @NotNull p8 p8Var) {
        return e3.v();
    }

    @Override // io.sentry.n1
    @NotNull
    public j8 r() {
        return new j8(SentryId.EMPTY_ID, o8.f28034b, SentrySpan.JsonKeys.OP, null, null);
    }

    @Override // io.sentry.n1
    @NotNull
    public n5 s() {
        return new i7();
    }

    @Override // io.sentry.n1
    @NotNull
    public n5 u() {
        return new i7();
    }

    @Override // io.sentry.n1
    public void finish() {
    }

    @Override // io.sentry.p1
    public void q() {
    }

    @Override // io.sentry.n1
    public void e(@Nullable String str) {
    }

    @Override // io.sentry.n1
    public void k(@Nullable q8 q8Var) {
    }

    @Override // io.sentry.p1
    @ApiStatus.Internal
    public void c(@NotNull String str, @NotNull TransactionNameSource transactionNameSource) {
    }

    @Override // io.sentry.n1
    public void f(@NotNull String str, @NotNull Number number) {
    }

    @Override // io.sentry.n1
    public void j(@Nullable String str, @Nullable Object obj) {
    }

    @Override // io.sentry.n1
    public void t(@Nullable q8 q8Var, @Nullable n5 n5Var) {
    }

    @Override // io.sentry.p1
    public void b(@NotNull q8 q8Var, boolean z10, @Nullable l0 l0Var) {
    }

    @Override // io.sentry.n1
    public void n(@NotNull String str, @NotNull Number number, @NotNull l2 l2Var) {
    }
}

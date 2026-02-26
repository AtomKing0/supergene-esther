package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentrySpan;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NoOpSpan.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e3 implements n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e3 f27774a = new e3();

    private e3() {
    }

    public static e3 v() {
        return f27774a;
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

    @Override // io.sentry.n1
    @Nullable
    public q8 getStatus() {
        return null;
    }

    @Override // io.sentry.n1
    public boolean isFinished() {
        return false;
    }

    @Override // io.sentry.n1
    @Nullable
    public e l(@Nullable List<String> list) {
        return null;
    }

    @Override // io.sentry.n1
    @NotNull
    public n1 m(@NotNull String str, @Nullable String str2, @Nullable n5 n5Var, @NotNull u1 u1Var) {
        return v();
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

    @Override // io.sentry.n1
    public void e(@Nullable String str) {
    }

    @Override // io.sentry.n1
    public void k(@Nullable q8 q8Var) {
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

    @Override // io.sentry.n1
    public void n(@NotNull String str, @NotNull Number number, @NotNull l2 l2Var) {
    }
}

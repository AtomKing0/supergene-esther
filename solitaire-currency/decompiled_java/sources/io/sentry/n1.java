package io.sentry;

import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ISpan.java */
/* JADX INFO: loaded from: classes5.dex */
public interface n1 {
    @NotNull
    u7 a();

    @Nullable
    Boolean d();

    void e(@Nullable String str);

    void f(@NotNull String str, @NotNull Number number);

    void finish();

    @ApiStatus.Internal
    boolean g();

    @Nullable
    String getDescription();

    @Nullable
    q8 getStatus();

    @ApiStatus.Internal
    @NotNull
    k1 h();

    @ApiStatus.Experimental
    @Nullable
    v8 i();

    boolean isFinished();

    void j(@Nullable String str, @Nullable Object obj);

    void k(@Nullable q8 q8Var);

    @ApiStatus.Experimental
    @Nullable
    e l(@Nullable List<String> list);

    @ApiStatus.Internal
    @NotNull
    n1 m(@NotNull String str, @Nullable String str2, @Nullable n5 n5Var, @NotNull u1 u1Var);

    void n(@NotNull String str, @NotNull Number number, @NotNull l2 l2Var);

    @ApiStatus.Internal
    @NotNull
    n1 p(@NotNull String str, @Nullable String str2, @Nullable n5 n5Var, @NotNull u1 u1Var, @NotNull p8 p8Var);

    @NotNull
    j8 r();

    @ApiStatus.Internal
    @Nullable
    n5 s();

    void t(@Nullable q8 q8Var, @Nullable n5 n5Var);

    @ApiStatus.Internal
    @NotNull
    n5 u();
}

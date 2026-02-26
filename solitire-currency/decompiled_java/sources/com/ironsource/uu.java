package com.ironsource;

import com.ironsource.k7;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class uu<Smash extends k7<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final vu<Smash> f15622a;

    public uu(@NotNull vu<Smash> smashPicker) {
        kotlin.jvm.internal.t.i(smashPicker, "smashPicker");
        this.f15622a = smashPicker;
    }

    @NotNull
    public final List<Smash> a() {
        return this.f15622a.c();
    }

    public final boolean b() {
        return this.f15622a.c().isEmpty() && this.f15622a.a().isEmpty();
    }

    public final boolean c() {
        return this.f15622a.d() == 0;
    }
}

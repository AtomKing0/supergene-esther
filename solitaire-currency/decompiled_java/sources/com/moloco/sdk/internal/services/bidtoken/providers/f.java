package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.services.i0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final i0 f18498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Integer f18499b;

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    public final Integer a() {
        return this.f18499b;
    }

    @Nullable
    public final i0 b() {
        return this.f18498a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f18498a == fVar.f18498a && kotlin.jvm.internal.t.d(this.f18499b, fVar.f18499b);
    }

    public int hashCode() {
        i0 i0Var = this.f18498a;
        int iHashCode = (i0Var == null ? 0 : i0Var.hashCode()) * 31;
        Integer num = this.f18499b;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AudioSignal(muteSwitchState=" + this.f18498a + ", mediaVolume=" + this.f18499b + ')';
    }

    public f(@Nullable i0 i0Var, @Nullable Integer num) {
        this.f18498a = i0Var;
        this.f18499b = num;
    }

    public /* synthetic */ f(i0 i0Var, Integer num, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : i0Var, (i10 & 2) != 0 ? null : num);
    }
}

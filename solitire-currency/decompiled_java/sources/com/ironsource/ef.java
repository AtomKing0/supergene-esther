package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ef extends Throwable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final IronSourceError f11915a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ef(@NotNull IronSourceError error) {
        super(error.getErrorMessage());
        kotlin.jvm.internal.t.i(error, "error");
        this.f11915a = error;
    }

    @NotNull
    public final IronSourceError a() {
        return this.f11915a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !kotlin.jvm.internal.t.d(ef.class, obj.getClass())) {
            return false;
        }
        ef efVar = (ef) obj;
        if (this.f11915a.getErrorCode() != efVar.f11915a.getErrorCode()) {
            return false;
        }
        return kotlin.jvm.internal.t.d(this.f11915a.getErrorMessage(), efVar.f11915a.getErrorMessage());
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f11915a.getErrorCode()), this.f11915a.getErrorMessage());
    }
}

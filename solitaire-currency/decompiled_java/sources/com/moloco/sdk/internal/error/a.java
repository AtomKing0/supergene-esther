package com.moloco.sdk.internal.error;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f17623a;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Nullable
    public final String a() {
        return this.f17623a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && t.d(this.f17623a, ((a) obj).f17623a);
    }

    public int hashCode() {
        String str = this.f17623a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "ErrorMetadata(mtid=" + this.f17623a + ')';
    }

    public a(@Nullable String str) {
        this.f17623a = str;
    }

    public /* synthetic */ a(String str, int i10, k kVar) {
        this((i10 & 1) != 0 ? null : str);
    }
}

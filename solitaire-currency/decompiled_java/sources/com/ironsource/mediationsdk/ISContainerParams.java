package com.ironsource.mediationsdk;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ISContainerParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13248b;

    public ISContainerParams(int i10, int i11) {
        this.f13247a = i10;
        this.f13248b = i11;
    }

    public static /* synthetic */ ISContainerParams copy$default(ISContainerParams iSContainerParams, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = iSContainerParams.f13247a;
        }
        if ((i12 & 2) != 0) {
            i11 = iSContainerParams.f13248b;
        }
        return iSContainerParams.copy(i10, i11);
    }

    public final int component1() {
        return this.f13247a;
    }

    public final int component2() {
        return this.f13248b;
    }

    @NotNull
    public final ISContainerParams copy(int i10, int i11) {
        return new ISContainerParams(i10, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ISContainerParams)) {
            return false;
        }
        ISContainerParams iSContainerParams = (ISContainerParams) obj;
        return this.f13247a == iSContainerParams.f13247a && this.f13248b == iSContainerParams.f13248b;
    }

    public final int getHeight() {
        return this.f13248b;
    }

    public final int getWidth() {
        return this.f13247a;
    }

    public int hashCode() {
        return (this.f13247a * 31) + this.f13248b;
    }

    @NotNull
    public String toString() {
        return "ISContainerParams(width=" + this.f13247a + ", height=" + this.f13248b + ')';
    }
}

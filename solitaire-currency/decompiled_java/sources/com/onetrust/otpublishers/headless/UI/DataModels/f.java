package com.onetrust.otpublishers.headless.UI.DataModels;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f22090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f22091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f22092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final g f22093d;

    public f(@NotNull String id, @NotNull String name, @Nullable String str, @NotNull g consentState) {
        t.i(id, "id");
        t.i(name, "name");
        t.i(consentState, "consentState");
        this.f22090a = id;
        this.f22091b = name;
        this.f22092c = str;
        this.f22093d = consentState;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return t.d(this.f22090a, fVar.f22090a) && t.d(this.f22091b, fVar.f22091b) && t.d(this.f22092c, fVar.f22092c) && this.f22093d == fVar.f22093d;
    }

    public final int hashCode() {
        int iHashCode = (this.f22091b.hashCode() + (this.f22090a.hashCode() * 31)) * 31;
        String str = this.f22092c;
        return this.f22093d.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    @NotNull
    public final String toString() {
        return "SDKItem(id=" + this.f22090a + ", name=" + this.f22091b + ", description=" + this.f22092c + ", consentState=" + this.f22093d + ')';
    }
}

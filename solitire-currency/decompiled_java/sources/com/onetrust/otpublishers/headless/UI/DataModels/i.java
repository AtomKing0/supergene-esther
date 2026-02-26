package com.onetrust.otpublishers.headless.UI.DataModels;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f22114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f22115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public k f22116c;

    public i(@NotNull String id, @NotNull String name, @NotNull k consentState) {
        t.i(id, "id");
        t.i(name, "name");
        t.i(consentState, "consentState");
        this.f22114a = id;
        this.f22115b = name;
        this.f22116c = consentState;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return t.d(this.f22114a, iVar.f22114a) && t.d(this.f22115b, iVar.f22115b) && this.f22116c == iVar.f22116c;
    }

    public final int hashCode() {
        return this.f22116c.hashCode() + ((this.f22115b.hashCode() + (this.f22114a.hashCode() * 31)) * 31);
    }

    @NotNull
    public final String toString() {
        return "VendorItem(id=" + this.f22114a + ", name=" + this.f22115b + ", consentState=" + this.f22116c + ')';
    }
}

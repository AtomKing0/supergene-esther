package com.onetrust.otpublishers.headless.UI.UIProperty;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22793c;

    @Nullable
    public final String a() {
        String str = this.f22792b;
        if (str == null) {
            return str;
        }
        if ("".equalsIgnoreCase(str.trim())) {
            return null;
        }
        return this.f22792b;
    }

    public final boolean b() {
        return !String.valueOf(false).equalsIgnoreCase(this.f22791a);
    }

    @NonNull
    public final String toString() {
        return "LogoProperty{show='" + this.f22791a + "', url='" + this.f22792b + "', height='null', width='null', contentDescription='" + this.f22793c + "'}";
    }
}

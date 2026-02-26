package com.onetrust.otpublishers.headless.UI.mobiledatautils;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23602a;

    public a(int i10) {
        this.f23602a = i10;
    }

    @NonNull
    public final String a(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        return !com.onetrust.otpublishers.headless.Internal.c.q(str) ? str : !com.onetrust.otpublishers.headless.Internal.c.q(str2) ? str2 : this.f23602a == 11 ? str4 : str3;
    }
}

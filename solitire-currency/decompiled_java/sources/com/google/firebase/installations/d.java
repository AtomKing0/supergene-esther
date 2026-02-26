package com.google.firebase.installations;

import androidx.annotation.NonNull;
import i5.j;

/* JADX INFO: compiled from: FirebaseInstallationsException.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final a f10316a;

    /* JADX INFO: compiled from: FirebaseInstallationsException.java */
    public enum a {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public d(@NonNull a aVar) {
        this.f10316a = aVar;
    }

    public d(@NonNull String str, @NonNull a aVar) {
        super(str);
        this.f10316a = aVar;
    }
}

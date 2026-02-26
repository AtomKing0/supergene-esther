package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.installations.a;

/* JADX INFO: compiled from: InstallationTokenResult.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class g {

    /* JADX INFO: compiled from: InstallationTokenResult.java */
    @AutoValue.Builder
    public static abstract class a {
        @NonNull
        public abstract g a();

        @NonNull
        public abstract a b(@NonNull String str);

        @NonNull
        public abstract a c(long j10);

        @NonNull
        public abstract a d(long j10);
    }

    @NonNull
    public static a a() {
        return new a.b();
    }

    @NonNull
    public abstract String b();

    @NonNull
    public abstract long c();

    @NonNull
    public abstract long d();
}

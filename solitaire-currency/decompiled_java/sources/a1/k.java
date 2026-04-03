package a1;

import android.content.Context;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
import r0.l;
import u0.v;

/* JADX INFO: compiled from: UnitTransformation.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k<T> implements l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final l<?> f82b = new k();

    private k() {
    }

    @NonNull
    public static <T> k<T> c() {
        return (k) f82b;
    }

    @Override // r0.f
    public void b(@NonNull MessageDigest messageDigest) {
    }

    @Override // r0.l
    @NonNull
    public v<T> a(@NonNull Context context, @NonNull v<T> vVar, int i10, int i11) {
        return vVar;
    }
}

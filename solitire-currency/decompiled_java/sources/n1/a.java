package n1;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import r0.f;

/* JADX INFO: compiled from: EmptySignature.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f31558b = new a();

    private a() {
    }

    @NonNull
    public static a c() {
        return f31558b;
    }

    public String toString() {
        return "EmptySignature";
    }

    @Override // r0.f
    public void b(@NonNull MessageDigest messageDigest) {
    }
}

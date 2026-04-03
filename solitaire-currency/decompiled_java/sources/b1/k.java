package b1;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: CenterInside.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f1842b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(r0.f.f33247a);

    @Override // r0.f
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f1842b);
    }

    @Override // b1.f
    protected Bitmap c(@NonNull v0.d dVar, @NonNull Bitmap bitmap, int i10, int i11) {
        return b0.c(dVar, bitmap, i10, i11);
    }

    @Override // r0.f
    public boolean equals(Object obj) {
        return obj instanceof k;
    }

    @Override // r0.f
    public int hashCode() {
        return -670243078;
    }
}

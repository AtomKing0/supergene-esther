package b1;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: FitCenter.java */
/* JADX INFO: loaded from: classes2.dex */
public class u extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f1877b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(r0.f.f33247a);

    @Override // r0.f
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f1877b);
    }

    @Override // b1.f
    protected Bitmap c(@NonNull v0.d dVar, @NonNull Bitmap bitmap, int i10, int i11) {
        return b0.e(dVar, bitmap, i10, i11);
    }

    @Override // r0.f
    public boolean equals(Object obj) {
        return obj instanceof u;
    }

    @Override // r0.f
    public int hashCode() {
        return 1572326941;
    }
}

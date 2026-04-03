package b1;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: BitmapResource.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements u0.v<Bitmap>, u0.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f1829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v0.d f1830b;

    public e(@NonNull Bitmap bitmap, @NonNull v0.d dVar) {
        this.f1829a = (Bitmap) o1.j.e(bitmap, "Bitmap must not be null");
        this.f1830b = (v0.d) o1.j.e(dVar, "BitmapPool must not be null");
    }

    @Nullable
    public static e c(@Nullable Bitmap bitmap, @NonNull v0.d dVar) {
        if (bitmap == null) {
            return null;
        }
        return new e(bitmap, dVar);
    }

    @Override // u0.v
    @NonNull
    public Class<Bitmap> a() {
        return Bitmap.class;
    }

    @Override // u0.v
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f1829a;
    }

    @Override // u0.v
    public int getSize() {
        return o1.k.g(this.f1829a);
    }

    @Override // u0.r
    public void initialize() {
        this.f1829a.prepareToDraw();
    }

    @Override // u0.v
    public void recycle() {
        this.f1830b.c(this.f1829a);
    }
}

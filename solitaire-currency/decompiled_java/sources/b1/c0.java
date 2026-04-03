package b1;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: UnitBitmapDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements r0.j<Bitmap, Bitmap> {
    @Override // r0.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public u0.v<Bitmap> b(@NonNull Bitmap bitmap, int i10, int i11, @NonNull r0.h hVar) {
        return new a(bitmap);
    }

    @Override // r0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Bitmap bitmap, @NonNull r0.h hVar) {
        return true;
    }

    /* JADX INFO: compiled from: UnitBitmapDecoder.java */
    private static final class a implements u0.v<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bitmap f1827a;

        a(@NonNull Bitmap bitmap) {
            this.f1827a = bitmap;
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
            return this.f1827a;
        }

        @Override // u0.v
        public int getSize() {
            return o1.k.g(this.f1827a);
        }

        @Override // u0.v
        public void recycle() {
        }
    }
}

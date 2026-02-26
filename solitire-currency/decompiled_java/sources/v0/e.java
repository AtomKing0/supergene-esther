package v0;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: BitmapPoolAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements d {
    @Override // v0.d
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // v0.d
    @NonNull
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    @Override // v0.d
    @NonNull
    public Bitmap e(int i10, int i11, Bitmap.Config config) {
        return d(i10, i11, config);
    }

    @Override // v0.d
    public void b() {
    }

    @Override // v0.d
    public void a(int i10) {
    }
}

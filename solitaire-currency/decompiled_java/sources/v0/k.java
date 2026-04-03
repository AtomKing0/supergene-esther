package v0;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: LruPoolStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
interface k {
    String a(Bitmap bitmap);

    String b(int i10, int i11, Bitmap.Config config);

    void c(Bitmap bitmap);

    @Nullable
    Bitmap d(int i10, int i11, Bitmap.Config config);

    int e(Bitmap bitmap);

    @Nullable
    Bitmap removeLast();
}

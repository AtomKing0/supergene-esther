package bo.app;

import android.graphics.Bitmap;
import android.util.LruCache;

/* JADX INFO: loaded from: classes2.dex */
public final class fp extends LruCache {
    public fp(int i10) {
        super(i10);
    }

    @Override // android.util.LruCache
    public final int sizeOf(Object obj, Object obj2) {
        String key = (String) obj;
        Bitmap image = (Bitmap) obj2;
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(image, "image");
        return image.getByteCount();
    }
}

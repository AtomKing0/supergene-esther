package androidx.media3.common.util;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaMetadata;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface BitmapLoader {
    com.google.common.util.concurrent.m<Bitmap> decodeBitmap(byte[] bArr);

    com.google.common.util.concurrent.m<Bitmap> loadBitmap(Uri uri);

    @Nullable
    com.google.common.util.concurrent.m<Bitmap> loadBitmapFromMetadata(MediaMetadata mediaMetadata);

    boolean supportsMimeType(String str);
}

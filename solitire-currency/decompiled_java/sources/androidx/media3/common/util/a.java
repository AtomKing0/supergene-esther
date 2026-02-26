package androidx.media3.common.util;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaMetadata;

/* JADX INFO: compiled from: BitmapLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a {
    @Nullable
    public static com.google.common.util.concurrent.m a(BitmapLoader bitmapLoader, MediaMetadata mediaMetadata) {
        byte[] bArr = mediaMetadata.artworkData;
        if (bArr != null) {
            return bitmapLoader.decodeBitmap(bArr);
        }
        Uri uri = mediaMetadata.artworkUri;
        if (uri != null) {
            return bitmapLoader.loadBitmap(uri);
        }
        return null;
    }
}

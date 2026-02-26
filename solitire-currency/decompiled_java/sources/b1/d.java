package b1;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.ironsource.v8;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.IOException;

/* JADX INFO: compiled from: BitmapImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 28)
public final class d extends a1.i<Bitmap> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v0.d f1828b = new v0.e();

    @Override // a1.i
    protected u0.v<Bitmap> c(ImageDecoder.Source source, int i10, int i11, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + bitmapDecodeBitmap.getWidth() + ViewHierarchyNode.JsonKeys.X + bitmapDecodeBitmap.getHeight() + "] for [" + i10 + ViewHierarchyNode.JsonKeys.X + i11 + v8.i.f15839e);
        }
        return new e(bitmapDecodeBitmap, this.f1828b);
    }
}

package g1;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import r0.h;
import u0.v;

/* JADX INFO: compiled from: BitmapBytesTranscoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements e<Bitmap, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap.CompressFormat f25778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f25779b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // g1.e
    @Nullable
    public v<byte[]> a(@NonNull v<Bitmap> vVar, @NonNull h hVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        vVar.get().compress(this.f25778a, this.f25779b, byteArrayOutputStream);
        vVar.recycle();
        return new c1.b(byteArrayOutputStream.toByteArray());
    }

    public a(@NonNull Bitmap.CompressFormat compressFormat, int i10) {
        this.f25778a = compressFormat;
        this.f25779b = i10;
    }
}

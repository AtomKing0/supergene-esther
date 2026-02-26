package b1;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: InputStreamBitmapImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 28)
public final class w implements r0.j<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f1885a = new d();

    @Override // r0.j
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public u0.v<Bitmap> b(@NonNull InputStream inputStream, int i10, int i11, @NonNull r0.h hVar) throws IOException {
        return this.f1885a.b(ImageDecoder.createSource(o1.a.b(inputStream)), i10, i11, hVar);
    }

    @Override // r0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull r0.h hVar) throws IOException {
        return true;
    }
}

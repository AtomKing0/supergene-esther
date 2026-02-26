package b1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: compiled from: BitmapDrawableDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class a<DataType> implements r0.j<DataType, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r0.j<DataType, Bitmap> f1811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f1812b;

    public a(@NonNull Resources resources, @NonNull r0.j<DataType, Bitmap> jVar) {
        this.f1812b = (Resources) o1.j.d(resources);
        this.f1811a = (r0.j) o1.j.d(jVar);
    }

    @Override // r0.j
    public boolean a(@NonNull DataType datatype, @NonNull r0.h hVar) throws IOException {
        return this.f1811a.a(datatype, hVar);
    }

    @Override // r0.j
    public u0.v<BitmapDrawable> b(@NonNull DataType datatype, int i10, int i11, @NonNull r0.h hVar) throws IOException {
        return x.c(this.f1812b, this.f1811a.b(datatype, i10, i11, hVar));
    }
}

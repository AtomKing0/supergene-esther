package b1;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: ResourceBitmapDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class z implements r0.j<Uri, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d1.d f1894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v0.d f1895b;

    public z(d1.d dVar, v0.d dVar2) {
        this.f1894a = dVar;
        this.f1895b = dVar2;
    }

    @Override // r0.j
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public u0.v<Bitmap> b(@NonNull Uri uri, int i10, int i11, @NonNull r0.h hVar) {
        u0.v<Drawable> vVarB = this.f1894a.b(uri, i10, i11, hVar);
        if (vVarB == null) {
            return null;
        }
        return r.a(this.f1895b, vVarB.get(), i10, i11);
    }

    @Override // r0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri, @NonNull r0.h hVar) {
        return "android.resource".equals(uri.getScheme());
    }
}

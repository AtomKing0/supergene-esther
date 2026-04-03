package b1;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: compiled from: BitmapDrawableEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements r0.k<BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v0.d f1817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r0.k<Bitmap> f1818b;

    public b(v0.d dVar, r0.k<Bitmap> kVar) {
        this.f1817a = dVar;
        this.f1818b = kVar;
    }

    @Override // r0.k
    @NonNull
    public r0.c b(@NonNull r0.h hVar) {
        return this.f1818b.b(hVar);
    }

    @Override // r0.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull u0.v<BitmapDrawable> vVar, @NonNull File file, @NonNull r0.h hVar) {
        return this.f1818b.a(new e(vVar.get().getBitmap(), this.f1817a), file, hVar);
    }
}

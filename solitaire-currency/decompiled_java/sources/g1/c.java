package g1;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import r0.h;
import u0.v;

/* JADX INFO: compiled from: DrawableBytesTranscoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements e<Drawable, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v0.d f25781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<Bitmap, byte[]> f25782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e<f1.c, byte[]> f25783c;

    public c(@NonNull v0.d dVar, @NonNull e<Bitmap, byte[]> eVar, @NonNull e<f1.c, byte[]> eVar2) {
        this.f25781a = dVar;
        this.f25782b = eVar;
        this.f25783c = eVar2;
    }

    @Override // g1.e
    @Nullable
    public v<byte[]> a(@NonNull v<Drawable> vVar, @NonNull h hVar) {
        Drawable drawable = vVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f25782b.a(b1.e.c(((BitmapDrawable) drawable).getBitmap(), this.f25781a), hVar);
        }
        if (drawable instanceof f1.c) {
            return this.f25783c.a(b(vVar), hVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private static v<f1.c> b(@NonNull v<Drawable> vVar) {
        return vVar;
    }
}

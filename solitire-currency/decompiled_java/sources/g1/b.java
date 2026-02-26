package g1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b1.x;
import o1.j;
import r0.h;
import u0.v;

/* JADX INFO: compiled from: BitmapDrawableTranscoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements e<Bitmap, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f25780a;

    public b(@NonNull Resources resources) {
        this.f25780a = (Resources) j.d(resources);
    }

    @Override // g1.e
    @Nullable
    public v<BitmapDrawable> a(@NonNull v<Bitmap> vVar, @NonNull h hVar) {
        return x.c(this.f25780a, vVar);
    }
}

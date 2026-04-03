package b1;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: BitmapTransformation.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements r0.l<Bitmap> {
    @Override // r0.l
    @NonNull
    public final u0.v<Bitmap> a(@NonNull Context context, @NonNull u0.v<Bitmap> vVar, int i10, int i11) {
        if (!o1.k.r(i10, i11)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i10 + " or height: " + i11 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        v0.d dVarF = com.bumptech.glide.b.c(context).f();
        Bitmap bitmap = vVar.get();
        if (i10 == Integer.MIN_VALUE) {
            i10 = bitmap.getWidth();
        }
        if (i11 == Integer.MIN_VALUE) {
            i11 = bitmap.getHeight();
        }
        Bitmap bitmapC = c(dVarF, bitmap, i10, i11);
        return bitmap.equals(bitmapC) ? vVar : e.c(bitmapC, dVarF);
    }

    protected abstract Bitmap c(@NonNull v0.d dVar, @NonNull Bitmap bitmap, int i10, int i11);
}

package a0;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.WorkerThread;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DrawableUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f48a = new l();

    private l() {
    }

    private final boolean b(Bitmap bitmap, Bitmap.Config config) {
        return bitmap.getConfig() == a.e(config);
    }

    private final boolean c(boolean z10, Bitmap bitmap, w.i iVar, w.h hVar) {
        if (z10) {
            return true;
        }
        return m.h.c(bitmap.getWidth(), bitmap.getHeight(), w.b.a(iVar) ? bitmap.getWidth() : j.z(iVar.b(), hVar), w.b.a(iVar) ? bitmap.getHeight() : j.z(iVar.a(), hVar), hVar) == 1.0d;
    }

    @WorkerThread
    @NotNull
    public final Bitmap a(@NotNull Drawable drawable, @NotNull Bitmap.Config config, @NotNull w.i iVar, @NotNull w.h hVar, boolean z10) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (b(bitmap, config) && c(z10, bitmap, iVar, hVar)) {
                return bitmap;
            }
        }
        Drawable drawableMutate = drawable.mutate();
        int iP = j.p(drawableMutate);
        if (iP <= 0) {
            iP = 512;
        }
        int i10 = j.i(drawableMutate);
        int i11 = i10 > 0 ? i10 : 512;
        double dC = m.h.c(iP, i11, w.b.a(iVar) ? iP : j.z(iVar.b(), hVar), w.b.a(iVar) ? i11 : j.z(iVar.a(), hVar), hVar);
        int iB = j9.c.b(((double) iP) * dC);
        int iB2 = j9.c.b(dC * ((double) i11));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iB, iB2, a.e(config));
        kotlin.jvm.internal.t.h(bitmapCreateBitmap, "createBitmap(width, height, config)");
        Rect bounds = drawableMutate.getBounds();
        int i12 = bounds.left;
        int i13 = bounds.top;
        int i14 = bounds.right;
        int i15 = bounds.bottom;
        drawableMutate.setBounds(0, 0, iB, iB2);
        drawableMutate.draw(new Canvas(bitmapCreateBitmap));
        drawableMutate.setBounds(i12, i13, i14, i15);
        return bitmapCreateBitmap;
    }
}

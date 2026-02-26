package b1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: DrawableTransformation.java */
/* JADX INFO: loaded from: classes2.dex */
public class s implements r0.l<Drawable> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r0.l<Bitmap> f1875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f1876c;

    public s(r0.l<Bitmap> lVar, boolean z10) {
        this.f1875b = lVar;
        this.f1876c = z10;
    }

    private u0.v<Drawable> d(Context context, u0.v<Bitmap> vVar) {
        return x.c(context.getResources(), vVar);
    }

    @Override // r0.l
    @NonNull
    public u0.v<Drawable> a(@NonNull Context context, @NonNull u0.v<Drawable> vVar, int i10, int i11) {
        v0.d dVarF = com.bumptech.glide.b.c(context).f();
        Drawable drawable = vVar.get();
        u0.v<Bitmap> vVarA = r.a(dVarF, drawable, i10, i11);
        if (vVarA != null) {
            u0.v<Bitmap> vVarA2 = this.f1875b.a(context, vVarA, i10, i11);
            if (!vVarA2.equals(vVarA)) {
                return d(context, vVarA2);
            }
            vVarA2.recycle();
            return vVar;
        }
        if (!this.f1876c) {
            return vVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // r0.f
    public void b(@NonNull MessageDigest messageDigest) {
        this.f1875b.b(messageDigest);
    }

    @Override // r0.f
    public boolean equals(Object obj) {
        if (obj instanceof s) {
            return this.f1875b.equals(((s) obj).f1875b);
        }
        return false;
    }

    @Override // r0.f
    public int hashCode() {
        return this.f1875b.hashCode();
    }

    public r0.l<BitmapDrawable> c() {
        return this;
    }
}

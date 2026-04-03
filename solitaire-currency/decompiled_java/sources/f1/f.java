package f1;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
import r0.l;
import u0.v;

/* JADX INFO: compiled from: GifDrawableTransformation.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements l<c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l<Bitmap> f25556b;

    public f(l<Bitmap> lVar) {
        this.f25556b = (l) o1.j.d(lVar);
    }

    @Override // r0.l
    @NonNull
    public v<c> a(@NonNull Context context, @NonNull v<c> vVar, int i10, int i11) {
        c cVar = vVar.get();
        v<Bitmap> eVar = new b1.e(cVar.e(), com.bumptech.glide.b.c(context).f());
        v<Bitmap> vVarA = this.f25556b.a(context, eVar, i10, i11);
        if (!eVar.equals(vVarA)) {
            eVar.recycle();
        }
        cVar.m(this.f25556b, vVarA.get());
        return vVar;
    }

    @Override // r0.f
    public void b(@NonNull MessageDigest messageDigest) {
        this.f25556b.b(messageDigest);
    }

    @Override // r0.f
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f25556b.equals(((f) obj).f25556b);
        }
        return false;
    }

    @Override // r0.f
    public int hashCode() {
        return this.f25556b.hashCode();
    }
}

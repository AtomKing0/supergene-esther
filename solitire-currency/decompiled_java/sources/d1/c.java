package d1;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import u0.v;

/* JADX INFO: compiled from: NonOwnedDrawableResource.java */
/* JADX INFO: loaded from: classes2.dex */
final class c extends b<Drawable> {
    private c(Drawable drawable) {
        super(drawable);
    }

    @Nullable
    static v<Drawable> c(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    @Override // u0.v
    @NonNull
    public Class<Drawable> a() {
        return this.f24445a.getClass();
    }

    @Override // u0.v
    public int getSize() {
        return Math.max(1, this.f24445a.getIntrinsicWidth() * this.f24445a.getIntrinsicHeight() * 4);
    }

    @Override // u0.v
    public void recycle() {
    }
}

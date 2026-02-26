package d1;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import o1.j;
import u0.r;
import u0.v;

/* JADX INFO: compiled from: DrawableResource.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T extends Drawable> implements v<T>, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f24445a;

    public b(T t10) {
        this.f24445a = (T) j.d(t10);
    }

    @Override // u0.v
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final T get() {
        Drawable.ConstantState constantState = this.f24445a.getConstantState();
        return constantState == null ? this.f24445a : (T) constantState.newDrawable();
    }

    @Override // u0.r
    public void initialize() {
        T t10 = this.f24445a;
        if (t10 instanceof BitmapDrawable) {
            ((BitmapDrawable) t10).getBitmap().prepareToDraw();
        } else if (t10 instanceof f1.c) {
            ((f1.c) t10).e().prepareToDraw();
        }
    }
}

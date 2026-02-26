package b1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: LazyBitmapDrawableResource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x implements u0.v<BitmapDrawable>, u0.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f1886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u0.v<Bitmap> f1887b;

    private x(@NonNull Resources resources, @NonNull u0.v<Bitmap> vVar) {
        this.f1886a = (Resources) o1.j.d(resources);
        this.f1887b = (u0.v) o1.j.d(vVar);
    }

    @Nullable
    public static u0.v<BitmapDrawable> c(@NonNull Resources resources, @Nullable u0.v<Bitmap> vVar) {
        if (vVar == null) {
            return null;
        }
        return new x(resources, vVar);
    }

    @Override // u0.v
    @NonNull
    public Class<BitmapDrawable> a() {
        return BitmapDrawable.class;
    }

    @Override // u0.v
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f1886a, this.f1887b.get());
    }

    @Override // u0.v
    public int getSize() {
        return this.f1887b.getSize();
    }

    @Override // u0.r
    public void initialize() {
        u0.v<Bitmap> vVar = this.f1887b;
        if (vVar instanceof u0.r) {
            ((u0.r) vVar).initialize();
        }
    }

    @Override // u0.v
    public void recycle() {
        this.f1887b.recycle();
    }
}

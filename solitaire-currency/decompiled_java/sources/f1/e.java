package f1;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: GifDrawableResource.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends d1.b<c> {
    public e(c cVar) {
        super(cVar);
    }

    @Override // u0.v
    @NonNull
    public Class<c> a() {
        return c.class;
    }

    @Override // u0.v
    public int getSize() {
        return ((c) this.f24445a).i();
    }

    @Override // d1.b, u0.r
    public void initialize() {
        ((c) this.f24445a).e().prepareToDraw();
    }

    @Override // u0.v
    public void recycle() {
        ((c) this.f24445a).stop();
        ((c) this.f24445a).k();
    }
}

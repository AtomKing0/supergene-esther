package u4;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: CancelableFontCallback.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Typeface f34591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0706a f34592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f34593c;

    /* JADX INFO: renamed from: u4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CancelableFontCallback.java */
    public interface InterfaceC0706a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0706a interfaceC0706a, Typeface typeface) {
        this.f34591a = typeface;
        this.f34592b = interfaceC0706a;
    }

    private void d(Typeface typeface) {
        if (this.f34593c) {
            return;
        }
        this.f34592b.a(typeface);
    }

    @Override // u4.f
    public void a(int i10) {
        d(this.f34591a);
    }

    @Override // u4.f
    public void b(Typeface typeface, boolean z10) {
        d(typeface);
    }

    public void c() {
        this.f34593c = true;
    }
}

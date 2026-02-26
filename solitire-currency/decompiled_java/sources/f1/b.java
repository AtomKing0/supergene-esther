package f1;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import q0.a;

/* JADX INFO: compiled from: GifBitmapProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements a.InterfaceC0656a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v0.d f25542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final v0.b f25543b;

    public b(v0.d dVar, @Nullable v0.b bVar) {
        this.f25542a = dVar;
        this.f25543b = bVar;
    }

    @Override // q0.a.InterfaceC0656a
    public void a(@NonNull Bitmap bitmap) {
        this.f25542a.c(bitmap);
    }

    @Override // q0.a.InterfaceC0656a
    @NonNull
    public byte[] b(int i10) {
        v0.b bVar = this.f25543b;
        return bVar == null ? new byte[i10] : (byte[]) bVar.c(i10, byte[].class);
    }

    @Override // q0.a.InterfaceC0656a
    @NonNull
    public Bitmap c(int i10, int i11, @NonNull Bitmap.Config config) {
        return this.f25542a.e(i10, i11, config);
    }

    @Override // q0.a.InterfaceC0656a
    @NonNull
    public int[] d(int i10) {
        v0.b bVar = this.f25543b;
        return bVar == null ? new int[i10] : (int[]) bVar.c(i10, int[].class);
    }

    @Override // q0.a.InterfaceC0656a
    public void e(@NonNull byte[] bArr) {
        v0.b bVar = this.f25543b;
        if (bVar == null) {
            return;
        }
        bVar.put(bArr);
    }

    @Override // q0.a.InterfaceC0656a
    public void f(@NonNull int[] iArr) {
        v0.b bVar = this.f25543b;
        if (bVar == null) {
            return;
        }
        bVar.put(iArr);
    }
}

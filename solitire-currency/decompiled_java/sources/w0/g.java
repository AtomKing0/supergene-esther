package w0;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import u0.v;
import w0.h;

/* JADX INFO: compiled from: LruResourceCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends o1.g<r0.f, v<?>> implements h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h.a f35298e;

    public g(long j10) {
        super(j10);
    }

    @Override // w0.h
    @SuppressLint({"InlinedApi"})
    public void a(int i10) {
        if (i10 >= 40) {
            b();
        } else if (i10 >= 20 || i10 == 15) {
            m(h() / 2);
        }
    }

    @Override // w0.h
    @Nullable
    public /* bridge */ /* synthetic */ v c(@NonNull r0.f fVar) {
        return (v) super.l(fVar);
    }

    @Override // w0.h
    @Nullable
    public /* bridge */ /* synthetic */ v d(@NonNull r0.f fVar, @Nullable v vVar) {
        return (v) super.k(fVar, vVar);
    }

    @Override // w0.h
    public void e(@NonNull h.a aVar) {
        this.f35298e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // o1.g
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int i(@Nullable v<?> vVar) {
        return vVar == null ? super.i(null) : vVar.getSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // o1.g
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(@NonNull r0.f fVar, @Nullable v<?> vVar) {
        h.a aVar = this.f35298e;
        if (aVar == null || vVar == null) {
            return;
        }
        aVar.a(vVar);
    }
}

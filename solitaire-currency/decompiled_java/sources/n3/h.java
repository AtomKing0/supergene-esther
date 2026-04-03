package n3;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SimpleSubtitleDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h extends n2.j<n, o, k> implements j {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f31669n;

    /* JADX INFO: compiled from: SimpleSubtitleDecoder.java */
    class a extends o {
        a() {
        }

        @Override // n2.h
        public void l() {
            h.this.n(this);
        }
    }

    protected h(String str) {
        super(new n[2], new o[2]);
        this.f31669n = str;
        q(1024);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // n2.j
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final n c() {
        return new n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // n2.j
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final o d() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // n2.j
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final k e(Throwable th) {
        return new k("Unexpected decode error", th);
    }

    protected abstract i v(byte[] bArr, int i10, boolean z10) throws k;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // n2.j
    @Nullable
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public final k f(n nVar, o oVar, boolean z10) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) a4.a.e(nVar.f31586c);
            oVar.m(nVar.f31588e, v(byteBuffer.array(), byteBuffer.limit(), z10), nVar.f31683i);
            oVar.d(Integer.MIN_VALUE);
            return null;
        } catch (k e10) {
            return e10;
        }
    }

    @Override // n3.j
    public void setPositionUs(long j10) {
    }
}

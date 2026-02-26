package n2;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import k2.l1;

/* JADX INFO: compiled from: DecoderInputBuffer.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends n2.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f31585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ByteBuffer f31586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f31587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f31588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public ByteBuffer f31589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f31590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f31591h;

    /* JADX INFO: compiled from: DecoderInputBuffer.java */
    public static final class a extends IllegalStateException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f31593b;

        public a(int i10, int i11) {
            super("Buffer too small (" + i10 + " < " + i11 + ")");
            this.f31592a = i10;
            this.f31593b = i11;
        }
    }

    static {
        l1.a("goog.exo.decoder");
    }

    public g(int i10) {
        this(i10, 0);
    }

    private ByteBuffer l(int i10) {
        int i11 = this.f31590g;
        if (i11 == 1) {
            return ByteBuffer.allocate(i10);
        }
        if (i11 == 2) {
            return ByteBuffer.allocateDirect(i10);
        }
        ByteBuffer byteBuffer = this.f31586c;
        throw new a(byteBuffer == null ? 0 : byteBuffer.capacity(), i10);
    }

    public static g p() {
        return new g(0);
    }

    @Override // n2.a
    public void c() {
        super.c();
        ByteBuffer byteBuffer = this.f31586c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f31589f;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f31587d = false;
    }

    public void m(int i10) {
        int i11 = i10 + this.f31591h;
        ByteBuffer byteBuffer = this.f31586c;
        if (byteBuffer == null) {
            this.f31586c = l(i11);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i12 = i11 + iPosition;
        if (iCapacity >= i12) {
            this.f31586c = byteBuffer;
            return;
        }
        ByteBuffer byteBufferL = l(i12);
        byteBufferL.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferL.put(byteBuffer);
        }
        this.f31586c = byteBufferL;
    }

    public final void n() {
        ByteBuffer byteBuffer = this.f31586c;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f31589f;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean o() {
        return e(1073741824);
    }

    public void q(int i10) {
        ByteBuffer byteBuffer = this.f31589f;
        if (byteBuffer == null || byteBuffer.capacity() < i10) {
            this.f31589f = ByteBuffer.allocate(i10);
        } else {
            this.f31589f.clear();
        }
    }

    public g(int i10, int i11) {
        this.f31585b = new c();
        this.f31590g = i10;
        this.f31591h = i11;
    }
}

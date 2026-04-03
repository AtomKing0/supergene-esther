package p8;

import androidx.media3.extractor.ts.PsExtractor;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Output.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p implements Appendable, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final s8.g<q8.a> f32942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private q8.a f32943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private q8.a f32944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private ByteBuffer f32945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f32948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f32949h;

    public p(@NotNull s8.g<q8.a> pool) {
        t.i(pool, "pool");
        this.f32942a = pool;
        this.f32945d = n8.c.f31707a.a();
    }

    private final void B(char c10) {
        int i10 = 3;
        q8.a aVarJ0 = J0(3);
        try {
            ByteBuffer byteBufferG = aVarJ0.g();
            int iJ = aVarJ0.j();
            if (c10 >= 0 && c10 < 128) {
                byteBufferG.put(iJ, (byte) c10);
                i10 = 1;
            } else {
                if (128 <= c10 && c10 < 2048) {
                    byteBufferG.put(iJ, (byte) (((c10 >> 6) & 31) | PsExtractor.AUDIO_STREAM));
                    byteBufferG.put(iJ + 1, (byte) ((c10 & '?') | 128));
                    i10 = 2;
                } else {
                    if (2048 <= c10 && c10 < 0) {
                        byteBufferG.put(iJ, (byte) (((c10 >> '\f') & 15) | 224));
                        byteBufferG.put(iJ + 1, (byte) (((c10 >> 6) & 63) | 128));
                        byteBufferG.put(iJ + 2, (byte) ((c10 & '?') | 128));
                    } else {
                        if (!(0 <= c10 && c10 < 0)) {
                            q8.f.j(c10);
                            throw new v8.h();
                        }
                        byteBufferG.put(iJ, (byte) (((c10 >> 18) & 7) | PsExtractor.VIDEO_STREAM_MASK));
                        byteBufferG.put(iJ + 1, (byte) (((c10 >> '\f') & 63) | 128));
                        byteBufferG.put(iJ + 2, (byte) (((c10 >> 6) & 63) | 128));
                        byteBufferG.put(iJ + 3, (byte) ((c10 & '?') | 128));
                        i10 = 4;
                    }
                }
            }
            aVarJ0.a(i10);
            if (!(i10 >= 0)) {
                throw new IllegalStateException("The returned value shouldn't be negative".toString());
            }
        } finally {
            c();
        }
    }

    private final q8.a J() {
        q8.a aVarK0 = this.f32942a.k0();
        aVarK0.o(8);
        L(aVarK0);
        return aVarK0;
    }

    private final void O0(q8.a aVar, q8.a aVar2, s8.g<q8.a> gVar) {
        aVar.b(this.f32946e);
        int iJ = aVar.j() - aVar.h();
        int iJ2 = aVar2.j() - aVar2.h();
        int iA = r.a();
        if (iJ2 >= iA || iJ2 > (aVar.e() - aVar.f()) + (aVar.f() - aVar.j())) {
            iJ2 = -1;
        }
        if (iJ >= iA || iJ > aVar2.i() || !q8.b.a(aVar2)) {
            iJ = -1;
        }
        if (iJ2 == -1 && iJ == -1) {
            x(aVar2);
            return;
        }
        if (iJ == -1 || iJ2 <= iJ) {
            b.a(aVar, aVar2, (aVar.f() - aVar.j()) + (aVar.e() - aVar.f()));
            c();
            q8.a aVarW = aVar2.w();
            if (aVarW != null) {
                x(aVarW);
            }
            aVar2.A(gVar);
            return;
        }
        if (iJ2 == -1 || iJ < iJ2) {
            P0(aVar2, aVar);
            return;
        }
        throw new IllegalStateException("prep = " + iJ + ", app = " + iJ2);
    }

    private final void P0(q8.a aVar, q8.a aVar2) {
        b.c(aVar, aVar2);
        q8.a aVar3 = this.f32943b;
        if (aVar3 == null) {
            throw new IllegalStateException("head should't be null since it is already handled in the fast-path".toString());
        }
        if (aVar3 == aVar2) {
            this.f32943b = aVar;
        } else {
            while (true) {
                q8.a aVarX = aVar3.x();
                t.f(aVarX);
                if (aVarX == aVar2) {
                    break;
                } else {
                    aVar3 = aVarX;
                }
            }
            aVar3.C(aVar);
        }
        aVar2.A(this.f32942a);
        this.f32944c = h.a(aVar);
    }

    private final void S() {
        q8.a aVarK0 = K0();
        if (aVarK0 == null) {
            return;
        }
        q8.a aVarX = aVarK0;
        do {
            try {
                R(aVarX.g(), aVarX.h(), aVarX.j() - aVarX.h());
                aVarX = aVarX.x();
            } finally {
                h.b(aVarK0, this.f32942a);
            }
        } while (aVarX != null);
    }

    private final void z(q8.a aVar, q8.a aVar2, int i10) {
        q8.a aVar3 = this.f32944c;
        if (aVar3 == null) {
            this.f32943b = aVar;
            this.f32949h = 0;
        } else {
            aVar3.C(aVar);
            int i11 = this.f32946e;
            aVar3.b(i11);
            this.f32949h += i11 - this.f32948g;
        }
        this.f32944c = aVar2;
        this.f32949h += i10;
        this.f32945d = aVar2.g();
        this.f32946e = aVar2.j();
        this.f32948g = aVar2.h();
        this.f32947f = aVar2.f();
    }

    public final int G0() {
        return this.f32946e;
    }

    protected final int I0() {
        return this.f32949h + (this.f32946e - this.f32948g);
    }

    @NotNull
    public final q8.a J0(int i10) {
        q8.a aVar;
        if (i0() - G0() < i10 || (aVar = this.f32944c) == null) {
            return J();
        }
        aVar.b(this.f32946e);
        return aVar;
    }

    @Nullable
    public final q8.a K0() {
        q8.a aVar = this.f32943b;
        if (aVar == null) {
            return null;
        }
        q8.a aVar2 = this.f32944c;
        if (aVar2 != null) {
            aVar2.b(this.f32946e);
        }
        this.f32943b = null;
        this.f32944c = null;
        this.f32946e = 0;
        this.f32947f = 0;
        this.f32948g = 0;
        this.f32949h = 0;
        this.f32945d = n8.c.f31707a.a();
        return aVar;
    }

    public final void L(@NotNull q8.a buffer) {
        t.i(buffer, "buffer");
        if (!(buffer.x() == null)) {
            throw new IllegalStateException("It should be a single buffer chunk.".toString());
        }
        z(buffer, buffer, 0);
    }

    public final void L0(@NotNull q8.a chunkBuffer) {
        t.i(chunkBuffer, "chunkBuffer");
        q8.a aVar = this.f32944c;
        if (aVar == null) {
            x(chunkBuffer);
        } else {
            O0(aVar, chunkBuffer, this.f32942a);
        }
    }

    public final void M0(@NotNull j packet) {
        t.i(packet, "packet");
        q8.a aVarG1 = packet.g1();
        if (aVarG1 == null) {
            packet.release();
            return;
        }
        q8.a aVar = this.f32944c;
        if (aVar == null) {
            x(aVarG1);
        } else {
            O0(aVar, aVarG1, packet.O0());
        }
    }

    public final void N0(@NotNull j p10, long j10) throws EOFException {
        t.i(p10, "p");
        while (j10 > 0) {
            long jL0 = p10.L0() - p10.N0();
            if (jL0 > j10) {
                q8.a aVarU0 = p10.U0(1);
                if (aVarU0 == null) {
                    s.a(1);
                    throw new v8.h();
                }
                int iH = aVarU0.h();
                try {
                    q.a(this, aVarU0, (int) j10);
                    int iH2 = aVarU0.h();
                    if (iH2 < iH) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (iH2 == aVarU0.j()) {
                        p10.O(aVarU0);
                        return;
                    } else {
                        p10.c1(iH2);
                        return;
                    }
                } catch (Throwable th) {
                    int iH3 = aVarU0.h();
                    if (iH3 < iH) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (iH3 == aVarU0.j()) {
                        p10.O(aVarU0);
                    } else {
                        p10.c1(iH3);
                    }
                    throw th;
                }
            }
            j10 -= jL0;
            q8.a aVarF1 = p10.f1();
            if (aVarF1 == null) {
                throw new EOFException("Unexpected end of packet");
            }
            L(aVarF1);
        }
    }

    protected abstract void O();

    protected abstract void R(@NotNull ByteBuffer byteBuffer, int i10, int i11);

    @NotNull
    public final q8.a W() {
        q8.a aVar = this.f32943b;
        return aVar == null ? q8.a.f33167j.a() : aVar;
    }

    public final void a() {
        q8.a aVarW = W();
        if (aVarW != q8.a.f33167j.a()) {
            if (!(aVarW.x() == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            aVarW.r();
            aVarW.o(8);
            int iJ = aVarW.j();
            this.f32946e = iJ;
            this.f32948g = iJ;
            this.f32947f = aVarW.f();
        }
    }

    public final void c() {
        q8.a aVar = this.f32944c;
        if (aVar != null) {
            this.f32946e = aVar.j();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            flush();
        } finally {
            O();
        }
    }

    public final void flush() {
        S();
    }

    @NotNull
    protected final s8.g<q8.a> h0() {
        return this.f32942a;
    }

    @Override // java.lang.Appendable
    @NotNull
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public p append(char c10) {
        int i10 = this.f32946e;
        int i11 = 3;
        if (this.f32947f - i10 < 3) {
            B(c10);
            return this;
        }
        ByteBuffer byteBuffer = this.f32945d;
        if (c10 >= 0 && c10 < 128) {
            byteBuffer.put(i10, (byte) c10);
            i11 = 1;
        } else {
            if (128 <= c10 && c10 < 2048) {
                byteBuffer.put(i10, (byte) (((c10 >> 6) & 31) | PsExtractor.AUDIO_STREAM));
                byteBuffer.put(i10 + 1, (byte) ((c10 & '?') | 128));
                i11 = 2;
            } else {
                if (2048 <= c10 && c10 < 0) {
                    byteBuffer.put(i10, (byte) (((c10 >> '\f') & 15) | 224));
                    byteBuffer.put(i10 + 1, (byte) (((c10 >> 6) & 63) | 128));
                    byteBuffer.put(i10 + 2, (byte) ((c10 & '?') | 128));
                } else {
                    if (!(0 <= c10 && c10 < 0)) {
                        q8.f.j(c10);
                        throw new v8.h();
                    }
                    byteBuffer.put(i10, (byte) (((c10 >> 18) & 7) | PsExtractor.VIDEO_STREAM_MASK));
                    byteBuffer.put(i10 + 1, (byte) (((c10 >> '\f') & 63) | 128));
                    byteBuffer.put(i10 + 2, (byte) (((c10 >> 6) & 63) | 128));
                    byteBuffer.put(i10 + 3, (byte) ((c10 & '?') | 128));
                    i11 = 4;
                }
            }
        }
        this.f32946e = i10 + i11;
        return this;
    }

    public final int i0() {
        return this.f32947f;
    }

    @Override // java.lang.Appendable
    @NotNull
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public p append(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            append("null", 0, 4);
        } else {
            append(charSequence, 0, charSequence.length());
        }
        return this;
    }

    @Override // java.lang.Appendable
    @NotNull
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public p append(@Nullable CharSequence charSequence, int i10, int i11) {
        if (charSequence == null) {
            return append("null", i10, i11);
        }
        s.h(this, charSequence, i10, i11, p9.d.f32952b);
        return this;
    }

    public final void release() {
        close();
    }

    public final void x(@NotNull q8.a head) {
        t.i(head, "head");
        q8.a aVarA = h.a(head);
        long jC = h.c(head) - ((long) (aVarA.j() - aVarA.h()));
        if (jC < 2147483647L) {
            z(head, aVarA, (int) jC);
        } else {
            q8.e.a(jC, "total size increase");
            throw new v8.h();
        }
    }

    public p() {
        this(q8.a.f33167j.c());
    }
}

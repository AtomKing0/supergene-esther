package ua;

import androidx.media3.common.C;
import androidx.media3.exoplayer.MediaPeriodQueue;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.extractor.ts.PsExtractor;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements e, d, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public u0 f34738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f34739b;

    /* JADX INFO: compiled from: Buffer.kt */
    public static final class a implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public c f34740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private u0 f34741b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public byte[] f34743d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f34742c = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f34744e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f34745f = -1;

        public final void a(@Nullable u0 u0Var) {
            this.f34741b = u0Var;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.f34740a != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.f34740a = null;
            a(null);
            this.f34742c = -1L;
            this.f34743d = null;
            this.f34744e = -1;
            this.f34745f = -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae A[EDGE_INSN: B:43:0x00ae->B:37:0x00ae BREAK  A[LOOP:0: B:5:0x000d->B:45:?], SYNTHETIC] */
    @Override // ua.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long E0() throws java.io.EOFException {
        /*
            r14 = this;
            long r0 = r14.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lb8
            r0 = 0
            r1 = r0
            r4 = r2
        Ld:
            ua.u0 r6 = r14.f34738a
            kotlin.jvm.internal.t.f(r6)
            byte[] r7 = r6.f34826a
            int r8 = r6.f34827b
            int r9 = r6.f34828c
        L18:
            if (r8 >= r9) goto L9a
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L29
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L29
            int r11 = r10 - r11
            goto L43
        L29:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L38
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L38
        L33:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L43
        L38:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L7b
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L7b
            goto L33
        L43:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L53
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L53:
            ua.c r0 = new ua.c
            r0.<init>()
            ua.c r0 = r0.v0(r4)
            ua.c r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.K0()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L7b:
            if (r0 == 0) goto L7f
            r1 = 1
            goto L9a
        L7f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = ua.f1.i(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L9a:
            if (r8 != r9) goto La6
            ua.u0 r7 = r6.b()
            r14.f34738a = r7
            ua.v0.b(r6)
            goto La8
        La6:
            r6.f34827b = r8
        La8:
            if (r1 != 0) goto Lae
            ua.u0 r6 = r14.f34738a
            if (r6 != 0) goto Ld
        Lae:
            long r1 = r14.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.L0(r1)
            return r4
        Lb8:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ua.c.E0():long");
    }

    @Override // ua.e
    @NotNull
    public InputStream F0() {
        return new b();
    }

    @Override // ua.x0
    public void G(@NotNull c source, long j10) {
        u0 u0Var;
        kotlin.jvm.internal.t.i(source, "source");
        if (!(source != this)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        f1.b(source.size(), 0L, j10);
        while (j10 > 0) {
            u0 u0Var2 = source.f34738a;
            kotlin.jvm.internal.t.f(u0Var2);
            int i10 = u0Var2.f34828c;
            kotlin.jvm.internal.t.f(source.f34738a);
            if (j10 < i10 - r2.f34827b) {
                u0 u0Var3 = this.f34738a;
                if (u0Var3 != null) {
                    kotlin.jvm.internal.t.f(u0Var3);
                    u0Var = u0Var3.f34832g;
                } else {
                    u0Var = null;
                }
                if (u0Var != null && u0Var.f34830e) {
                    if ((((long) u0Var.f34828c) + j10) - ((long) (u0Var.f34829d ? 0 : u0Var.f34827b)) <= 8192) {
                        u0 u0Var4 = source.f34738a;
                        kotlin.jvm.internal.t.f(u0Var4);
                        u0Var4.f(u0Var, (int) j10);
                        source.L0(source.size() - j10);
                        L0(size() + j10);
                        return;
                    }
                }
                u0 u0Var5 = source.f34738a;
                kotlin.jvm.internal.t.f(u0Var5);
                source.f34738a = u0Var5.e((int) j10);
            }
            u0 u0Var6 = source.f34738a;
            kotlin.jvm.internal.t.f(u0Var6);
            long j11 = u0Var6.f34828c - u0Var6.f34827b;
            source.f34738a = u0Var6.b();
            u0 u0Var7 = this.f34738a;
            if (u0Var7 == null) {
                this.f34738a = u0Var6;
                u0Var6.f34832g = u0Var6;
                u0Var6.f34831f = u0Var6;
            } else {
                kotlin.jvm.internal.t.f(u0Var7);
                u0 u0Var8 = u0Var7.f34832g;
                kotlin.jvm.internal.t.f(u0Var8);
                u0Var8.c(u0Var6).a();
            }
            source.L0(source.size() - j11);
            L0(size() + j11);
            j10 -= j11;
        }
    }

    public void G0(@NotNull byte[] sink) throws EOFException {
        kotlin.jvm.internal.t.i(sink, "sink");
        int i10 = 0;
        while (i10 < sink.length) {
            int i11 = read(sink, i10, sink.length - i10);
            if (i11 == -1) {
                throw new EOFException();
            }
            i10 += i11;
        }
    }

    public long I0() throws EOFException {
        if (size() < 8) {
            throw new EOFException();
        }
        u0 u0Var = this.f34738a;
        kotlin.jvm.internal.t.f(u0Var);
        int i10 = u0Var.f34827b;
        int i11 = u0Var.f34828c;
        if (i11 - i10 < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = u0Var.f34826a;
        int i12 = i10 + 1;
        long j10 = (((long) bArr[i10]) & 255) << 56;
        int i13 = i12 + 1;
        int i14 = i13 + 1;
        long j11 = j10 | ((((long) bArr[i12]) & 255) << 48) | ((((long) bArr[i13]) & 255) << 40);
        int i15 = i14 + 1;
        int i16 = i15 + 1;
        long j12 = j11 | ((((long) bArr[i14]) & 255) << 32) | ((((long) bArr[i15]) & 255) << 24);
        int i17 = i16 + 1;
        long j13 = j12 | ((((long) bArr[i16]) & 255) << 16);
        int i18 = i17 + 1;
        long j14 = j13 | ((((long) bArr[i17]) & 255) << 8);
        int i19 = i18 + 1;
        long j15 = j14 | (((long) bArr[i18]) & 255);
        L0(size() - 8);
        if (i19 == i11) {
            this.f34738a = u0Var.b();
            v0.b(u0Var);
        } else {
            u0Var.f34827b = i19;
        }
        return j15;
    }

    @NotNull
    public String J0(long j10, @NotNull Charset charset) throws EOFException {
        kotlin.jvm.internal.t.i(charset, "charset");
        if (!(j10 >= 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (this.f34739b < j10) {
            throw new EOFException();
        }
        if (j10 == 0) {
            return "";
        }
        u0 u0Var = this.f34738a;
        kotlin.jvm.internal.t.f(u0Var);
        int i10 = u0Var.f34827b;
        if (((long) i10) + j10 > u0Var.f34828c) {
            return new String(P(j10), charset);
        }
        int i11 = (int) j10;
        String str = new String(u0Var.f34826a, i10, i11, charset);
        int i12 = u0Var.f34827b + i11;
        u0Var.f34827b = i12;
        this.f34739b -= j10;
        if (i12 == u0Var.f34828c) {
            this.f34738a = u0Var.b();
            v0.b(u0Var);
        }
        return str;
    }

    @Override // ua.e
    public boolean K(long j10) {
        return this.f34739b >= j10;
    }

    @NotNull
    public String K0() {
        return J0(this.f34739b, p9.d.f32952b);
    }

    public final byte L(long j10) {
        f1.b(size(), j10, 1L);
        u0 u0Var = this.f34738a;
        if (u0Var == null) {
            kotlin.jvm.internal.t.f(null);
            throw null;
        }
        if (size() - j10 < j10) {
            long size = size();
            while (size > j10) {
                u0Var = u0Var.f34832g;
                kotlin.jvm.internal.t.f(u0Var);
                size -= (long) (u0Var.f34828c - u0Var.f34827b);
            }
            kotlin.jvm.internal.t.f(u0Var);
            return u0Var.f34826a[(int) ((((long) u0Var.f34827b) + j10) - size)];
        }
        long j11 = 0;
        while (true) {
            long j12 = ((long) (u0Var.f34828c - u0Var.f34827b)) + j11;
            if (j12 > j10) {
                kotlin.jvm.internal.t.f(u0Var);
                return u0Var.f34826a[(int) ((((long) u0Var.f34827b) + j10) - j11)];
            }
            u0Var = u0Var.f34831f;
            kotlin.jvm.internal.t.f(u0Var);
            j11 = j12;
        }
    }

    public final void L0(long j10) {
        this.f34739b = j10;
    }

    @NotNull
    public final f M0() {
        if (size() <= 2147483647L) {
            return N0((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    @Override // ua.e
    @NotNull
    public String N() throws EOFException {
        return y(Long.MAX_VALUE);
    }

    @NotNull
    public final f N0(int i10) {
        if (i10 == 0) {
            return f.f34756e;
        }
        f1.b(size(), 0L, i10);
        u0 u0Var = this.f34738a;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            kotlin.jvm.internal.t.f(u0Var);
            int i14 = u0Var.f34828c;
            int i15 = u0Var.f34827b;
            if (i14 == i15) {
                throw new AssertionError("s.limit == s.pos");
            }
            i12 += i14 - i15;
            i13++;
            u0Var = u0Var.f34831f;
        }
        byte[][] bArr = new byte[i13][];
        int[] iArr = new int[i13 * 2];
        u0 u0Var2 = this.f34738a;
        int i16 = 0;
        while (i11 < i10) {
            kotlin.jvm.internal.t.f(u0Var2);
            bArr[i16] = u0Var2.f34826a;
            i11 += u0Var2.f34828c - u0Var2.f34827b;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = u0Var2.f34827b;
            u0Var2.f34829d = true;
            i16++;
            u0Var2 = u0Var2.f34831f;
        }
        return new w0(bArr, iArr);
    }

    public long O(byte b10, long j10, long j11) {
        u0 u0Var;
        int i10;
        long size = 0;
        boolean z10 = false;
        if (0 <= j10 && j10 <= j11) {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        if (j11 > size()) {
            j11 = size();
        }
        if (j10 == j11 || (u0Var = this.f34738a) == null) {
            return -1L;
        }
        if (size() - j10 < j10) {
            size = size();
            while (size > j10) {
                u0Var = u0Var.f34832g;
                kotlin.jvm.internal.t.f(u0Var);
                size -= (long) (u0Var.f34828c - u0Var.f34827b);
            }
            while (size < j11) {
                byte[] bArr = u0Var.f34826a;
                int iMin = (int) Math.min(u0Var.f34828c, (((long) u0Var.f34827b) + j11) - size);
                i10 = (int) ((((long) u0Var.f34827b) + j10) - size);
                while (i10 < iMin) {
                    if (bArr[i10] != b10) {
                        i10++;
                    }
                }
                size += (long) (u0Var.f34828c - u0Var.f34827b);
                u0Var = u0Var.f34831f;
                kotlin.jvm.internal.t.f(u0Var);
                j10 = size;
            }
            return -1L;
        }
        while (true) {
            long j12 = ((long) (u0Var.f34828c - u0Var.f34827b)) + size;
            if (j12 > j10) {
                break;
            }
            u0Var = u0Var.f34831f;
            kotlin.jvm.internal.t.f(u0Var);
            size = j12;
        }
        while (size < j11) {
            byte[] bArr2 = u0Var.f34826a;
            int iMin2 = (int) Math.min(u0Var.f34828c, (((long) u0Var.f34827b) + j11) - size);
            i10 = (int) ((((long) u0Var.f34827b) + j10) - size);
            while (i10 < iMin2) {
                if (bArr2[i10] != b10) {
                    i10++;
                }
            }
            size += (long) (u0Var.f34828c - u0Var.f34827b);
            u0Var = u0Var.f34831f;
            kotlin.jvm.internal.t.f(u0Var);
            j10 = size;
        }
        return -1L;
        return ((long) (i10 - u0Var.f34827b)) + size;
    }

    @NotNull
    public final u0 O0(int i10) {
        if (!(i10 >= 1 && i10 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        u0 u0Var = this.f34738a;
        if (u0Var != null) {
            kotlin.jvm.internal.t.f(u0Var);
            u0 u0Var2 = u0Var.f34832g;
            kotlin.jvm.internal.t.f(u0Var2);
            return (u0Var2.f34828c + i10 > 8192 || !u0Var2.f34830e) ? u0Var2.c(v0.c()) : u0Var2;
        }
        u0 u0VarC = v0.c();
        this.f34738a = u0VarC;
        u0VarC.f34832g = u0VarC;
        u0VarC.f34831f = u0VarC;
        return u0VarC;
    }

    @Override // ua.e
    @NotNull
    public byte[] P(long j10) throws EOFException {
        if (!(j10 >= 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (size() < j10) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j10];
        G0(bArr);
        return bArr;
    }

    @Override // ua.d
    @NotNull
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public c I(@NotNull f byteString) {
        kotlin.jvm.internal.t.i(byteString, "byteString");
        byteString.H(this, 0, byteString.B());
        return this;
    }

    @Override // ua.d
    @NotNull
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public c write(@NotNull byte[] source) {
        kotlin.jvm.internal.t.i(source, "source");
        return write(source, 0, source.length);
    }

    public long R(@NotNull f targetBytes) {
        kotlin.jvm.internal.t.i(targetBytes, "targetBytes");
        return S(targetBytes, 0L);
    }

    @Override // ua.d
    @NotNull
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public c write(@NotNull byte[] source, int i10, int i11) {
        kotlin.jvm.internal.t.i(source, "source");
        long j10 = i11;
        f1.b(source.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            u0 u0VarO0 = O0(1);
            int iMin = Math.min(i12 - i10, 8192 - u0VarO0.f34828c);
            int i13 = i10 + iMin;
            kotlin.collections.o.d(source, u0VarO0.f34826a, u0VarO0.f34828c, i10, i13);
            u0VarO0.f34828c += iMin;
            i10 = i13;
        }
        L0(size() + j10);
        return this;
    }

    public long S(@NotNull f targetBytes, long j10) {
        int i10;
        int i11;
        kotlin.jvm.internal.t.i(targetBytes, "targetBytes");
        long size = 0;
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j10).toString());
        }
        u0 u0Var = this.f34738a;
        if (u0Var == null) {
            return -1L;
        }
        if (size() - j10 < j10) {
            size = size();
            while (size > j10) {
                u0Var = u0Var.f34832g;
                kotlin.jvm.internal.t.f(u0Var);
                size -= (long) (u0Var.f34828c - u0Var.f34827b);
            }
            if (targetBytes.B() == 2) {
                byte bF = targetBytes.f(0);
                byte bF2 = targetBytes.f(1);
                while (size < size()) {
                    byte[] bArr = u0Var.f34826a;
                    i10 = (int) ((((long) u0Var.f34827b) + j10) - size);
                    int i12 = u0Var.f34828c;
                    while (i10 < i12) {
                        byte b10 = bArr[i10];
                        if (b10 == bF || b10 == bF2) {
                            i11 = u0Var.f34827b;
                        } else {
                            i10++;
                        }
                    }
                    size += (long) (u0Var.f34828c - u0Var.f34827b);
                    u0Var = u0Var.f34831f;
                    kotlin.jvm.internal.t.f(u0Var);
                    j10 = size;
                }
                return -1L;
            }
            byte[] bArrO = targetBytes.o();
            while (size < size()) {
                byte[] bArr2 = u0Var.f34826a;
                i10 = (int) ((((long) u0Var.f34827b) + j10) - size);
                int i13 = u0Var.f34828c;
                while (i10 < i13) {
                    byte b11 = bArr2[i10];
                    for (byte b12 : bArrO) {
                        if (b11 == b12) {
                            i11 = u0Var.f34827b;
                        }
                    }
                    i10++;
                }
                size += (long) (u0Var.f34828c - u0Var.f34827b);
                u0Var = u0Var.f34831f;
                kotlin.jvm.internal.t.f(u0Var);
                j10 = size;
            }
            return -1L;
        }
        while (true) {
            long j11 = ((long) (u0Var.f34828c - u0Var.f34827b)) + size;
            if (j11 > j10) {
                break;
            }
            u0Var = u0Var.f34831f;
            kotlin.jvm.internal.t.f(u0Var);
            size = j11;
        }
        if (targetBytes.B() == 2) {
            byte bF3 = targetBytes.f(0);
            byte bF4 = targetBytes.f(1);
            while (size < size()) {
                byte[] bArr3 = u0Var.f34826a;
                i10 = (int) ((((long) u0Var.f34827b) + j10) - size);
                int i14 = u0Var.f34828c;
                while (i10 < i14) {
                    byte b13 = bArr3[i10];
                    if (b13 == bF3 || b13 == bF4) {
                        i11 = u0Var.f34827b;
                    } else {
                        i10++;
                    }
                }
                size += (long) (u0Var.f34828c - u0Var.f34827b);
                u0Var = u0Var.f34831f;
                kotlin.jvm.internal.t.f(u0Var);
                j10 = size;
            }
            return -1L;
        }
        byte[] bArrO2 = targetBytes.o();
        while (size < size()) {
            byte[] bArr4 = u0Var.f34826a;
            i10 = (int) ((((long) u0Var.f34827b) + j10) - size);
            int i15 = u0Var.f34828c;
            while (i10 < i15) {
                byte b14 = bArr4[i10];
                for (byte b15 : bArrO2) {
                    if (b14 == b15) {
                        i11 = u0Var.f34827b;
                    }
                }
                i10++;
            }
            size += (long) (u0Var.f34828c - u0Var.f34827b);
            u0Var = u0Var.f34831f;
            kotlin.jvm.internal.t.f(u0Var);
            j10 = size;
        }
        return -1L;
        return ((long) (i10 - i11)) + size;
    }

    @Override // ua.d
    @NotNull
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public c writeByte(int i10) {
        u0 u0VarO0 = O0(1);
        byte[] bArr = u0VarO0.f34826a;
        int i11 = u0VarO0.f34828c;
        u0VarO0.f34828c = i11 + 1;
        bArr[i11] = (byte) i10;
        L0(size() + 1);
        return this;
    }

    @Override // ua.e
    public short T() throws EOFException {
        return f1.h(readShort());
    }

    @Override // ua.d
    @NotNull
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public c b0(long j10) {
        boolean z10;
        if (j10 == 0) {
            return writeByte(48);
        }
        int i10 = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return E("-9223372036854775808");
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (j10 >= 100000000) {
            i10 = j10 < MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US ? j10 < 10000000000L ? j10 < C.NANOS_PER_SECOND ? 9 : 10 : j10 < 100000000000L ? 11 : 12 : j10 < 1000000000000000L ? j10 < 10000000000000L ? 13 : j10 < 100000000000000L ? 14 : 15 : j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
        } else if (j10 >= 10000) {
            i10 = j10 < 1000000 ? j10 < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US ? 5 : 6 : j10 < 10000000 ? 7 : 8;
        } else if (j10 >= 100) {
            i10 = j10 < 1000 ? 3 : 4;
        } else if (j10 >= 10) {
            i10 = 2;
        }
        if (z10) {
            i10++;
        }
        u0 u0VarO0 = O0(i10);
        byte[] bArr = u0VarO0.f34826a;
        int i11 = u0VarO0.f34828c + i10;
        while (j10 != 0) {
            long j11 = 10;
            i11--;
            bArr[i11] = va.f.a()[(int) (j10 % j11)];
            j10 /= j11;
        }
        if (z10) {
            bArr[i11 - 1] = (byte) 45;
        }
        u0VarO0.f34828c += i10;
        L0(size() + ((long) i10));
        return this;
    }

    @Override // ua.e
    public long U() throws EOFException {
        return f1.g(I0());
    }

    @Override // ua.d
    @NotNull
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public c v0(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & 6148914691236517205L);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        u0 u0VarO0 = O0(i10);
        byte[] bArr = u0VarO0.f34826a;
        int i11 = u0VarO0.f34828c;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = va.f.a()[(int) (15 & j10)];
            j10 >>>= 4;
        }
        u0VarO0.f34828c += i10;
        L0(size() + ((long) i10));
        return this;
    }

    @Override // ua.e
    public long V(@NotNull x0 sink) throws IOException {
        kotlin.jvm.internal.t.i(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.G(this, size);
        }
        return size;
    }

    @Override // ua.d
    @NotNull
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public c writeInt(int i10) {
        u0 u0VarO0 = O0(4);
        byte[] bArr = u0VarO0.f34826a;
        int i11 = u0VarO0.f34828c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >>> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >>> 8) & 255);
        bArr[i14] = (byte) (i10 & 255);
        u0VarO0.f34828c = i14 + 1;
        L0(size() + 4);
        return this;
    }

    public boolean W(long j10, @NotNull f bytes) {
        kotlin.jvm.internal.t.i(bytes, "bytes");
        return h0(j10, bytes, 0, bytes.B());
    }

    @NotNull
    public c W0(int i10) {
        return writeInt(f1.f(i10));
    }

    @Override // ua.e
    public int X(@NotNull n0 options) throws EOFException {
        kotlin.jvm.internal.t.i(options, "options");
        int iD = va.f.d(this, options, false, 2, null);
        if (iD == -1) {
            return -1;
        }
        skip(options.e()[iD].B());
        return iD;
    }

    @Override // ua.d
    @NotNull
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public c writeShort(int i10) {
        u0 u0VarO0 = O0(2);
        byte[] bArr = u0VarO0.f34826a;
        int i11 = u0VarO0.f34828c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i12] = (byte) (i10 & 255);
        u0VarO0.f34828c = i12 + 1;
        L0(size() + 2);
        return this;
    }

    @NotNull
    public c Y0(@NotNull String string, int i10, int i11, @NotNull Charset charset) {
        kotlin.jvm.internal.t.i(string, "string");
        kotlin.jvm.internal.t.i(charset, "charset");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
        }
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        if (!(i11 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + string.length()).toString());
        }
        if (kotlin.jvm.internal.t.d(charset, p9.d.f32952b)) {
            return b1(string, i10, i11);
        }
        String strSubstring = string.substring(i10, i11);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes = strSubstring.getBytes(charset);
        kotlin.jvm.internal.t.h(bytes, "this as java.lang.String).getBytes(charset)");
        return write(bytes, 0, bytes.length);
    }

    @NotNull
    public c Z0(@NotNull String string, @NotNull Charset charset) {
        kotlin.jvm.internal.t.i(string, "string");
        kotlin.jvm.internal.t.i(charset, "charset");
        return Y0(string, 0, string.length(), charset);
    }

    @Override // ua.e
    public void a0(long j10) throws EOFException {
        if (this.f34739b < j10) {
            throw new EOFException();
        }
    }

    @Override // ua.d
    @NotNull
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public c E(@NotNull String string) {
        kotlin.jvm.internal.t.i(string, "string");
        return b1(string, 0, string.length());
    }

    @NotNull
    public c b1(@NotNull String string, int i10, int i11) {
        char cCharAt;
        kotlin.jvm.internal.t.i(string, "string");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
        }
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        if (!(i11 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + string.length()).toString());
        }
        while (i10 < i11) {
            char cCharAt2 = string.charAt(i10);
            if (cCharAt2 < 128) {
                u0 u0VarO0 = O0(1);
                byte[] bArr = u0VarO0.f34826a;
                int i12 = u0VarO0.f34828c - i10;
                int iMin = Math.min(i11, 8192 - i12);
                int i13 = i10 + 1;
                bArr[i10 + i12] = (byte) cCharAt2;
                while (true) {
                    i10 = i13;
                    if (i10 >= iMin || (cCharAt = string.charAt(i10)) >= 128) {
                        break;
                    }
                    i13 = i10 + 1;
                    bArr[i10 + i12] = (byte) cCharAt;
                }
                int i14 = u0VarO0.f34828c;
                int i15 = (i12 + i10) - i14;
                u0VarO0.f34828c = i14 + i15;
                L0(size() + ((long) i15));
            } else {
                if (cCharAt2 < 2048) {
                    u0 u0VarO02 = O0(2);
                    byte[] bArr2 = u0VarO02.f34826a;
                    int i16 = u0VarO02.f34828c;
                    bArr2[i16] = (byte) ((cCharAt2 >> 6) | PsExtractor.AUDIO_STREAM);
                    bArr2[i16 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    u0VarO02.f34828c = i16 + 2;
                    L0(size() + 2);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    u0 u0VarO03 = O0(3);
                    byte[] bArr3 = u0VarO03.f34826a;
                    int i17 = u0VarO03.f34828c;
                    bArr3[i17] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i17 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i17 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    u0VarO03.f34828c = i17 + 3;
                    L0(size() + 3);
                } else {
                    int i18 = i10 + 1;
                    char cCharAt3 = i18 < i11 ? string.charAt(i18) : (char) 0;
                    if (cCharAt2 <= 56319) {
                        if (56320 <= cCharAt3 && cCharAt3 < 57344) {
                            int i19 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                            u0 u0VarO04 = O0(4);
                            byte[] bArr4 = u0VarO04.f34826a;
                            int i20 = u0VarO04.f34828c;
                            bArr4[i20] = (byte) ((i19 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                            bArr4[i20 + 1] = (byte) (((i19 >> 12) & 63) | 128);
                            bArr4[i20 + 2] = (byte) (((i19 >> 6) & 63) | 128);
                            bArr4[i20 + 3] = (byte) ((i19 & 63) | 128);
                            u0VarO04.f34828c = i20 + 4;
                            L0(size() + 4);
                            i10 += 2;
                        }
                    }
                    writeByte(63);
                    i10 = i18;
                }
                i10++;
            }
        }
        return this;
    }

    public final void c() throws EOFException {
        skip(size());
    }

    @NotNull
    public c c1(int i10) {
        if (i10 < 128) {
            writeByte(i10);
        } else if (i10 < 2048) {
            u0 u0VarO0 = O0(2);
            byte[] bArr = u0VarO0.f34826a;
            int i11 = u0VarO0.f34828c;
            bArr[i11] = (byte) ((i10 >> 6) | PsExtractor.AUDIO_STREAM);
            bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
            u0VarO0.f34828c = i11 + 2;
            L0(size() + 2);
        } else {
            boolean z10 = false;
            if (55296 <= i10 && i10 < 57344) {
                z10 = true;
            }
            if (z10) {
                writeByte(63);
            } else if (i10 < 65536) {
                u0 u0VarO02 = O0(3);
                byte[] bArr2 = u0VarO02.f34826a;
                int i12 = u0VarO02.f34828c;
                bArr2[i12] = (byte) ((i10 >> 12) | 224);
                bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | 128);
                bArr2[i12 + 2] = (byte) ((i10 & 63) | 128);
                u0VarO02.f34828c = i12 + 3;
                L0(size() + 3);
            } else {
                if (i10 > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: 0x" + f1.j(i10));
                }
                u0 u0VarO03 = O0(4);
                byte[] bArr3 = u0VarO03.f34826a;
                int i13 = u0VarO03.f34828c;
                bArr3[i13] = (byte) ((i10 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                bArr3[i13 + 3] = (byte) ((i10 & 63) | 128);
                u0VarO03.f34828c = i13 + 4;
                L0(size() + 4);
            }
        }
        return this;
    }

    @Override // ua.e
    @NotNull
    public String d0(long j10) throws EOFException {
        return J0(j10, p9.d.f32952b);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (size() == cVar.size()) {
                if (size() == 0) {
                    return true;
                }
                u0 u0Var = this.f34738a;
                kotlin.jvm.internal.t.f(u0Var);
                u0 u0Var2 = cVar.f34738a;
                kotlin.jvm.internal.t.f(u0Var2);
                int i10 = u0Var.f34827b;
                int i11 = u0Var2.f34827b;
                long j10 = 0;
                while (j10 < size()) {
                    long jMin = Math.min(u0Var.f34828c - i10, u0Var2.f34828c - i11);
                    long j11 = 0;
                    while (j11 < jMin) {
                        int i12 = i10 + 1;
                        int i13 = i11 + 1;
                        if (u0Var.f34826a[i10] == u0Var2.f34826a[i11]) {
                            j11++;
                            i10 = i12;
                            i11 = i13;
                        }
                    }
                    if (i10 == u0Var.f34828c) {
                        u0Var = u0Var.f34831f;
                        kotlin.jvm.internal.t.f(u0Var);
                        i10 = u0Var.f34827b;
                    }
                    if (i11 == u0Var2.f34828c) {
                        u0Var2 = u0Var2.f34831f;
                        kotlin.jvm.internal.t.f(u0Var2);
                        i11 = u0Var2.f34827b;
                    }
                    j10 += jMin;
                }
                return true;
            }
        }
        return false;
    }

    @Override // ua.e
    @NotNull
    public f f0(long j10) throws EOFException {
        if (!(j10 >= 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (size() < j10) {
            throw new EOFException();
        }
        if (j10 < 4096) {
            return new f(P(j10));
        }
        f fVarN0 = N0((int) j10);
        skip(j10);
        return fVarN0;
    }

    public boolean h0(long j10, @NotNull f bytes, int i10, int i11) {
        kotlin.jvm.internal.t.i(bytes, "bytes");
        if (j10 < 0 || i10 < 0 || i11 < 0 || size() - j10 < i11 || bytes.B() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (L(((long) i12) + j10) != bytes.f(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        u0 u0Var = this.f34738a;
        if (u0Var == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = u0Var.f34828c;
            for (int i12 = u0Var.f34827b; i12 < i11; i12++) {
                i10 = (i10 * 31) + u0Var.f34826a[i12];
            }
            u0Var = u0Var.f34831f;
            kotlin.jvm.internal.t.f(u0Var);
        } while (u0Var != this.f34738a);
        return i10;
    }

    @NotNull
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public c clone() {
        return x();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // ua.e
    @NotNull
    public byte[] l0() {
        return P(size());
    }

    @Override // ua.e
    public boolean m0() {
        return this.f34739b == 0;
    }

    @Override // ua.e
    public long p0() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        int i10 = 0;
        boolean z10 = false;
        long j10 = 0;
        long j11 = -7;
        boolean z11 = false;
        do {
            u0 u0Var = this.f34738a;
            kotlin.jvm.internal.t.f(u0Var);
            byte[] bArr = u0Var.f34826a;
            int i11 = u0Var.f34827b;
            int i12 = u0Var.f34828c;
            while (i11 < i12) {
                byte b10 = bArr[i11];
                byte b11 = (byte) 48;
                if (b10 >= b11 && b10 <= ((byte) 57)) {
                    int i13 = b11 - b10;
                    if (j10 < -922337203685477580L || (j10 == -922337203685477580L && i13 < j11)) {
                        c cVarWriteByte = new c().b0(j10).writeByte(b10);
                        if (!z10) {
                            cVarWriteByte.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + cVarWriteByte.K0());
                    }
                    j10 = (j10 * 10) + ((long) i13);
                } else {
                    if (b10 != ((byte) 45) || i10 != 0) {
                        z11 = true;
                        break;
                    }
                    j11--;
                    z10 = true;
                }
                i11++;
                i10++;
            }
            if (i11 == i12) {
                this.f34738a = u0Var.b();
                v0.b(u0Var);
            } else {
                u0Var.f34827b = i11;
            }
            if (z11) {
                break;
            }
        } while (this.f34738a != null);
        L0(size() - ((long) i10));
        if (i10 >= (z10 ? 2 : 1)) {
            return z10 ? j10 : -j10;
        }
        if (size() == 0) {
            throw new EOFException();
        }
        throw new NumberFormatException((z10 ? "Expected a digit" : "Expected a digit or '-'") + " but was 0x" + f1.i(L(0L)));
    }

    @Override // ua.e
    @NotNull
    public e peek() {
        return k0.d(new r0(this));
    }

    public final long q() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        u0 u0Var = this.f34738a;
        kotlin.jvm.internal.t.f(u0Var);
        u0 u0Var2 = u0Var.f34832g;
        kotlin.jvm.internal.t.f(u0Var2);
        int i10 = u0Var2.f34828c;
        if (i10 < 8192 && u0Var2.f34830e) {
            size -= (long) (i10 - u0Var2.f34827b);
        }
        return size;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@NotNull ByteBuffer sink) throws IOException {
        kotlin.jvm.internal.t.i(sink, "sink");
        u0 u0Var = this.f34738a;
        if (u0Var == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), u0Var.f34828c - u0Var.f34827b);
        sink.put(u0Var.f34826a, u0Var.f34827b, iMin);
        int i10 = u0Var.f34827b + iMin;
        u0Var.f34827b = i10;
        this.f34739b -= (long) iMin;
        if (i10 == u0Var.f34828c) {
            this.f34738a = u0Var.b();
            v0.b(u0Var);
        }
        return iMin;
    }

    @Override // ua.e
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        u0 u0Var = this.f34738a;
        kotlin.jvm.internal.t.f(u0Var);
        int i10 = u0Var.f34827b;
        int i11 = u0Var.f34828c;
        int i12 = i10 + 1;
        byte b10 = u0Var.f34826a[i10];
        L0(size() - 1);
        if (i12 == i11) {
            this.f34738a = u0Var.b();
            v0.b(u0Var);
        } else {
            u0Var.f34827b = i12;
        }
        return b10;
    }

    @Override // ua.e
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        u0 u0Var = this.f34738a;
        kotlin.jvm.internal.t.f(u0Var);
        int i10 = u0Var.f34827b;
        int i11 = u0Var.f34828c;
        if (i11 - i10 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = u0Var.f34826a;
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((bArr[i10] & 255) << 24) | ((bArr[i12] & 255) << 16);
        int i15 = i13 + 1;
        int i16 = i14 | ((bArr[i13] & 255) << 8);
        int i17 = i15 + 1;
        int i18 = i16 | (bArr[i15] & 255);
        L0(size() - 4);
        if (i17 == i11) {
            this.f34738a = u0Var.b();
            v0.b(u0Var);
        } else {
            u0Var.f34827b = i17;
        }
        return i18;
    }

    @Override // ua.e
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        u0 u0Var = this.f34738a;
        kotlin.jvm.internal.t.f(u0Var);
        int i10 = u0Var.f34827b;
        int i11 = u0Var.f34828c;
        if (i11 - i10 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = u0Var.f34826a;
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((bArr[i10] & 255) << 8) | (bArr[i12] & 255);
        L0(size() - 2);
        if (i13 == i11) {
            this.f34738a = u0Var.b();
            v0.b(u0Var);
        } else {
            u0Var.f34827b = i13;
        }
        return (short) i14;
    }

    @Override // ua.d
    public long s(@NotNull z0 source) throws IOException {
        kotlin.jvm.internal.t.i(source, "source");
        long j10 = 0;
        while (true) {
            long j11 = source.read(this, 8192L);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
        }
    }

    @Override // ua.e
    @NotNull
    public String s0(@NotNull Charset charset) {
        kotlin.jvm.internal.t.i(charset, "charset");
        return J0(this.f34739b, charset);
    }

    public final long size() {
        return this.f34739b;
    }

    @Override // ua.e
    public void skip(long j10) throws EOFException {
        while (j10 > 0) {
            u0 u0Var = this.f34738a;
            if (u0Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j10, u0Var.f34828c - u0Var.f34827b);
            long j11 = iMin;
            L0(size() - j11);
            j10 -= j11;
            int i10 = u0Var.f34827b + iMin;
            u0Var.f34827b = i10;
            if (i10 == u0Var.f34828c) {
                this.f34738a = u0Var.b();
                v0.b(u0Var);
            }
        }
    }

    @Override // ua.z0
    @NotNull
    public a1 timeout() {
        return a1.f34734e;
    }

    @NotNull
    public String toString() {
        return M0().toString();
    }

    @Override // ua.e
    @NotNull
    public f w0() {
        return f0(size());
    }

    @NotNull
    public final c x() {
        c cVar = new c();
        if (size() != 0) {
            u0 u0Var = this.f34738a;
            kotlin.jvm.internal.t.f(u0Var);
            u0 u0VarD = u0Var.d();
            cVar.f34738a = u0VarD;
            u0VarD.f34832g = u0VarD;
            u0VarD.f34831f = u0VarD;
            for (u0 u0Var2 = u0Var.f34831f; u0Var2 != u0Var; u0Var2 = u0Var2.f34831f) {
                u0 u0Var3 = u0VarD.f34832g;
                kotlin.jvm.internal.t.f(u0Var3);
                kotlin.jvm.internal.t.f(u0Var2);
                u0Var3.c(u0Var2.d());
            }
            cVar.L0(size());
        }
        return cVar;
    }

    @Override // ua.e
    @NotNull
    public String y(long j10) throws EOFException {
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j10).toString());
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        byte b10 = (byte) 10;
        long jO = O(b10, 0L, j11);
        if (jO != -1) {
            return va.f.b(this, jO);
        }
        if (j11 < size() && L(j11 - 1) == ((byte) 13) && L(j11) == b10) {
            return va.f.b(this, j11);
        }
        c cVar = new c();
        z(cVar, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j10) + " content=" + cVar.w0().k() + (char) 8230);
    }

    @Override // ua.e
    public int y0() throws EOFException {
        return f1.f(readInt());
    }

    @NotNull
    public final c z(@NotNull c out, long j10, long j11) {
        kotlin.jvm.internal.t.i(out, "out");
        f1.b(size(), j10, j11);
        if (j11 != 0) {
            out.L0(out.size() + j11);
            u0 u0Var = this.f34738a;
            while (true) {
                kotlin.jvm.internal.t.f(u0Var);
                int i10 = u0Var.f34828c;
                int i11 = u0Var.f34827b;
                if (j10 < i10 - i11) {
                    break;
                }
                j10 -= (long) (i10 - i11);
                u0Var = u0Var.f34831f;
            }
            while (j11 > 0) {
                kotlin.jvm.internal.t.f(u0Var);
                u0 u0VarD = u0Var.d();
                int i12 = u0VarD.f34827b + ((int) j10);
                u0VarD.f34827b = i12;
                u0VarD.f34828c = Math.min(i12 + ((int) j11), u0VarD.f34828c);
                u0 u0Var2 = out.f34738a;
                if (u0Var2 == null) {
                    u0VarD.f34832g = u0VarD;
                    u0VarD.f34831f = u0VarD;
                    out.f34738a = u0VarD;
                } else {
                    kotlin.jvm.internal.t.f(u0Var2);
                    u0 u0Var3 = u0Var2.f34832g;
                    kotlin.jvm.internal.t.f(u0Var3);
                    u0Var3.c(u0VarD);
                }
                j11 -= (long) (u0VarD.f34828c - u0VarD.f34827b);
                u0Var = u0Var.f34831f;
                j10 = 0;
            }
        }
        return this;
    }

    /* JADX INFO: compiled from: Buffer.kt */
    public static final class b extends InputStream {
        b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(c.this.size(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream
        public int read() {
            if (c.this.size() > 0) {
                return c.this.readByte() & 255;
            }
            return -1;
        }

        @NotNull
        public String toString() {
            return c.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(@NotNull byte[] sink, int i10, int i11) {
            kotlin.jvm.internal.t.i(sink, "sink");
            return c.this.read(sink, i10, i11);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@NotNull ByteBuffer source) throws IOException {
        kotlin.jvm.internal.t.i(source, "source");
        int iRemaining = source.remaining();
        int i10 = iRemaining;
        while (i10 > 0) {
            u0 u0VarO0 = O0(1);
            int iMin = Math.min(i10, 8192 - u0VarO0.f34828c);
            source.get(u0VarO0.f34826a, u0VarO0.f34828c, iMin);
            i10 -= iMin;
            u0VarO0.f34828c += iMin;
        }
        this.f34739b += (long) iRemaining;
        return iRemaining;
    }

    public int read(@NotNull byte[] sink, int i10, int i11) {
        kotlin.jvm.internal.t.i(sink, "sink");
        f1.b(sink.length, i10, i11);
        u0 u0Var = this.f34738a;
        if (u0Var == null) {
            return -1;
        }
        int iMin = Math.min(i11, u0Var.f34828c - u0Var.f34827b);
        byte[] bArr = u0Var.f34826a;
        int i12 = u0Var.f34827b;
        kotlin.collections.o.d(bArr, sink, i10, i12, i12 + iMin);
        u0Var.f34827b += iMin;
        L0(size() - ((long) iMin));
        if (u0Var.f34827b == u0Var.f34828c) {
            this.f34738a = u0Var.b();
            v0.b(u0Var);
        }
        return iMin;
    }

    @Override // ua.z0
    public long read(@NotNull c sink, long j10) {
        kotlin.jvm.internal.t.i(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j10 > size()) {
            j10 = size();
        }
        sink.G(this, j10);
        return j10;
    }

    @Override // ua.d
    @NotNull
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public c o() {
        return this;
    }

    @Override // ua.d
    @NotNull
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public c w() {
        return this;
    }

    @Override // ua.z0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // ua.d, ua.x0, java.io.Flushable
    public void flush() {
    }

    @Override // ua.e, ua.d
    @NotNull
    public c g() {
        return this;
    }
}

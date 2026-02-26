package l3;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: BundledExtractorsAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p2.r f30461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private p2.l f30462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private p2.m f30463c;

    public b(p2.r rVar) {
        this.f30461a = rVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    @Override // l3.j0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(z3.h r8, android.net.Uri r9, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10, long r11, long r13, p2.n r15) throws java.io.IOException {
        /*
            r7 = this;
            p2.f r6 = new p2.f
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.f30463c = r6
            p2.l r8 = r7.f30462b
            if (r8 == 0) goto L10
            return
        L10:
            p2.r r8 = r7.f30461a
            p2.l[] r8 = r8.createExtractors(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L20
            r8 = r8[r13]
            r7.f30462b = r8
            goto L74
        L20:
            int r10 = r8.length
            r0 = r13
        L22:
            if (r0 >= r10) goto L70
            r1 = r8[r0]
            boolean r2 = r1.c(r6)     // Catch: java.lang.Throwable -> L42 java.io.EOFException -> L57
            if (r2 == 0) goto L35
            r7.f30462b = r1     // Catch: java.lang.Throwable -> L42 java.io.EOFException -> L57
            a4.a.g(r14)
            r6.resetPeekPosition()
            goto L70
        L35:
            p2.l r1 = r7.f30462b
            if (r1 != 0) goto L66
            long r1 = r6.getPosition()
            int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r1 != 0) goto L64
            goto L66
        L42:
            r8 = move-exception
            p2.l r9 = r7.f30462b
            if (r9 != 0) goto L4f
            long r9 = r6.getPosition()
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto L50
        L4f:
            r13 = r14
        L50:
            a4.a.g(r13)
            r6.resetPeekPosition()
            throw r8
        L57:
            p2.l r1 = r7.f30462b
            if (r1 != 0) goto L66
            long r1 = r6.getPosition()
            int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r1 != 0) goto L64
            goto L66
        L64:
            r1 = r13
            goto L67
        L66:
            r1 = r14
        L67:
            a4.a.g(r1)
            r6.resetPeekPosition()
            int r0 = r0 + 1
            goto L22
        L70:
            p2.l r10 = r7.f30462b
            if (r10 == 0) goto L7a
        L74:
            p2.l r8 = r7.f30462b
            r8.b(r15)
            return
        L7a:
            l3.f1 r10 = new l3.f1
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "None of the available extractors ("
            r11.append(r12)
            java.lang.String r8 = a4.o0.G(r8)
            r11.append(r8)
            java.lang.String r8 = ") could read the stream."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            java.lang.Object r9 = a4.a.e(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            r10.<init>(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.b.a(z3.h, android.net.Uri, java.util.Map, long, long, p2.n):void");
    }

    @Override // l3.j0
    public int b(p2.a0 a0Var) throws IOException {
        return ((p2.l) a4.a.e(this.f30462b)).a((p2.m) a4.a.e(this.f30463c), a0Var);
    }

    @Override // l3.j0
    public void disableSeekingOnMp3Streams() {
        p2.l lVar = this.f30462b;
        if (lVar instanceof w2.f) {
            ((w2.f) lVar).i();
        }
    }

    @Override // l3.j0
    public long getCurrentInputPosition() {
        p2.m mVar = this.f30463c;
        if (mVar != null) {
            return mVar.getPosition();
        }
        return -1L;
    }

    @Override // l3.j0
    public void release() {
        p2.l lVar = this.f30462b;
        if (lVar != null) {
            lVar.release();
            this.f30462b = null;
        }
        this.f30463c = null;
    }

    @Override // l3.j0
    public void seek(long j10, long j11) {
        ((p2.l) a4.a.e(this.f30462b)).seek(j10, j11);
    }
}

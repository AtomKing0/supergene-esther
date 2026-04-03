package p9;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes5.dex */
final class e implements o9.g<n9.i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final CharSequence f32960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f32961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f32962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final h9.p<CharSequence, Integer, v8.s<Integer, Integer>> f32963d;

    /* JADX INFO: compiled from: Strings.kt */
    public static final class a implements Iterator<n9.i>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f32964a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f32965b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f32966c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private n9.i f32967d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f32968e;

        a() {
            int iN = n9.o.n(e.this.f32961b, 0, e.this.f32960a.length());
            this.f32965b = iN;
            this.f32966c = iN;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f32966c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f32964a = r1
                r0 = 0
                r6.f32967d = r0
                goto L9e
            Lc:
                p9.e r0 = p9.e.this
                int r0 = p9.e.e(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f32968e
                int r0 = r0 + r3
                r6.f32968e = r0
                p9.e r4 = p9.e.this
                int r4 = p9.e.e(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f32966c
                p9.e r4 = p9.e.this
                java.lang.CharSequence r4 = p9.e.d(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                n9.i r0 = new n9.i
                int r1 = r6.f32965b
                p9.e r4 = p9.e.this
                java.lang.CharSequence r4 = p9.e.d(r4)
                int r4 = p9.h.Y(r4)
                r0.<init>(r1, r4)
                r6.f32967d = r0
                r6.f32966c = r2
                goto L9c
            L47:
                p9.e r0 = p9.e.this
                h9.p r0 = p9.e.c(r0)
                p9.e r4 = p9.e.this
                java.lang.CharSequence r4 = p9.e.d(r4)
                int r5 = r6.f32966c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.mo4invoke(r4, r5)
                v8.s r0 = (v8.s) r0
                if (r0 != 0) goto L77
                n9.i r0 = new n9.i
                int r1 = r6.f32965b
                p9.e r4 = p9.e.this
                java.lang.CharSequence r4 = p9.e.d(r4)
                int r4 = p9.h.Y(r4)
                r0.<init>(r1, r4)
                r6.f32967d = r0
                r6.f32966c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f32965b
                n9.i r4 = n9.m.u(r4, r2)
                r6.f32967d = r4
                int r2 = r2 + r0
                r6.f32965b = r2
                if (r0 != 0) goto L99
                r1 = r3
            L99:
                int r2 = r2 + r1
                r6.f32966c = r2
            L9c:
                r6.f32964a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p9.e.a.a():void");
        }

        @Override // java.util.Iterator
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public n9.i next() {
            if (this.f32964a == -1) {
                a();
            }
            if (this.f32964a == 0) {
                throw new NoSuchElementException();
            }
            n9.i iVar = this.f32967d;
            kotlin.jvm.internal.t.g(iVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f32967d = null;
            this.f32964a = -1;
            return iVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f32964a == -1) {
                a();
            }
            return this.f32964a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull CharSequence input, int i10, int i11, @NotNull h9.p<? super CharSequence, ? super Integer, v8.s<Integer, Integer>> getNextMatch) {
        kotlin.jvm.internal.t.i(input, "input");
        kotlin.jvm.internal.t.i(getNextMatch, "getNextMatch");
        this.f32960a = input;
        this.f32961b = i10;
        this.f32962c = i11;
        this.f32963d = getNextMatch;
    }

    @Override // o9.g
    @NotNull
    public Iterator<n9.i> iterator() {
        return new a();
    }
}

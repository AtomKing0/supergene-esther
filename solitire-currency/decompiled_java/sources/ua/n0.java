package ua;

import java.io.IOException;
import java.util.List;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Options.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class n0 extends kotlin.collections.c<f> implements RandomAccess {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f34787c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final f[] f34788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final int[] f34789b;

    /* JADX INFO: compiled from: Options.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        private final void a(long j10, c cVar, int i10, List<? extends f> list, int i11, int i12, List<Integer> list2) throws IOException {
            int i13;
            int i14;
            int i15;
            int i16;
            c cVar2;
            int i17 = i10;
            if (!(i11 < i12)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i18 = i11; i18 < i12; i18++) {
                if (!(list.get(i18).B() >= i17)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            f fVar = list.get(i11);
            f fVar2 = list.get(i12 - 1);
            int i19 = -1;
            if (i17 == fVar.B()) {
                int iIntValue = list2.get(i11).intValue();
                int i20 = i11 + 1;
                f fVar3 = list.get(i20);
                i13 = i20;
                i14 = iIntValue;
                fVar = fVar3;
            } else {
                i13 = i11;
                i14 = -1;
            }
            if (fVar.f(i17) == fVar2.f(i17)) {
                int iMin = Math.min(fVar.B(), fVar2.B());
                int i21 = 0;
                for (int i22 = i17; i22 < iMin && fVar.f(i22) == fVar2.f(i22); i22++) {
                    i21++;
                }
                long jC = j10 + c(cVar) + ((long) 2) + ((long) i21) + 1;
                cVar.writeInt(-i21);
                cVar.writeInt(i14);
                int i23 = i17 + i21;
                while (i17 < i23) {
                    cVar.writeInt(fVar.f(i17) & 255);
                    i17++;
                }
                if (i13 + 1 == i12) {
                    if (!(i23 == list.get(i13).B())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    cVar.writeInt(list2.get(i13).intValue());
                    return;
                } else {
                    c cVar3 = new c();
                    cVar.writeInt(((int) (c(cVar3) + jC)) * (-1));
                    a(jC, cVar3, i23, list, i13, i12, list2);
                    cVar.s(cVar3);
                    return;
                }
            }
            int i24 = 1;
            for (int i25 = i13 + 1; i25 < i12; i25++) {
                if (list.get(i25 - 1).f(i17) != list.get(i25).f(i17)) {
                    i24++;
                }
            }
            long jC2 = j10 + c(cVar) + ((long) 2) + ((long) (i24 * 2));
            cVar.writeInt(i24);
            cVar.writeInt(i14);
            for (int i26 = i13; i26 < i12; i26++) {
                byte bF = list.get(i26).f(i17);
                if (i26 == i13 || bF != list.get(i26 - 1).f(i17)) {
                    cVar.writeInt(bF & 255);
                }
            }
            c cVar4 = new c();
            while (i13 < i12) {
                byte bF2 = list.get(i13).f(i17);
                int i27 = i13 + 1;
                int i28 = i27;
                while (true) {
                    if (i28 >= i12) {
                        i15 = i12;
                        break;
                    } else {
                        if (bF2 != list.get(i28).f(i17)) {
                            i15 = i28;
                            break;
                        }
                        i28++;
                    }
                }
                if (i27 == i15 && i17 + 1 == list.get(i13).B()) {
                    cVar.writeInt(list2.get(i13).intValue());
                    i16 = i15;
                    cVar2 = cVar4;
                } else {
                    cVar.writeInt(((int) (jC2 + c(cVar4))) * i19);
                    i16 = i15;
                    cVar2 = cVar4;
                    a(jC2, cVar4, i17 + 1, list, i13, i15, list2);
                }
                cVar4 = cVar2;
                i13 = i16;
                i19 = -1;
            }
            cVar.s(cVar4);
        }

        static /* synthetic */ void b(a aVar, long j10, c cVar, int i10, List list, int i11, int i12, List list2, int i13, Object obj) throws IOException {
            aVar.a((i13 & 1) != 0 ? 0L : j10, cVar, (i13 & 4) != 0 ? 0 : i10, list, (i13 & 16) != 0 ? 0 : i11, (i13 & 32) != 0 ? list.size() : i12, list2);
        }

        private final long c(c cVar) {
            return cVar.size() / ((long) 4);
        }

        /* JADX WARN: Code restructure failed: missing block: B:58:0x00eb, code lost:
        
            continue;
         */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final ua.n0 d(@org.jetbrains.annotations.NotNull ua.f... r17) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 332
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ua.n0.a.d(ua.f[]):ua.n0");
        }
    }

    public /* synthetic */ n0(f[] fVarArr, int[] iArr, kotlin.jvm.internal.k kVar) {
        this(fVarArr, iArr);
    }

    public /* bridge */ boolean a(f fVar) {
        return super.contains(fVar);
    }

    @Override // kotlin.collections.c, java.util.List
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public f get(int i10) {
        return this.f34788a[i10];
    }

    @Override // kotlin.collections.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof f) {
            return a((f) obj);
        }
        return false;
    }

    @NotNull
    public final f[] e() {
        return this.f34788a;
    }

    @NotNull
    public final int[] f() {
        return this.f34789b;
    }

    public /* bridge */ int g(f fVar) {
        return super.indexOf(fVar);
    }

    @Override // kotlin.collections.c, kotlin.collections.a
    public int getSize() {
        return this.f34788a.length;
    }

    public /* bridge */ int h(f fVar) {
        return super.lastIndexOf(fVar);
    }

    @Override // kotlin.collections.c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof f) {
            return g((f) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof f) {
            return h((f) obj);
        }
        return -1;
    }

    private n0(f[] fVarArr, int[] iArr) {
        this.f34788a = fVarArr;
        this.f34789b = iArr;
    }
}

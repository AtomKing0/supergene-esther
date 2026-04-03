package androidx.compose.runtime.snapshots;

import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.runtime.Immutable;
import h9.l;
import h9.p;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.d0;
import kotlin.collections.o;
import kotlin.collections.w;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import o9.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: SnapshotIdSet.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class SnapshotIdSet implements Iterable<Integer>, i9.a {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, null);

    @Nullable
    private final int[] belowBound;
    private final int lowerBound;
    private final long lowerSet;
    private final long upperSet;

    /* JADX INFO: compiled from: SnapshotIdSet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: SnapshotIdSet.kt */
    @f(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", l = {295, AnimationConstants.DefaultDurationMillis, 307}, m = "invokeSuspend")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.k implements p<i<? super Integer>, d<? super k0>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(d<? super AnonymousClass1> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass1 anonymousClass1 = SnapshotIdSet.this.new AnonymousClass1(dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00c9  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0078 -> B:19:0x007b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x009b -> B:31:0x00b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b4 -> B:31:0x00b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00f0 -> B:43:0x00f4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00f3 -> B:43:0x00f4). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 249
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull i<? super Integer> iVar, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(iVar, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    private SnapshotIdSet(long j10, long j11, int i10, int[] iArr) {
        this.upperSet = j10;
        this.lowerSet = j11;
        this.lowerBound = i10;
        this.belowBound = iArr;
    }

    @NotNull
    public final SnapshotIdSet and(@NotNull SnapshotIdSet bits) {
        t.i(bits, "bits");
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (t.d(bits, snapshotIdSet) || t.d(this, snapshotIdSet)) {
            return snapshotIdSet;
        }
        int i10 = bits.lowerBound;
        int i11 = this.lowerBound;
        if (i10 == i11) {
            int[] iArr = bits.belowBound;
            int[] iArr2 = this.belowBound;
            if (iArr == iArr2) {
                long j10 = this.upperSet;
                long j11 = bits.upperSet;
                long j12 = j10 & j11;
                long j13 = this.lowerSet;
                long j14 = bits.lowerSet;
                return (j12 == 0 && (j13 & j14) == 0 && iArr2 == null) ? snapshotIdSet : new SnapshotIdSet(j11 & j10, j13 & j14, i11, iArr2);
            }
        }
        if (this.belowBound == null) {
            Iterator<Integer> it = iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (bits.get(iIntValue)) {
                    snapshotIdSet = snapshotIdSet.set(iIntValue);
                }
            }
            return snapshotIdSet;
        }
        Iterator<Integer> it2 = bits.iterator();
        while (it2.hasNext()) {
            int iIntValue2 = it2.next().intValue();
            if (get(iIntValue2)) {
                snapshotIdSet = snapshotIdSet.set(iIntValue2);
            }
        }
        return snapshotIdSet;
    }

    @NotNull
    public final SnapshotIdSet andNot(@NotNull SnapshotIdSet bits) {
        t.i(bits, "bits");
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (bits == snapshotIdSet) {
            return this;
        }
        if (this == snapshotIdSet) {
            return snapshotIdSet;
        }
        int i10 = bits.lowerBound;
        int i11 = this.lowerBound;
        if (i10 == i11) {
            int[] iArr = bits.belowBound;
            int[] iArr2 = this.belowBound;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.upperSet & (~bits.upperSet), this.lowerSet & (~bits.lowerSet), i11, iArr2);
            }
        }
        Iterator<Integer> it = bits.iterator();
        SnapshotIdSet snapshotIdSetClear = this;
        while (it.hasNext()) {
            snapshotIdSetClear = snapshotIdSetClear.clear(it.next().intValue());
        }
        return snapshotIdSetClear;
    }

    @NotNull
    public final SnapshotIdSet clear(int i10) {
        int[] iArr;
        int iBinarySearch;
        int i11 = this.lowerBound;
        int i12 = i10 - i11;
        if (i12 >= 0 && i12 < 64) {
            long j10 = 1 << i12;
            long j11 = this.lowerSet;
            if ((j11 & j10) != 0) {
                return new SnapshotIdSet(this.upperSet, j11 & (~j10), i11, this.belowBound);
            }
        } else if (i12 >= 64 && i12 < 128) {
            long j12 = 1 << (i12 - 64);
            long j13 = this.upperSet;
            if ((j13 & j12) != 0) {
                return new SnapshotIdSet(j13 & (~j12), this.lowerSet, i11, this.belowBound);
            }
        } else if (i12 < 0 && (iArr = this.belowBound) != null && (iBinarySearch = SnapshotIdSetKt.binarySearch(iArr, i10)) >= 0) {
            int length = iArr.length - 1;
            if (length == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, null);
            }
            int[] iArr2 = new int[length];
            if (iBinarySearch > 0) {
                o.g(iArr, iArr2, 0, 0, iBinarySearch);
            }
            if (iBinarySearch < length) {
                o.g(iArr, iArr2, iBinarySearch, iBinarySearch + 1, length + 1);
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr2);
        }
        return this;
    }

    public final void fastForEach(@NotNull l<? super Integer, k0> block) {
        t.i(block, "block");
        int[] iArr = this.belowBound;
        if (iArr != null) {
            for (int i10 : iArr) {
                block.invoke(Integer.valueOf(i10));
            }
        }
        if (this.lowerSet != 0) {
            for (int i11 = 0; i11 < 64; i11++) {
                if ((this.lowerSet & (1 << i11)) != 0) {
                    block.invoke(Integer.valueOf(this.lowerBound + i11));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int i12 = 0; i12 < 64; i12++) {
                if ((this.upperSet & (1 << i12)) != 0) {
                    block.invoke(Integer.valueOf(i12 + 64 + this.lowerBound));
                }
            }
        }
    }

    public final boolean get(int i10) {
        int[] iArr;
        int i11 = i10 - this.lowerBound;
        if (i11 >= 0 && i11 < 64) {
            return ((1 << i11) & this.lowerSet) != 0;
        }
        if (i11 >= 64 && i11 < 128) {
            return ((1 << (i11 - 64)) & this.upperSet) != 0;
        }
        if (i11 <= 0 && (iArr = this.belowBound) != null) {
            return SnapshotIdSetKt.binarySearch(iArr, i10) >= 0;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Integer> iterator() {
        return o9.k.b(new AnonymousClass1(null)).iterator();
    }

    public final int lowest(int i10) {
        int[] iArr = this.belowBound;
        if (iArr != null) {
            return iArr[0];
        }
        long j10 = this.lowerSet;
        if (j10 != 0) {
            return this.lowerBound + SnapshotIdSetKt.lowestBitOf(j10);
        }
        long j11 = this.upperSet;
        return j11 != 0 ? this.lowerBound + 64 + SnapshotIdSetKt.lowestBitOf(j11) : i10;
    }

    @NotNull
    public final SnapshotIdSet or(@NotNull SnapshotIdSet bits) {
        t.i(bits, "bits");
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (bits == snapshotIdSet) {
            return this;
        }
        if (this == snapshotIdSet) {
            return bits;
        }
        int i10 = bits.lowerBound;
        int i11 = this.lowerBound;
        if (i10 == i11) {
            int[] iArr = bits.belowBound;
            int[] iArr2 = this.belowBound;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.upperSet | bits.upperSet, this.lowerSet | bits.lowerSet, i11, iArr2);
            }
        }
        if (this.belowBound == null) {
            Iterator<Integer> it = iterator();
            while (it.hasNext()) {
                bits = bits.set(it.next().intValue());
            }
            return bits;
        }
        Iterator<Integer> it2 = bits.iterator();
        SnapshotIdSet snapshotIdSet2 = this;
        while (it2.hasNext()) {
            snapshotIdSet2 = snapshotIdSet2.set(it2.next().intValue());
        }
        return snapshotIdSet2;
    }

    @NotNull
    public final SnapshotIdSet set(int i10) {
        int i11;
        int[] iArrO0;
        int i12 = this.lowerBound;
        int i13 = i10 - i12;
        long j10 = 0;
        if (i13 >= 0 && i13 < 64) {
            long j11 = 1 << i13;
            long j12 = this.lowerSet;
            if ((j12 & j11) == 0) {
                return new SnapshotIdSet(this.upperSet, j12 | j11, i12, this.belowBound);
            }
        } else if (i13 >= 64 && i13 < 128) {
            long j13 = 1 << (i13 - 64);
            long j14 = this.upperSet;
            if ((j14 & j13) == 0) {
                return new SnapshotIdSet(j14 | j13, this.lowerSet, i12, this.belowBound);
            }
        } else if (i13 < 128) {
            int[] iArr = this.belowBound;
            if (iArr == null) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, i12, new int[]{i10});
            }
            int iBinarySearch = SnapshotIdSetKt.binarySearch(iArr, i10);
            if (iBinarySearch < 0) {
                int i14 = -(iBinarySearch + 1);
                int length = iArr.length + 1;
                int[] iArr2 = new int[length];
                o.g(iArr, iArr2, 0, 0, i14);
                o.g(iArr, iArr2, i14 + 1, i14, length - 1);
                iArr2[i14] = i10;
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr2);
            }
        } else if (!get(i10)) {
            long j15 = this.upperSet;
            long j16 = this.lowerSet;
            int i15 = this.lowerBound;
            int i16 = ((i10 + 1) / 64) * 64;
            ArrayList arrayList = null;
            long j17 = j16;
            long j18 = j15;
            while (true) {
                if (i15 >= i16) {
                    i11 = i15;
                    break;
                }
                if (j17 != j10) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        int[] iArr3 = this.belowBound;
                        if (iArr3 != null) {
                            for (int i17 : iArr3) {
                                arrayList.add(Integer.valueOf(i17));
                            }
                        }
                    }
                    for (int i18 = 0; i18 < 64; i18++) {
                        if (((1 << i18) & j17) != 0) {
                            arrayList.add(Integer.valueOf(i18 + i15));
                        }
                    }
                    j10 = 0;
                }
                if (j18 == j10) {
                    i11 = i16;
                    j17 = j10;
                    break;
                }
                i15 += 64;
                j17 = j18;
                j18 = j10;
            }
            if (arrayList == null || (iArrO0 = d0.O0(arrayList)) == null) {
                iArrO0 = this.belowBound;
            }
            return new SnapshotIdSet(j18, j17, i11, iArrO0).set(i10);
        }
        return this;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [");
        ArrayList arrayList = new ArrayList(w.v(this, 10));
        Iterator<Integer> it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().intValue()));
        }
        sb.append(ListUtilsKt.fastJoinToString$default(arrayList, null, null, null, 0, null, null, 63, null));
        sb.append(']');
        return sb.toString();
    }
}

package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.collections.l0;
import kotlin.collections.y0;
import kotlin.jvm.internal.n0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AmbiguousColumnResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AmbiguousColumnResolver {

    @NotNull
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AmbiguousColumnResolver.kt */
    static final class Match {

        @NotNull
        private final List<Integer> resultIndices;

        @NotNull
        private final n9.i resultRange;

        public Match(@NotNull n9.i resultRange, @NotNull List<Integer> resultIndices) {
            kotlin.jvm.internal.t.i(resultRange, "resultRange");
            kotlin.jvm.internal.t.i(resultIndices, "resultIndices");
            this.resultRange = resultRange;
            this.resultIndices = resultIndices;
        }

        @NotNull
        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        @NotNull
        public final n9.i getResultRange() {
            return this.resultRange;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AmbiguousColumnResolver.kt */
    static final class ResultColumn {
        private final int index;

        @NotNull
        private final String name;

        public ResultColumn(@NotNull String name, int i10) {
            kotlin.jvm.internal.t.i(name, "name");
            this.name = name;
            this.index = i10;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn resultColumn, String str, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = resultColumn.name;
            }
            if ((i11 & 2) != 0) {
                i10 = resultColumn.index;
            }
            return resultColumn.copy(str, i10);
        }

        @NotNull
        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        @NotNull
        public final ResultColumn copy(@NotNull String name, int i10) {
            kotlin.jvm.internal.t.i(name, "name");
            return new ResultColumn(name, i10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            return kotlin.jvm.internal.t.d(this.name, resultColumn.name) && this.index == resultColumn.index;
        }

        public final int getIndex() {
            return this.index;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.index;
        }

        @NotNull
        public String toString() {
            return "ResultColumn(name=" + this.name + ", index=" + this.index + ')';
        }
    }

    /* JADX INFO: compiled from: AmbiguousColumnResolver.kt */
    private static final class Solution implements Comparable<Solution> {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private static final Solution NO_SOLUTION = new Solution(kotlin.collections.v.l(), Integer.MAX_VALUE, Integer.MAX_VALUE);
        private final int coverageOffset;

        @NotNull
        private final List<Match> matches;
        private final int overlaps;

        /* JADX INFO: compiled from: AmbiguousColumnResolver.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final Solution build(@NotNull List<Match> matches) {
                boolean z10;
                kotlin.jvm.internal.t.i(matches, "matches");
                List<Match> list = matches;
                int i10 = 0;
                int iE = 0;
                for (Match match : list) {
                    iE += ((match.getResultRange().e() - match.getResultRange().b()) + 1) - match.getResultIndices().size();
                }
                Iterator<T> it = list.iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                int iB = ((Match) it.next()).getResultRange().b();
                while (it.hasNext()) {
                    int iB2 = ((Match) it.next()).getResultRange().b();
                    if (iB > iB2) {
                        iB = iB2;
                    }
                }
                Iterator<T> it2 = list.iterator();
                if (!it2.hasNext()) {
                    throw new NoSuchElementException();
                }
                int iE2 = ((Match) it2.next()).getResultRange().e();
                while (it2.hasNext()) {
                    int iE3 = ((Match) it2.next()).getResultRange().e();
                    if (iE2 < iE3) {
                        iE2 = iE3;
                    }
                }
                Iterable iVar = new n9.i(iB, iE2);
                if (!(iVar instanceof Collection) || !((Collection) iVar).isEmpty()) {
                    Iterator it3 = iVar.iterator();
                    int i11 = 0;
                    while (it3.hasNext()) {
                        int iNextInt = ((l0) it3).nextInt();
                        Iterator<T> it4 = list.iterator();
                        int i12 = 0;
                        while (true) {
                            if (!it4.hasNext()) {
                                z10 = false;
                                break;
                            }
                            if (((Match) it4.next()).getResultRange().i(iNextInt)) {
                                i12++;
                            }
                            if (i12 > 1) {
                                z10 = true;
                                break;
                            }
                        }
                        if (z10 && (i11 = i11 + 1) < 0) {
                            kotlin.collections.v.t();
                        }
                    }
                    i10 = i11;
                }
                return new Solution(matches, iE, i10);
            }

            @NotNull
            public final Solution getNO_SOLUTION() {
                return Solution.NO_SOLUTION;
            }
        }

        public Solution(@NotNull List<Match> matches, int i10, int i11) {
            kotlin.jvm.internal.t.i(matches, "matches");
            this.matches = matches;
            this.coverageOffset = i10;
            this.overlaps = i11;
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        @NotNull
        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NotNull Solution other) {
            kotlin.jvm.internal.t.i(other, "other");
            int iK = kotlin.jvm.internal.t.k(this.overlaps, other.overlaps);
            return iK != 0 ? iK : kotlin.jvm.internal.t.k(this.coverageOffset, other.coverageOffset);
        }
    }

    /* JADX INFO: renamed from: androidx.room.AmbiguousColumnResolver$resolve$4, reason: invalid class name */
    /* JADX INFO: compiled from: AmbiguousColumnResolver.kt */
    static final class AnonymousClass4 extends kotlin.jvm.internal.v implements h9.l<List<? extends Match>, k0> {
        final /* synthetic */ n0<Solution> $bestSolution;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(n0<Solution> n0Var) {
            super(1);
            this.$bestSolution = n0Var;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(List<? extends Match> list) {
            invoke2((List<Match>) list);
            return k0.f35197a;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.room.AmbiguousColumnResolver$Solution] */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull List<Match> it) {
            kotlin.jvm.internal.t.i(it, "it");
            ?? Build = Solution.Companion.build(it);
            if (Build.compareTo(this.$bestSolution.f29834a) < 0) {
                this.$bestSolution.f29834a = Build;
            }
        }
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> list, List<T> list2, int i10, h9.l<? super List<? extends T>, k0> lVar) {
        if (i10 == list.size()) {
            lVar.invoke(d0.P0(list2));
            return;
        }
        Iterator<T> it = list.get(i10).iterator();
        while (it.hasNext()) {
            list2.add(it.next());
            INSTANCE.dfs(list, list2, i10 + 1, lVar);
            kotlin.collections.a0.O(list2);
        }
    }

    static /* synthetic */ void dfs$default(AmbiguousColumnResolver ambiguousColumnResolver, List list, List list2, int i10, h9.l lVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        ambiguousColumnResolver.dfs(list, list2, i10, lVar);
    }

    private final void rabinKarpSearch(List<ResultColumn> list, String[] strArr, h9.q<? super Integer, ? super Integer, ? super List<ResultColumn>, k0> qVar) {
        int i10 = 0;
        int iHashCode = 0;
        for (String str : strArr) {
            iHashCode += str.hashCode();
        }
        int length = strArr.length;
        Iterator<T> it = list.subList(0, length).iterator();
        int iHashCode2 = 0;
        while (it.hasNext()) {
            iHashCode2 += ((ResultColumn) it.next()).getName().hashCode();
        }
        while (true) {
            if (iHashCode == iHashCode2) {
                qVar.invoke(Integer.valueOf(i10), Integer.valueOf(length), list.subList(i10, length));
            }
            i10++;
            length++;
            if (length > list.size()) {
                return;
            } else {
                iHashCode2 = (iHashCode2 - list.get(i10 - 1).getName().hashCode()) + list.get(length - 1).getName().hashCode();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, androidx.room.AmbiguousColumnResolver$Solution] */
    @NotNull
    public static final int[][] resolve(@NotNull String[] resultColumns, @NotNull String[][] mappings) {
        boolean z10;
        kotlin.jvm.internal.t.i(resultColumns, "resultColumns");
        kotlin.jvm.internal.t.i(mappings, "mappings");
        int length = resultColumns.length;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            z10 = true;
            if (i11 >= length) {
                break;
            }
            String strSubstring = resultColumns[i11];
            if (strSubstring.charAt(0) == '`' && strSubstring.charAt(strSubstring.length() - 1) == '`') {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            Locale US = Locale.US;
            kotlin.jvm.internal.t.h(US, "US");
            String lowerCase = strSubstring.toLowerCase(US);
            kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            resultColumns[i11] = lowerCase;
            i11++;
        }
        int length2 = mappings.length;
        for (int i12 = 0; i12 < length2; i12++) {
            int length3 = mappings[i12].length;
            for (int i13 = 0; i13 < length3; i13++) {
                String[] strArr = mappings[i12];
                String str = strArr[i13];
                Locale US2 = Locale.US;
                kotlin.jvm.internal.t.h(US2, "US");
                String lowerCase2 = str.toLowerCase(US2);
                kotlin.jvm.internal.t.h(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                strArr[i13] = lowerCase2;
            }
        }
        Set setB = y0.b();
        for (String[] strArr2 : mappings) {
            kotlin.collections.a0.D(setB, strArr2);
        }
        Set setA = y0.a(setB);
        List listC = kotlin.collections.u.c();
        int length4 = resultColumns.length;
        int i14 = 0;
        int i15 = 0;
        while (i14 < length4) {
            String str2 = resultColumns[i14];
            int i16 = i15 + 1;
            if (setA.contains(str2)) {
                listC.add(new ResultColumn(str2, i15));
            }
            i14++;
            i15 = i16;
        }
        List<ResultColumn> listA = kotlin.collections.u.a(listC);
        int length5 = mappings.length;
        ArrayList arrayList = new ArrayList(length5);
        for (int i17 = 0; i17 < length5; i17++) {
            arrayList.add(new ArrayList());
        }
        int length6 = mappings.length;
        int i18 = 0;
        int i19 = 0;
        while (i18 < length6) {
            String[] strArr3 = mappings[i18];
            int i20 = i19 + 1;
            INSTANCE.rabinKarpSearch(listA, strArr3, new AmbiguousColumnResolver$resolve$1$1(strArr3, arrayList, i19));
            if (((List) arrayList.get(i19)).isEmpty()) {
                ArrayList arrayList2 = new ArrayList(strArr3.length);
                int length7 = strArr3.length;
                for (int i21 = i10; i21 < length7; i21++) {
                    String str3 = strArr3[i21];
                    List listC2 = kotlin.collections.u.c();
                    for (ResultColumn resultColumn : listA) {
                        if (kotlin.jvm.internal.t.d(str3, resultColumn.getName())) {
                            listC2.add(Integer.valueOf(resultColumn.getIndex()));
                        }
                    }
                    List listA2 = kotlin.collections.u.a(listC2);
                    if (!(!listA2.isEmpty())) {
                        throw new IllegalStateException(("Column " + str3 + " not found in result").toString());
                    }
                    arrayList2.add(listA2);
                }
                dfs$default(INSTANCE, arrayList2, null, 0, new AmbiguousColumnResolver$resolve$1$2(arrayList, i19), 6, null);
            }
            i18++;
            i19 = i20;
            i10 = 0;
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!(!((List) it.next()).isEmpty())) {
                    z10 = false;
                    break;
                }
            }
        }
        if (!z10) {
            throw new IllegalStateException("Failed to find matches for all mappings".toString());
        }
        n0 n0Var = new n0();
        n0Var.f29834a = Solution.Companion.getNO_SOLUTION();
        dfs$default(INSTANCE, arrayList, null, 0, new AnonymousClass4(n0Var), 6, null);
        List<Match> matches = ((Solution) n0Var.f29834a).getMatches();
        ArrayList arrayList3 = new ArrayList(kotlin.collections.w.v(matches, 10));
        Iterator<T> it2 = matches.iterator();
        while (it2.hasNext()) {
            arrayList3.add(d0.O0(((Match) it2.next()).getResultIndices()));
        }
        Object[] array = arrayList3.toArray(new int[0][]);
        kotlin.jvm.internal.t.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (int[][]) array;
    }
}

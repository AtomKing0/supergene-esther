package androidx.room;

import androidx.room.AmbiguousColumnResolver;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AmbiguousColumnResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AmbiguousColumnResolver$resolve$1$2 extends kotlin.jvm.internal.v implements h9.l<List<? extends Integer>, k0> {
    final /* synthetic */ int $mappingIndex;
    final /* synthetic */ List<List<AmbiguousColumnResolver.Match>> $mappingMatches;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AmbiguousColumnResolver$resolve$1$2(List<? extends List<AmbiguousColumnResolver.Match>> list, int i10) {
        super(1);
        this.$mappingMatches = list;
        this.$mappingIndex = i10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(List<? extends Integer> list) {
        invoke2((List<Integer>) list);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull List<Integer> indices) {
        kotlin.jvm.internal.t.i(indices, "indices");
        List<Integer> list = indices;
        Iterator<T> it = list.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        int iIntValue = ((Number) it.next()).intValue();
        while (it.hasNext()) {
            int iIntValue2 = ((Number) it.next()).intValue();
            if (iIntValue > iIntValue2) {
                iIntValue = iIntValue2;
            }
        }
        Iterator<T> it2 = list.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        int iIntValue3 = ((Number) it2.next()).intValue();
        while (it2.hasNext()) {
            int iIntValue4 = ((Number) it2.next()).intValue();
            if (iIntValue3 < iIntValue4) {
                iIntValue3 = iIntValue4;
            }
        }
        this.$mappingMatches.get(this.$mappingIndex).add(new AmbiguousColumnResolver.Match(new n9.i(iIntValue, iIntValue3), indices));
    }
}

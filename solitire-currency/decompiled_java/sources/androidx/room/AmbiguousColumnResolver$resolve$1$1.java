package androidx.room;

import androidx.room.AmbiguousColumnResolver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AmbiguousColumnResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AmbiguousColumnResolver$resolve$1$1 extends kotlin.jvm.internal.v implements h9.q<Integer, Integer, List<? extends AmbiguousColumnResolver.ResultColumn>, k0> {
    final /* synthetic */ String[] $mapping;
    final /* synthetic */ int $mappingIndex;
    final /* synthetic */ List<List<AmbiguousColumnResolver.Match>> $mappingMatches;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AmbiguousColumnResolver$resolve$1$1(String[] strArr, List<? extends List<AmbiguousColumnResolver.Match>> list, int i10) {
        super(3);
        this.$mapping = strArr;
        this.$mappingMatches = list;
        this.$mappingIndex = i10;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(Integer num, Integer num2, List<? extends AmbiguousColumnResolver.ResultColumn> list) {
        invoke(num.intValue(), num2.intValue(), (List<AmbiguousColumnResolver.ResultColumn>) list);
        return k0.f35197a;
    }

    public final void invoke(int i10, int i11, @NotNull List<AmbiguousColumnResolver.ResultColumn> resultColumnsSublist) {
        Object next;
        kotlin.jvm.internal.t.i(resultColumnsSublist, "resultColumnsSublist");
        String[] strArr = this.$mapping;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            Iterator<T> it = resultColumnsSublist.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (kotlin.jvm.internal.t.d(str, ((AmbiguousColumnResolver.ResultColumn) next).component1())) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            AmbiguousColumnResolver.ResultColumn resultColumn = (AmbiguousColumnResolver.ResultColumn) next;
            if (resultColumn == null) {
                return;
            }
            arrayList.add(Integer.valueOf(resultColumn.getIndex()));
        }
        this.$mappingMatches.get(this.$mappingIndex).add(new AmbiguousColumnResolver.Match(new n9.i(i10, i11 - 1), arrayList));
    }
}

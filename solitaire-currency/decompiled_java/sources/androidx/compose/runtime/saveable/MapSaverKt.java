package androidx.compose.runtime.saveable;

import h9.l;
import h9.p;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MapSaver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MapSaverKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.runtime.saveable.MapSaverKt$mapSaver$1, reason: invalid class name */
    /* JADX INFO: compiled from: MapSaver.kt */
    static final class AnonymousClass1<T> extends v implements p<SaverScope, T, List<? extends Object>> {
        final /* synthetic */ p<SaverScope, T, Map<String, Object>> $save;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(p<? super SaverScope, ? super T, ? extends Map<String, ? extends Object>> pVar) {
            super(2);
            this.$save = pVar;
        }

        @Override // h9.p
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final List<Object> mo4invoke(@NotNull SaverScope listSaver, T t10) {
            t.i(listSaver, "$this$listSaver");
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Object> entry : this.$save.mo4invoke(listSaver, t10).entrySet()) {
                arrayList.add(entry.getKey());
                arrayList.add(entry.getValue());
            }
            return arrayList;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.runtime.saveable.MapSaverKt$mapSaver$2, reason: invalid class name */
    /* JADX INFO: compiled from: MapSaver.kt */
    static final class AnonymousClass2<T> extends v implements l<List<? extends Object>, T> {
        final /* synthetic */ l<Map<String, ? extends Object>, T> $restore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(l<? super Map<String, ? extends Object>, ? extends T> lVar) {
            super(1);
            this.$restore = lVar;
        }

        @Override // h9.l
        @Nullable
        public final T invoke(@NotNull List<? extends Object> list) {
            t.i(list, "list");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!(list.size() % 2 == 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            for (int i10 = 0; i10 < list.size(); i10 += 2) {
                Object obj = list.get(i10);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                linkedHashMap.put((String) obj, list.get(i10 + 1));
            }
            return this.$restore.invoke(linkedHashMap);
        }
    }

    @NotNull
    public static final <T> Saver<T, Object> mapSaver(@NotNull p<? super SaverScope, ? super T, ? extends Map<String, ? extends Object>> save, @NotNull l<? super Map<String, ? extends Object>, ? extends T> restore) {
        t.i(save, "save");
        t.i(restore, "restore");
        return ListSaverKt.listSaver(new AnonymousClass1(save), new AnonymousClass2(restore));
    }
}

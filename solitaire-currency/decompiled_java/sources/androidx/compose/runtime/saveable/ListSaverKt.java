package androidx.compose.runtime.saveable;

import h9.l;
import h9.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ListSaver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ListSaverKt {

    /* JADX INFO: Add missing generic type declarations: [Original] */
    /* JADX INFO: renamed from: androidx.compose.runtime.saveable.ListSaverKt$listSaver$1, reason: invalid class name */
    /* JADX INFO: compiled from: ListSaver.kt */
    static final class AnonymousClass1<Original> extends v implements p<SaverScope, Original, Object> {
        final /* synthetic */ p<SaverScope, Original, List<Saveable>> $save;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(p<? super SaverScope, ? super Original, ? extends List<? extends Saveable>> pVar) {
            super(2);
            this.$save = pVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull SaverScope Saver, Original original) {
            t.i(Saver, "$this$Saver");
            List list = (List) this.$save.mo4invoke(Saver, original);
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                Object obj = list.get(i10);
                if (obj != null && !Saver.canBeSaved(obj)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            List list2 = list;
            if (!list2.isEmpty()) {
                return new ArrayList(list2);
            }
            return null;
        }
    }

    @NotNull
    public static final <Original, Saveable> Saver<Original, Object> listSaver(@NotNull p<? super SaverScope, ? super Original, ? extends List<? extends Saveable>> save, @NotNull l<? super List<? extends Saveable>, ? extends Original> restore) {
        t.i(save, "save");
        t.i(restore, "restore");
        return SaverKt.Saver(new AnonymousClass1(save), (l) t0.f(restore, 1));
    }
}

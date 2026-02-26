package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import h9.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$LocaleListSaver$2 extends v implements l<Object, LocaleList> {
    public static final SaversKt$LocaleListSaver$2 INSTANCE = new SaversKt$LocaleListSaver$2();

    SaversKt$LocaleListSaver$2() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.l
    @Nullable
    public final LocaleList invoke(@NotNull Object it) {
        t.i(it, "it");
        List list = (List) it;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = list.get(i10);
            Saver<Locale, Object> saver = SaversKt.getSaver(Locale.Companion);
            Locale localeRestore = null;
            if (!t.d(obj, Boolean.FALSE) && obj != null) {
                localeRestore = saver.restore(obj);
            }
            t.f(localeRestore);
            arrayList.add(localeRestore);
        }
        return new LocaleList(arrayList);
    }
}

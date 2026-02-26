package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import h9.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$LocaleListSaver$1 extends v implements p<SaverScope, LocaleList, Object> {
    public static final SaversKt$LocaleListSaver$1 INSTANCE = new SaversKt$LocaleListSaver$1();

    SaversKt$LocaleListSaver$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull SaverScope Saver, @NotNull LocaleList it) {
        t.i(Saver, "$this$Saver");
        t.i(it, "it");
        List<Locale> localeList = it.getLocaleList();
        ArrayList arrayList = new ArrayList(localeList.size());
        int size = localeList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(SaversKt.save(localeList.get(i10), SaversKt.getSaver(Locale.Companion), Saver));
        }
        return arrayList;
    }
}

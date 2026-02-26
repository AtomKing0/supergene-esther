package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$OffsetSaver$2 extends v implements l<Object, Offset> {
    public static final SaversKt$OffsetSaver$2 INSTANCE = new SaversKt$OffsetSaver$2();

    SaversKt$OffsetSaver$2() {
        super(1);
    }

    @Override // h9.l
    @Nullable
    /* JADX INFO: renamed from: invoke-x-9fifI, reason: not valid java name and merged with bridge method [inline-methods] */
    public final Offset invoke(@NotNull Object it) {
        t.i(it, "it");
        if (t.d(it, Boolean.FALSE)) {
            return Offset.m1356boximpl(Offset.Companion.m1382getUnspecifiedF1C5BW0());
        }
        List list = (List) it;
        Object obj = list.get(0);
        Float f10 = obj != null ? (Float) obj : null;
        t.f(f10);
        float fFloatValue = f10.floatValue();
        Object obj2 = list.get(1);
        Float f11 = obj2 != null ? (Float) obj2 : null;
        t.f(f11);
        return Offset.m1356boximpl(OffsetKt.Offset(fFloatValue, f11.floatValue()));
    }
}

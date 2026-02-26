package androidx.compose.ui.text;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$TextUnitSaver$2 extends v implements l<Object, TextUnit> {
    public static final SaversKt$TextUnitSaver$2 INSTANCE = new SaversKt$TextUnitSaver$2();

    SaversKt$TextUnitSaver$2() {
        super(1);
    }

    @Override // h9.l
    @Nullable
    /* JADX INFO: renamed from: invoke-XNhUCwk, reason: not valid java name and merged with bridge method [inline-methods] */
    public final TextUnit invoke(@NotNull Object it) {
        t.i(it, "it");
        List list = (List) it;
        Object obj = list.get(0);
        Float f10 = obj != null ? (Float) obj : null;
        t.f(f10);
        float fFloatValue = f10.floatValue();
        Object obj2 = list.get(1);
        TextUnitType textUnitType = obj2 != null ? (TextUnitType) obj2 : null;
        t.f(textUnitType);
        return TextUnit.m3844boximpl(TextUnitKt.m3866TextUnitanM5pPY(fFloatValue, textUnitType.m3885unboximpl()));
    }
}

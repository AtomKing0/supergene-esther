package androidx.compose.foundation;

import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Scroll.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScrollState$Companion$Saver$2 extends v implements h9.l<Integer, ScrollState> {
    public static final ScrollState$Companion$Saver$2 INSTANCE = new ScrollState$Companion$Saver$2();

    ScrollState$Companion$Saver$2() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ ScrollState invoke(Integer num) {
        return invoke(num.intValue());
    }

    @Nullable
    public final ScrollState invoke(int i10) {
        return new ScrollState(i10);
    }
}

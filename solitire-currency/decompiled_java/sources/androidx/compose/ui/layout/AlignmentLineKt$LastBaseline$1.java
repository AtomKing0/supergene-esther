package androidx.compose.ui.layout;

import com.applovin.sdk.AppLovinMediationProvider;
import h9.p;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AlignmentLine.kt */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class AlignmentLineKt$LastBaseline$1 extends q implements p<Integer, Integer, Integer> {
    public static final AlignmentLineKt$LastBaseline$1 INSTANCE = new AlignmentLineKt$LastBaseline$1();

    AlignmentLineKt$LastBaseline$1() {
        super(2, j9.a.class, AppLovinMediationProvider.MAX, "max(II)I", 1);
    }

    @NotNull
    public final Integer invoke(int i10, int i11) {
        return Integer.valueOf(Math.max(i10, i11));
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Integer mo4invoke(Integer num, Integer num2) {
        return invoke(num.intValue(), num2.intValue());
    }
}

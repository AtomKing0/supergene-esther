package androidx.compose.foundation;

import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Indication.kt */
/* JADX INFO: loaded from: classes.dex */
final class IndicationKt$LocalIndication$1 extends v implements h9.a<Indication> {
    public static final IndicationKt$LocalIndication$1 INSTANCE = new IndicationKt$LocalIndication$1();

    IndicationKt$LocalIndication$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final Indication invoke() {
        return DefaultDebugIndication.INSTANCE;
    }
}

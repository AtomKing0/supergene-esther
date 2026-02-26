package androidx.compose.foundation;

import androidx.compose.foundation.MagnifierKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Magnifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class MagnifierKt$magnifier$4$isMagnifierShown$2$1 extends v implements h9.a<Boolean> {
    final /* synthetic */ State<Offset> $sourceCenterInRoot$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MagnifierKt$magnifier$4$isMagnifierShown$2$1(State<Offset> state) {
        super(0);
        this.$sourceCenterInRoot$delegate = state;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(OffsetKt.m1386isSpecifiedk4lQ0M(MagnifierKt.AnonymousClass4.m229invoke$lambda8(this.$sourceCenterInRoot$delegate)));
    }
}

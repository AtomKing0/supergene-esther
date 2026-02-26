package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BoxWithConstraints.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BoxWithConstraintsKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.BoxWithConstraintsKt$BoxWithConstraints$2, reason: invalid class name */
    /* JADX INFO: compiled from: BoxWithConstraints.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ q<BoxWithConstraintsScope, Composer, Integer, k0> $content;
        final /* synthetic */ Alignment $contentAlignment;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $propagateMinConstraints;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Modifier modifier, Alignment alignment, boolean z10, q<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, k0> qVar, int i10, int i11) {
            super(2);
            this.$modifier = modifier;
            this.$contentAlignment = alignment;
            this.$propagateMinConstraints = z10;
            this.$content = qVar;
            this.$$changed = i10;
            this.$$default = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            BoxWithConstraintsKt.BoxWithConstraints(this.$modifier, this.$contentAlignment, this.$propagateMinConstraints, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.UiComposable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BoxWithConstraints(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r12, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment r13, boolean r14, @org.jetbrains.annotations.NotNull h9.q<? super androidx.compose.foundation.layout.BoxWithConstraintsScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r15, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r16, int r17, int r18) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, boolean, h9.q, androidx.compose.runtime.Composer, int, int):void");
    }
}

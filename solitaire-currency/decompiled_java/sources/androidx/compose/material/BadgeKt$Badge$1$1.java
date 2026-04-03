package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Badge.kt */
/* JADX INFO: loaded from: classes.dex */
final class BadgeKt$Badge$1$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty$1;
    final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
    final /* synthetic */ RowScope $this_Row;

    /* JADX INFO: renamed from: androidx.compose.material.BadgeKt$Badge$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Badge.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty$1;
        final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
        final /* synthetic */ RowScope $this_Row;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, RowScope rowScope, int i10, int i11) {
            super(2);
            this.$content = qVar;
            this.$this_Row = rowScope;
            this.$$dirty = i10;
            this.$$dirty$1 = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                this.$content.invoke(this.$this_Row, composer, Integer.valueOf((this.$$dirty & 14) | ((this.$$dirty$1 >> 6) & 112)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BadgeKt$Badge$1$1(q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, RowScope rowScope, int i10, int i11) {
        super(2);
        this.$content = qVar;
        this.$this_Row = rowScope;
        this.$$dirty = i10;
        this.$$dirty$1 = i11;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i10) {
        if ((i10 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer, 6).getButton();
            TextKt.ProvideTextStyle(button.m3346copyHL5avdY((262111 & 1) != 0 ? button.spanStyle.m3308getColor0d7_KjU() : 0L, (262111 & 2) != 0 ? button.spanStyle.m3309getFontSizeXSAIIZE() : BadgeKt.BadgeContentFontSize, (262111 & 4) != 0 ? button.spanStyle.getFontWeight() : null, (262111 & 8) != 0 ? button.spanStyle.m3310getFontStyle4Lr2A7w() : null, (262111 & 16) != 0 ? button.spanStyle.m3311getFontSynthesisZQGJjVo() : null, (262111 & 32) != 0 ? button.spanStyle.getFontFamily() : null, (262111 & 64) != 0 ? button.spanStyle.getFontFeatureSettings() : null, (262111 & 128) != 0 ? button.spanStyle.m3312getLetterSpacingXSAIIZE() : 0L, (262111 & 256) != 0 ? button.spanStyle.m3307getBaselineShift5SSeXJ0() : null, (262111 & 512) != 0 ? button.spanStyle.getTextGeometricTransform() : null, (262111 & 1024) != 0 ? button.spanStyle.getLocaleList() : null, (262111 & 2048) != 0 ? button.spanStyle.m3306getBackground0d7_KjU() : 0L, (262111 & 4096) != 0 ? button.spanStyle.getTextDecoration() : null, (262111 & 8192) != 0 ? button.spanStyle.getShadow() : null, (262111 & 16384) != 0 ? button.paragraphStyle.m3269getTextAlignbuA522U() : null, (262111 & 32768) != 0 ? button.paragraphStyle.m3270getTextDirectionmmuk1to() : null, (262111 & 65536) != 0 ? button.paragraphStyle.m3268getLineHeightXSAIIZE() : 0L, (262111 & 131072) != 0 ? button.paragraphStyle.getTextIndent() : null), ComposableLambdaKt.composableLambda(composer, 915155142, true, new AnonymousClass1(this.$content, this.$this_Row, this.$$dirty, this.$$dirty$1)), composer, 48);
        }
    }
}

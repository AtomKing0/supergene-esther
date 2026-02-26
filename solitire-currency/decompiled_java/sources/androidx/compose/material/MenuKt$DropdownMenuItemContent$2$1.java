package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Menu.kt */
/* JADX INFO: loaded from: classes.dex */
final class MenuKt$DropdownMenuItemContent$2$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty$1;
    final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ RowScope $this_Row;

    /* JADX INFO: renamed from: androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Menu.kt */
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
                this.$content.invoke(this.$this_Row, composer, Integer.valueOf((this.$$dirty & 14) | ((this.$$dirty$1 >> 12) & 112)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MenuKt$DropdownMenuItemContent$2$1(boolean z10, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, RowScope rowScope, int i10, int i11) {
        super(2);
        this.$enabled = z10;
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
        float disabled;
        if ((i10 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (this.$enabled) {
            composer.startReplaceableGroup(-1945695285);
            disabled = ContentAlpha.INSTANCE.getHigh(composer, 6);
        } else {
            composer.startReplaceableGroup(-1945695262);
            disabled = ContentAlpha.INSTANCE.getDisabled(composer, 6);
        }
        composer.endReplaceableGroup();
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, ComposableLambdaKt.composableLambda(composer, -1705995688, true, new AnonymousClass1(this.$content, this.$this_Row, this.$$dirty, this.$$dirty$1)), composer, 56);
    }
}

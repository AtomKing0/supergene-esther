package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldImplKt$Decoration$colorAndEmphasis$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ Float $contentAlpha;
    final /* synthetic */ long $contentColor;

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldImpl.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ Float $contentAlpha;
        final /* synthetic */ long $contentColor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Float f10, p<? super Composer, ? super Integer, k0> pVar, int i10, long j10) {
            super(2);
            this.$contentAlpha = f10;
            this.$content = pVar;
            this.$$dirty = i10;
            this.$contentColor = j10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (this.$contentAlpha != null) {
                composer.startReplaceableGroup(-452622131);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(this.$contentAlpha)}, this.$content, composer, ((this.$$dirty >> 6) & 112) | 8);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-452621951);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1600getAlphaimpl(this.$contentColor)))}, this.$content, composer, ((this.$$dirty >> 6) & 112) | 8);
                composer.endReplaceableGroup();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TextFieldImplKt$Decoration$colorAndEmphasis$1(long j10, Float f10, p<? super Composer, ? super Integer, k0> pVar, int i10) {
        super(2);
        this.$contentColor = j10;
        this.$contentAlpha = f10;
        this.$content = pVar;
        this.$$dirty = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i10) {
        if ((i10 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1588boximpl(this.$contentColor))}, ComposableLambdaKt.composableLambda(composer, -1132188434, true, new AnonymousClass1(this.$contentAlpha, this.$content, this.$$dirty, this.$contentColor)), composer, 56);
        }
    }
}

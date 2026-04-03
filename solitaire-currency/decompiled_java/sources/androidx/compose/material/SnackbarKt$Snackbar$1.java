package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes.dex */
final class SnackbarKt$Snackbar$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $action;
    final /* synthetic */ boolean $actionOnNewLine;
    final /* synthetic */ p<Composer, Integer, k0> $content;

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarKt$Snackbar$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Snackbar.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ p<Composer, Integer, k0> $action;
        final /* synthetic */ boolean $actionOnNewLine;
        final /* synthetic */ p<Composer, Integer, k0> $content;

        /* JADX INFO: renamed from: androidx.compose.material.SnackbarKt$Snackbar$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Snackbar.kt */
        static final class C01141 extends v implements p<Composer, Integer, k0> {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ p<Composer, Integer, k0> $action;
            final /* synthetic */ boolean $actionOnNewLine;
            final /* synthetic */ p<Composer, Integer, k0> $content;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01141(p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, int i10, boolean z10) {
                super(2);
                this.$action = pVar;
                this.$content = pVar2;
                this.$$dirty = i10;
                this.$actionOnNewLine = z10;
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
                    return;
                }
                if (this.$action == null) {
                    composer.startReplaceableGroup(59708346);
                    SnackbarKt.TextOnlySnackbar(this.$content, composer, (this.$$dirty >> 21) & 14);
                    composer.endReplaceableGroup();
                    return;
                }
                if (this.$actionOnNewLine) {
                    composer.startReplaceableGroup(59708411);
                    p<Composer, Integer, k0> pVar = this.$content;
                    p<Composer, Integer, k0> pVar2 = this.$action;
                    int i11 = this.$$dirty;
                    SnackbarKt.NewLineButtonSnackbar(pVar, pVar2, composer, (i11 & 112) | ((i11 >> 21) & 14));
                    composer.endReplaceableGroup();
                    return;
                }
                composer.startReplaceableGroup(59708478);
                p<Composer, Integer, k0> pVar3 = this.$content;
                p<Composer, Integer, k0> pVar4 = this.$action;
                int i12 = this.$$dirty;
                SnackbarKt.OneRowSnackbar(pVar3, pVar4, composer, (i12 & 112) | ((i12 >> 21) & 14));
                composer.endReplaceableGroup();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, int i10, boolean z10) {
            super(2);
            this.$action = pVar;
            this.$content = pVar2;
            this.$$dirty = i10;
            this.$actionOnNewLine = z10;
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
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2(), ComposableLambdaKt.composableLambda(composer, 225114541, true, new C01141(this.$action, this.$content, this.$$dirty, this.$actionOnNewLine)), composer, 48);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SnackbarKt$Snackbar$1(p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, int i10, boolean z10) {
        super(2);
        this.$action = pVar;
        this.$content = pVar2;
        this.$$dirty = i10;
        this.$actionOnNewLine = z10;
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
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer, 6)))}, ComposableLambdaKt.composableLambda(composer, 1939362236, true, new AnonymousClass1(this.$action, this.$content, this.$$dirty, this.$actionOnNewLine)), composer, 56);
        }
    }
}

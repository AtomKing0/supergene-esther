package androidx.compose.ui.window;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidDialog.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidDialog_androidKt$Dialog$dialog$1$1$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ State<p<Composer, Integer, k0>> $currentContent$delegate;

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidDialog.android.kt */
    static final class AnonymousClass1 extends v implements l<SemanticsPropertyReceiver, k0> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            invoke2(semanticsPropertyReceiver);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
            t.i(semantics, "$this$semantics");
            SemanticsPropertiesKt.dialog(semantics);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidDialog.android.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ State<p<Composer, Integer, k0>> $currentContent$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(State<? extends p<? super Composer, ? super Integer, k0>> state) {
            super(2);
            this.$currentContent$delegate = state;
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
                AndroidDialog_androidKt.m3913Dialog$lambda0(this.$currentContent$delegate).mo4invoke(composer, 0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AndroidDialog_androidKt$Dialog$dialog$1$1$1(State<? extends p<? super Composer, ? super Integer, k0>> state) {
        super(2);
        this.$currentContent$delegate = state;
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
            AndroidDialog_androidKt.DialogLayout(SemanticsModifierKt.semantics$default(Modifier.Companion, false, AnonymousClass1.INSTANCE, 1, null), ComposableLambdaKt.composableLambda(composer, -533674951, true, new AnonymousClass2(this.$currentContent$delegate)), composer, 48, 0);
        }
    }
}

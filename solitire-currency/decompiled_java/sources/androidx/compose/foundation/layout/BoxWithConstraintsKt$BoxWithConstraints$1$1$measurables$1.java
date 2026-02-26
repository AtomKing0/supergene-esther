package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BoxWithConstraints.kt */
/* JADX INFO: loaded from: classes.dex */
final class BoxWithConstraintsKt$BoxWithConstraints$1$1$measurables$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ q<BoxWithConstraintsScope, Composer, Integer, k0> $content;
    final /* synthetic */ BoxWithConstraintsScopeImpl $scope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BoxWithConstraintsKt$BoxWithConstraints$1$1$measurables$1(q<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, k0> qVar, BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl, int i10) {
        super(2);
        this.$content = qVar;
        this.$scope = boxWithConstraintsScopeImpl;
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
            this.$content.invoke(this.$scope, composer, Integer.valueOf((this.$$dirty >> 6) & 112));
        }
    }
}

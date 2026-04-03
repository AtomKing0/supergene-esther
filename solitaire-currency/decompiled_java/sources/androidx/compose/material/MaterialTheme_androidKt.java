package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: MaterialTheme.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialTheme_androidKt {

    /* JADX INFO: renamed from: androidx.compose.material.MaterialTheme_androidKt$PlatformMaterialTheme$1, reason: invalid class name */
    /* JADX INFO: compiled from: MaterialTheme.android.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ p<Composer, Integer, k0> $content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(p<? super Composer, ? super Integer, k0> pVar, int i10) {
            super(2);
            this.$content = pVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            MaterialTheme_androidKt.PlatformMaterialTheme(this.$content, composer, this.$$changed | 1);
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void PlatformMaterialTheme(@NotNull p<? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10) {
        int i11;
        t.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1322912246);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(content) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i11 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            content.mo4invoke(composerStartRestartGroup, Integer.valueOf(i11 & 14));
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(content, i10));
    }
}

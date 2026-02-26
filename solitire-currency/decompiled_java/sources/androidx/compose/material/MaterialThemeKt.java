package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: MaterialTheme.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialThemeKt {

    /* JADX INFO: renamed from: androidx.compose.material.MaterialThemeKt$MaterialTheme$1, reason: invalid class name */
    /* JADX INFO: compiled from: MaterialTheme.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ Typography $typography;

        /* JADX INFO: renamed from: androidx.compose.material.MaterialThemeKt$MaterialTheme$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: MaterialTheme.kt */
        static final class C01001 extends v implements p<Composer, Integer, k0> {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ p<Composer, Integer, k0> $content;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01001(p<? super Composer, ? super Integer, k0> pVar, int i10) {
                super(2);
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
                    MaterialTheme_androidKt.PlatformMaterialTheme(this.$content, composer, (this.$$dirty >> 9) & 14);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Typography typography, p<? super Composer, ? super Integer, k0> pVar, int i10) {
            super(2);
            this.$typography = typography;
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
                TextKt.ProvideTextStyle(this.$typography.getBody1(), ComposableLambdaKt.composableLambda(composer, 181426554, true, new C01001(this.$content, this.$$dirty)), composer, 48);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.MaterialThemeKt$MaterialTheme$2, reason: invalid class name */
    /* JADX INFO: compiled from: MaterialTheme.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ Colors $colors;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ Shapes $shapes;
        final /* synthetic */ Typography $typography;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Colors colors, Typography typography, Shapes shapes, p<? super Composer, ? super Integer, k0> pVar, int i10, int i11) {
            super(2);
            this.$colors = colors;
            this.$typography = typography;
            this.$shapes = shapes;
            this.$content = pVar;
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
            MaterialThemeKt.MaterialTheme(this.$colors, this.$typography, this.$shapes, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x00ed  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[0[0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void MaterialTheme(@org.jetbrains.annotations.Nullable androidx.compose.material.Colors r43, @org.jetbrains.annotations.Nullable androidx.compose.material.Typography r44, @org.jetbrains.annotations.Nullable androidx.compose.material.Shapes r45, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r46, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r47, int r48, int r49) {
        /*
            Method dump skipped, instruction units count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.MaterialThemeKt.MaterialTheme(androidx.compose.material.Colors, androidx.compose.material.Typography, androidx.compose.material.Shapes, h9.p, androidx.compose.runtime.Composer, int, int):void");
    }
}

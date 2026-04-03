package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import h9.l;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Crossfade.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CrossfadeKt {

    /* JADX INFO: renamed from: androidx.compose.animation.CrossfadeKt$Crossfade$1, reason: invalid class name */
    /* JADX INFO: compiled from: Crossfade.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
        final /* synthetic */ q<T, Composer, Integer, k0> $content;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ T $targetState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(T t10, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, q<? super T, ? super Composer, ? super Integer, k0> qVar, int i10, int i11) {
            super(2);
            this.$targetState = t10;
            this.$modifier = modifier;
            this.$animationSpec = finiteAnimationSpec;
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
            CrossfadeKt.Crossfade(this.$targetState, this.$modifier, this.$animationSpec, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.CrossfadeKt$Crossfade$6, reason: invalid class name */
    /* JADX INFO: compiled from: Crossfade.kt */
    static final class AnonymousClass6 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
        final /* synthetic */ q<T, Composer, Integer, k0> $content;
        final /* synthetic */ l<T, Object> $contentKey;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Transition<T> $this_Crossfade;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass6(Transition<T> transition, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, l<? super T, ? extends Object> lVar, q<? super T, ? super Composer, ? super Integer, k0> qVar, int i10, int i11) {
            super(2);
            this.$this_Crossfade = transition;
            this.$modifier = modifier;
            this.$animationSpec = finiteAnimationSpec;
            this.$contentKey = lVar;
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
            CrossfadeKt.Crossfade(this.$this_Crossfade, this.$modifier, this.$animationSpec, this.$contentKey, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> void Crossfade(T r14, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r15, @org.jetbrains.annotations.Nullable androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r16, @org.jetbrains.annotations.NotNull h9.q<? super T, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r17, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r18, int r19, int r20) {
        /*
            r1 = r14
            r10 = r17
            r11 = r19
            java.lang.String r0 = "content"
            kotlin.jvm.internal.t.i(r10, r0)
            r0 = 523603005(0x1f358c3d, float:3.8444243E-20)
            r2 = r18
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r20 & 1
            r3 = 4
            r4 = 2
            if (r2 == 0) goto L1c
            r2 = r11 | 6
            goto L2c
        L1c:
            r2 = r11 & 14
            if (r2 != 0) goto L2b
            boolean r2 = r0.changed(r14)
            if (r2 == 0) goto L28
            r2 = r3
            goto L29
        L28:
            r2 = r4
        L29:
            r2 = r2 | r11
            goto L2c
        L2b:
            r2 = r11
        L2c:
            r5 = r20 & 2
            if (r5 == 0) goto L33
            r2 = r2 | 48
            goto L45
        L33:
            r6 = r11 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L45
            r6 = r15
            boolean r7 = r0.changed(r15)
            if (r7 == 0) goto L41
            r7 = 32
            goto L43
        L41:
            r7 = 16
        L43:
            r2 = r2 | r7
            goto L46
        L45:
            r6 = r15
        L46:
            r7 = r20 & 4
            if (r7 == 0) goto L4c
            r2 = r2 | 128(0x80, float:1.8E-43)
        L4c:
            r8 = r20 & 8
            if (r8 == 0) goto L53
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L63
        L53:
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L63
            boolean r8 = r0.changed(r10)
            if (r8 == 0) goto L60
            r8 = 2048(0x800, float:2.87E-42)
            goto L62
        L60:
            r8 = 1024(0x400, float:1.435E-42)
        L62:
            r2 = r2 | r8
        L63:
            if (r7 != r3) goto L79
            r3 = r2 & 5851(0x16db, float:8.199E-42)
            r8 = 1170(0x492, float:1.64E-42)
            if (r3 != r8) goto L79
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L72
            goto L79
        L72:
            r0.skipToGroupEnd()
            r3 = r16
            r2 = r6
            goto Laf
        L79:
            if (r5 == 0) goto L7f
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r12 = r3
            goto L80
        L7f:
            r12 = r6
        L80:
            r3 = 0
            if (r7 == 0) goto L8b
            r5 = 7
            r6 = 0
            androidx.compose.animation.core.TweenSpec r5 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r6, r6, r3, r5, r3)
            r13 = r5
            goto L8d
        L8b:
            r13 = r16
        L8d:
            r5 = r2 & 8
            r6 = r2 & 14
            r5 = r5 | r6
            androidx.compose.animation.core.Transition r3 = androidx.compose.animation.core.TransitionKt.updateTransition(r14, r3, r0, r5, r4)
            r5 = 0
            r4 = r2 & 112(0x70, float:1.57E-43)
            r4 = r4 | 512(0x200, float:7.17E-43)
            int r2 = r2 << 3
            r6 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r6
            r8 = r4 | r2
            r9 = 4
            r2 = r3
            r3 = r12
            r4 = r13
            r6 = r17
            r7 = r0
            Crossfade(r2, r3, r4, r5, r6, r7, r8, r9)
            r2 = r12
            r3 = r13
        Laf:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto Lb6
            goto Lc6
        Lb6:
            androidx.compose.animation.CrossfadeKt$Crossfade$1 r8 = new androidx.compose.animation.CrossfadeKt$Crossfade$1
            r0 = r8
            r1 = r14
            r4 = r17
            r5 = r19
            r6 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.updateScope(r8)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.CrossfadeKt.Crossfade(java.lang.Object, androidx.compose.ui.Modifier, androidx.compose.animation.core.FiniteAnimationSpec, h9.q, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x015f  */
    @androidx.compose.runtime.Composable
    @androidx.compose.animation.ExperimentalAnimationApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[0[0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> void Crossfade(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.Transition<T> r18, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r19, @org.jetbrains.annotations.Nullable androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r20, @org.jetbrains.annotations.Nullable h9.l<? super T, ? extends java.lang.Object> r21, @org.jetbrains.annotations.NotNull h9.q<? super T, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r22, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 793
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.CrossfadeKt.Crossfade(androidx.compose.animation.core.Transition, androidx.compose.ui.Modifier, androidx.compose.animation.core.FiniteAnimationSpec, h9.l, h9.q, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.animation.CrossfadeKt$Crossfade$2, reason: invalid class name */
    /* JADX INFO: compiled from: Crossfade.kt */
    static final class AnonymousClass2<T> extends v implements l<T, T> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        @Override // h9.l
        public final T invoke(T t10) {
            return t10;
        }
    }
}

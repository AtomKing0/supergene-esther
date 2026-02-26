package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import h9.p;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: VectorCompose.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VectorComposeKt {

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1, reason: invalid class name */
    /* JADX INFO: compiled from: VectorCompose.kt */
    static final class AnonymousClass1 extends v implements h9.a<GroupComponent> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final GroupComponent invoke() {
            return new GroupComponent();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$4, reason: invalid class name */
    /* JADX INFO: compiled from: VectorCompose.kt */
    static final class AnonymousClass4 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ List<PathNode> $clipPathData;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ String $name;
        final /* synthetic */ float $pivotX;
        final /* synthetic */ float $pivotY;
        final /* synthetic */ float $rotation;
        final /* synthetic */ float $scaleX;
        final /* synthetic */ float $scaleY;
        final /* synthetic */ float $translationX;
        final /* synthetic */ float $translationY;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(String str, float f10, float f11, float f12, float f13, float f14, float f15, float f16, List<? extends PathNode> list, p<? super Composer, ? super Integer, k0> pVar, int i10, int i11) {
            super(2);
            this.$name = str;
            this.$rotation = f10;
            this.$pivotX = f11;
            this.$pivotY = f12;
            this.$scaleX = f13;
            this.$scaleY = f14;
            this.$translationX = f15;
            this.$translationY = f16;
            this.$clipPathData = list;
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
            VectorComposeKt.Group(this.$name, this.$rotation, this.$pivotX, this.$pivotY, this.$scaleX, this.$scaleY, this.$translationX, this.$translationY, this.$clipPathData, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0115  */
    @androidx.compose.ui.graphics.vector.VectorComposable
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Group(@org.jetbrains.annotations.Nullable java.lang.String r19, float r20, float r21, float r22, float r23, float r24, float r25, float r26, @org.jetbrains.annotations.Nullable java.util.List<? extends androidx.compose.ui.graphics.vector.PathNode> r27, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r28, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 600
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorComposeKt.Group(java.lang.String, float, float, float, float, float, float, float, java.util.List, h9.p, androidx.compose.runtime.Composer, int, int):void");
    }

    @VectorComposable
    @Composable
    /* JADX INFO: renamed from: Path-9cdaXJ4, reason: not valid java name */
    public static final void m2123Path9cdaXJ4(@NotNull List<? extends PathNode> pathData, int i10, @Nullable String str, @Nullable Brush brush, float f10, @Nullable Brush brush2, float f11, float f12, int i11, int i12, float f13, float f14, float f15, float f16, @Nullable Composer composer, int i13, int i14, int i15) {
        t.i(pathData, "pathData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1478270750);
        int defaultFillType = (i15 & 2) != 0 ? VectorKt.getDefaultFillType() : i10;
        String str2 = (i15 & 4) != 0 ? "" : str;
        Brush brush3 = (i15 & 8) != 0 ? null : brush;
        float f17 = (i15 & 16) != 0 ? 1.0f : f10;
        Brush brush4 = (i15 & 32) != 0 ? null : brush2;
        float f18 = (i15 & 64) != 0 ? 1.0f : f11;
        float f19 = (i15 & 128) != 0 ? 0.0f : f12;
        int defaultStrokeLineCap = (i15 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : i11;
        int defaultStrokeLineJoin = (i15 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i12;
        float f20 = (i15 & 1024) != 0 ? 4.0f : f13;
        float f21 = (i15 & 2048) != 0 ? 0.0f : f14;
        float f22 = (i15 & 4096) != 0 ? 1.0f : f15;
        float f23 = (i15 & 8192) != 0 ? 0.0f : f16;
        VectorComposeKt$Path$1 vectorComposeKt$Path$1 = VectorComposeKt$Path$1.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(1886828752);
        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(new VectorComposeKt$Path9cdaXJ4$$inlined$ComposeNode$1(vectorComposeKt$Path$1));
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composerStartRestartGroup);
        Updater.m1265setimpl(composerM1258constructorimpl, str2, VectorComposeKt$Path$2$1.INSTANCE);
        Updater.m1265setimpl(composerM1258constructorimpl, pathData, VectorComposeKt$Path$2$2.INSTANCE);
        Updater.m1265setimpl(composerM1258constructorimpl, PathFillType.m1817boximpl(defaultFillType), VectorComposeKt$Path$2$3.INSTANCE);
        Updater.m1265setimpl(composerM1258constructorimpl, brush3, VectorComposeKt$Path$2$4.INSTANCE);
        Updater.m1265setimpl(composerM1258constructorimpl, Float.valueOf(f17), VectorComposeKt$Path$2$5.INSTANCE);
        Updater.m1265setimpl(composerM1258constructorimpl, brush4, VectorComposeKt$Path$2$6.INSTANCE);
        Updater.m1265setimpl(composerM1258constructorimpl, Float.valueOf(f18), VectorComposeKt$Path$2$7.INSTANCE);
        Updater.m1265setimpl(composerM1258constructorimpl, Float.valueOf(f19), VectorComposeKt$Path$2$8.INSTANCE);
        Updater.m1265setimpl(composerM1258constructorimpl, StrokeJoin.m1888boximpl(defaultStrokeLineJoin), VectorComposeKt$Path$2$9.INSTANCE);
        Updater.m1265setimpl(composerM1258constructorimpl, StrokeCap.m1878boximpl(defaultStrokeLineCap), VectorComposeKt$Path$2$10.INSTANCE);
        Updater.m1265setimpl(composerM1258constructorimpl, Float.valueOf(f20), VectorComposeKt$Path$2$11.INSTANCE);
        Updater.m1265setimpl(composerM1258constructorimpl, Float.valueOf(f21), VectorComposeKt$Path$2$12.INSTANCE);
        Updater.m1265setimpl(composerM1258constructorimpl, Float.valueOf(f22), VectorComposeKt$Path$2$13.INSTANCE);
        Updater.m1265setimpl(composerM1258constructorimpl, Float.valueOf(f23), VectorComposeKt$Path$2$14.INSTANCE);
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new VectorComposeKt$Path$3(pathData, defaultFillType, str2, brush3, f17, brush4, f18, f19, defaultStrokeLineCap, defaultStrokeLineJoin, f20, f21, f22, f23, i13, i14, i15));
    }
}

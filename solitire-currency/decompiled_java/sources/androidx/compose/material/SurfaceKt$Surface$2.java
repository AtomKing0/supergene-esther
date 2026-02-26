package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Surface.kt */
/* JADX INFO: loaded from: classes.dex */
final class SurfaceKt$Surface$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ BorderStroke $border;
    final /* synthetic */ long $color;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ float $elevation;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SurfaceKt$Surface$2(Modifier modifier, Shape shape, long j10, long j11, BorderStroke borderStroke, float f10, p<? super Composer, ? super Integer, k0> pVar, int i10, int i11) {
        super(2);
        this.$modifier = modifier;
        this.$shape = shape;
        this.$color = j10;
        this.$contentColor = j11;
        this.$border = borderStroke;
        this.$elevation = f10;
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
        SurfaceKt.m1147SurfaceFjzlyU(this.$modifier, this.$shape, this.$color, this.$contentColor, this.$border, this.$elevation, this.$content, composer, this.$$changed | 1, this.$$default);
    }
}

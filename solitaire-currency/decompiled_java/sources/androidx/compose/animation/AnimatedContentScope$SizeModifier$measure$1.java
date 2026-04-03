package androidx.compose.animation;

import androidx.compose.ui.layout.Placeable;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
final class AnimatedContentScope$SizeModifier$measure$1 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ long $offset;
    final /* synthetic */ Placeable $placeable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnimatedContentScope$SizeModifier$measure$1(Placeable placeable, long j10) {
        super(1);
        this.$placeable = placeable;
        this.$offset = j10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        Placeable.PlacementScope.m3017place70tqf50$default(layout, this.$placeable, this.$offset, 0.0f, 2, null);
    }
}

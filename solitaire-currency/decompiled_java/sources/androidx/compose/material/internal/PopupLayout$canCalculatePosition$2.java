package androidx.compose.material.internal;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExposedDropdownMenuPopup.kt */
/* JADX INFO: loaded from: classes.dex */
final class PopupLayout$canCalculatePosition$2 extends v implements a<Boolean> {
    final /* synthetic */ PopupLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PopupLayout$canCalculatePosition$2(PopupLayout popupLayout) {
        super(0);
        this.this$0 = popupLayout;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf((this.this$0.getParentBounds() == null || this.this$0.m1225getPopupContentSizebOM6tXw() == null) ? false : true);
    }
}

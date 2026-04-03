package androidx.privacysandbox.ads.adservices.adselection;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdSelectionManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@f(c = "androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager$Api33Ext4Impl", f = "AdSelectionManager.kt", l = {92}, m = "selectAds")
final class AdSelectionManager$Api33Ext4Impl$selectAds$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdSelectionManager.Api33Ext4Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdSelectionManager$Api33Ext4Impl$selectAds$1(AdSelectionManager.Api33Ext4Impl api33Ext4Impl, z8.d<? super AdSelectionManager$Api33Ext4Impl$selectAds$1> dVar) {
        super(dVar);
        this.this$0 = api33Ext4Impl;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.selectAds(null, this);
    }
}

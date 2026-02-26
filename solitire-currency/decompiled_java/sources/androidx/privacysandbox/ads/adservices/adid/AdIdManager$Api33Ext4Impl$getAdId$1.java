package androidx.privacysandbox.ads.adservices.adid;

import androidx.privacysandbox.ads.adservices.adid.AdIdManager;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdIdManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@f(c = "androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl", f = "AdIdManager.kt", l = {62}, m = "getAdId")
final class AdIdManager$Api33Ext4Impl$getAdId$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdIdManager.Api33Ext4Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdIdManager$Api33Ext4Impl$getAdId$1(AdIdManager.Api33Ext4Impl api33Ext4Impl, z8.d<? super AdIdManager$Api33Ext4Impl$getAdId$1> dVar) {
        super(dVar);
        this.this$0 = api33Ext4Impl;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAdId(this);
    }
}

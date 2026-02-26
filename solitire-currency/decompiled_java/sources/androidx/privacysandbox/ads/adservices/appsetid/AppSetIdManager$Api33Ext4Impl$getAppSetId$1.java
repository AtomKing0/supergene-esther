package androidx.privacysandbox.ads.adservices.appsetid;

import androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AppSetIdManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@f(c = "androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager$Api33Ext4Impl", f = "AppSetIdManager.kt", l = {55}, m = "getAppSetId")
final class AppSetIdManager$Api33Ext4Impl$getAppSetId$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppSetIdManager.Api33Ext4Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppSetIdManager$Api33Ext4Impl$getAppSetId$1(AppSetIdManager.Api33Ext4Impl api33Ext4Impl, z8.d<? super AppSetIdManager$Api33Ext4Impl$getAppSetId$1> dVar) {
        super(dVar);
        this.this$0 = api33Ext4Impl;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAppSetId(this);
    }
}

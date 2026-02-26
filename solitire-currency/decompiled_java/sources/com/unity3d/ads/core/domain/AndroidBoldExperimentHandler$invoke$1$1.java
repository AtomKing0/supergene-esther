package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: AndroidBoldExperimentHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.ads.core.domain.AndroidBoldExperimentHandler$invoke$1$1", f = "AndroidBoldExperimentHandler.kt", l = {28}, m = "invokeSuspend")
final class AndroidBoldExperimentHandler$invoke$1$1 extends l implements p<o0, z8.d<? super k0>, Object> {
    final /* synthetic */ String $it;
    int label;
    final /* synthetic */ AndroidBoldExperimentHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidBoldExperimentHandler$invoke$1$1(AndroidBoldExperimentHandler androidBoldExperimentHandler, String str, z8.d<? super AndroidBoldExperimentHandler$invoke$1$1> dVar) {
        super(2, dVar);
        this.this$0 = androidBoldExperimentHandler;
        this.$it = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        return new AndroidBoldExperimentHandler$invoke$1$1(this.this$0, this.$it, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            ByteStringDataSource byteStringDataSource = this.this$0.gatewayCacheDataSource;
            ByteString byteStringFromBase64 = ProtobufExtensionsKt.fromBase64(this.$it);
            this.label = 1;
            if (byteStringDataSource.set(byteStringFromBase64, this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
        return ((AndroidBoldExperimentHandler$invoke$1$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}

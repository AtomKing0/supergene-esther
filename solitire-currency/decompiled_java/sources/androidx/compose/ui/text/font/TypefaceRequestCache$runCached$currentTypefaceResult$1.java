package androidx.compose.ui.text.font;

import androidx.compose.ui.text.platform.SynchronizedObject;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: FontFamilyResolver.kt */
/* JADX INFO: loaded from: classes.dex */
final class TypefaceRequestCache$runCached$currentTypefaceResult$1 extends v implements l<TypefaceResult, k0> {
    final /* synthetic */ TypefaceRequest $typefaceRequest;
    final /* synthetic */ TypefaceRequestCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TypefaceRequestCache$runCached$currentTypefaceResult$1(TypefaceRequestCache typefaceRequestCache, TypefaceRequest typefaceRequest) {
        super(1);
        this.this$0 = typefaceRequestCache;
        this.$typefaceRequest = typefaceRequest;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(TypefaceResult typefaceResult) {
        invoke2(typefaceResult);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull TypefaceResult finalResult) {
        t.i(finalResult, "finalResult");
        SynchronizedObject lock$ui_text_release = this.this$0.getLock$ui_text_release();
        TypefaceRequestCache typefaceRequestCache = this.this$0;
        TypefaceRequest typefaceRequest = this.$typefaceRequest;
        synchronized (lock$ui_text_release) {
            if (finalResult.getCacheable()) {
                typefaceRequestCache.resultCache.put(typefaceRequest, finalResult);
            } else {
                typefaceRequestCache.resultCache.remove(typefaceRequest);
            }
            k0 k0Var = k0.f35197a;
        }
    }
}

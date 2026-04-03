package androidx.compose.ui.text.font;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: FontFamilyResolver.kt */
/* JADX INFO: loaded from: classes.dex */
final class FontFamilyResolverImpl$resolve$result$1 extends v implements l<l<? super TypefaceResult, ? extends k0>, TypefaceResult> {
    final /* synthetic */ TypefaceRequest $typefaceRequest;
    final /* synthetic */ FontFamilyResolverImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontFamilyResolverImpl$resolve$result$1(FontFamilyResolverImpl fontFamilyResolverImpl, TypefaceRequest typefaceRequest) {
        super(1);
        this.this$0 = fontFamilyResolverImpl;
        this.$typefaceRequest = typefaceRequest;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ TypefaceResult invoke(l<? super TypefaceResult, ? extends k0> lVar) {
        return invoke2((l<? super TypefaceResult, k0>) lVar);
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TypefaceResult invoke2(@NotNull l<? super TypefaceResult, k0> onAsyncCompletion) {
        t.i(onAsyncCompletion, "onAsyncCompletion");
        TypefaceResult typefaceResultResolve = this.this$0.fontListFontFamilyTypefaceAdapter.resolve(this.$typefaceRequest, this.this$0.getPlatformFontLoader$ui_text_release(), onAsyncCompletion, this.this$0.createDefaultTypeface);
        if (typefaceResultResolve == null && (typefaceResultResolve = this.this$0.platformFamilyTypefaceAdapter.resolve(this.$typefaceRequest, this.this$0.getPlatformFontLoader$ui_text_release(), onAsyncCompletion, this.this$0.createDefaultTypeface)) == null) {
            throw new IllegalStateException("Could not load font");
        }
        return typefaceResultResolve;
    }
}

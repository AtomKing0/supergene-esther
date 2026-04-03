package androidx.compose.ui.text.font;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FontFamilyResolver.kt */
/* JADX INFO: loaded from: classes.dex */
final class FontFamilyResolverImpl$createDefaultTypeface$1 extends v implements l<TypefaceRequest, Object> {
    final /* synthetic */ FontFamilyResolverImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontFamilyResolverImpl$createDefaultTypeface$1(FontFamilyResolverImpl fontFamilyResolverImpl) {
        super(1);
        this.this$0 = fontFamilyResolverImpl;
    }

    @Override // h9.l
    @NotNull
    public final Object invoke(@NotNull TypefaceRequest it) {
        t.i(it, "it");
        return this.this$0.resolve(TypefaceRequest.m3447copye1PVR60$default(it, null, null, 0, 0, null, 30, null)).getValue();
    }
}

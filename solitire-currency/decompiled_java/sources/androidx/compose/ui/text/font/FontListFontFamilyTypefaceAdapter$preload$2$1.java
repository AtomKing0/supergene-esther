package androidx.compose.ui.text.font;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
final class FontListFontFamilyTypefaceAdapter$preload$2$1 extends v implements l<TypefaceRequest, k0> {
    public static final FontListFontFamilyTypefaceAdapter$preload$2$1 INSTANCE = new FontListFontFamilyTypefaceAdapter$preload$2$1();

    FontListFontFamilyTypefaceAdapter$preload$2$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull TypefaceRequest it) {
        t.i(it, "it");
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(TypefaceRequest typefaceRequest) {
        invoke2(typefaceRequest);
        return k0.f35197a;
    }
}

package androidx.compose.ui.platform;

import androidx.compose.ui.text.font.FontFamily;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CompositionLocals.kt */
/* JADX INFO: loaded from: classes.dex */
final class CompositionLocalsKt$LocalFontFamilyResolver$1 extends kotlin.jvm.internal.v implements h9.a<FontFamily.Resolver> {
    public static final CompositionLocalsKt$LocalFontFamilyResolver$1 INSTANCE = new CompositionLocalsKt$LocalFontFamilyResolver$1();

    CompositionLocalsKt$LocalFontFamilyResolver$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final FontFamily.Resolver invoke() {
        CompositionLocalsKt.noLocalProvidedFor("LocalFontFamilyResolver");
        throw new v8.h();
    }
}

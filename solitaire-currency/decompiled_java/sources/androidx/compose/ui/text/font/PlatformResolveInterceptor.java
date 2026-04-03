package androidx.compose.ui.text.font;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FontFamilyResolver.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PlatformResolveInterceptor {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: FontFamilyResolver.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final PlatformResolveInterceptor Default = new PlatformResolveInterceptor() { // from class: androidx.compose.ui.text.font.PlatformResolveInterceptor$Companion$Default$1
            @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
            public /* synthetic */ FontFamily interceptFontFamily(FontFamily fontFamily) {
                return d.a(this, fontFamily);
            }

            @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
            /* JADX INFO: renamed from: interceptFontStyle-T2F_aPo */
            public /* synthetic */ int mo3371interceptFontStyleT2F_aPo(int i10) {
                return d.b(this, i10);
            }

            @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
            /* JADX INFO: renamed from: interceptFontSynthesis-Mscr08Y */
            public /* synthetic */ int mo3372interceptFontSynthesisMscr08Y(int i10) {
                return d.c(this, i10);
            }

            @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
            public /* synthetic */ FontWeight interceptFontWeight(FontWeight fontWeight) {
                return d.d(this, fontWeight);
            }
        };

        private Companion() {
        }

        @NotNull
        public final PlatformResolveInterceptor getDefault$ui_text_release() {
            return Default;
        }
    }

    @Nullable
    FontFamily interceptFontFamily(@Nullable FontFamily fontFamily);

    /* JADX INFO: renamed from: interceptFontStyle-T2F_aPo */
    int mo3371interceptFontStyleT2F_aPo(int i10);

    /* JADX INFO: renamed from: interceptFontSynthesis-Mscr08Y */
    int mo3372interceptFontSynthesisMscr08Y(int i10);

    @NotNull
    FontWeight interceptFontWeight(@NotNull FontWeight fontWeight);
}

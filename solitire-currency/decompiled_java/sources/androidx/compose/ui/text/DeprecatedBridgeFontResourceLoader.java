package androidx.compose.ui.text;

import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.c;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextLayoutResult.kt */
/* JADX INFO: loaded from: classes.dex */
final class DeprecatedBridgeFontResourceLoader implements Font.ResourceLoader {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static Map<FontFamily.Resolver, Font.ResourceLoader> cache = new LinkedHashMap();

    @NotNull
    private static final SynchronizedObject lock = Synchronization_jvmKt.createSynchronizedObject();

    @NotNull
    private final FontFamily.Resolver fontFamilyResolver;

    /* JADX INFO: compiled from: TextLayoutResult.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final Font.ResourceLoader from(@NotNull FontFamily.Resolver fontFamilyResolver) {
            t.i(fontFamilyResolver, "fontFamilyResolver");
            synchronized (getLock()) {
                Companion companion = DeprecatedBridgeFontResourceLoader.Companion;
                Font.ResourceLoader resourceLoader = companion.getCache().get(fontFamilyResolver);
                if (resourceLoader != null) {
                    return resourceLoader;
                }
                DeprecatedBridgeFontResourceLoader deprecatedBridgeFontResourceLoader = new DeprecatedBridgeFontResourceLoader(fontFamilyResolver, null);
                companion.getCache().put(fontFamilyResolver, deprecatedBridgeFontResourceLoader);
                return deprecatedBridgeFontResourceLoader;
            }
        }

        @NotNull
        public final Map<FontFamily.Resolver, Font.ResourceLoader> getCache() {
            return DeprecatedBridgeFontResourceLoader.cache;
        }

        @NotNull
        public final SynchronizedObject getLock() {
            return DeprecatedBridgeFontResourceLoader.lock;
        }

        public final void setCache(@NotNull Map<FontFamily.Resolver, Font.ResourceLoader> map) {
            t.i(map, "<set-?>");
            DeprecatedBridgeFontResourceLoader.cache = map;
        }
    }

    public /* synthetic */ DeprecatedBridgeFontResourceLoader(FontFamily.Resolver resolver, k kVar) {
        this(resolver);
    }

    @Override // androidx.compose.ui.text.font.Font.ResourceLoader
    @NotNull
    public Object load(@NotNull Font font) {
        t.i(font, "font");
        return c.a(this.fontFamilyResolver, FontKt.toFontFamily(font), font.getWeight(), font.mo3361getStyle_LCdwA(), 0, 8, null).getValue();
    }

    private DeprecatedBridgeFontResourceLoader(FontFamily.Resolver resolver) {
        this.fontFamilyResolver = resolver;
    }
}

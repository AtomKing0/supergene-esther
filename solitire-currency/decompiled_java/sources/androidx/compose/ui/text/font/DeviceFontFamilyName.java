package androidx.compose.ui.text.font;

import androidx.compose.ui.text.ExperimentalTextApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DeviceFontFamilyNameFont.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalTextApi
public final class DeviceFontFamilyName {

    @NotNull
    private final String name;

    private /* synthetic */ DeviceFontFamilyName(String str) {
        this.name = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DeviceFontFamilyName m3383boximpl(String str) {
        return new DeviceFontFamilyName(str);
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m3384constructorimpl(@NotNull String name) {
        t.i(name, "name");
        if (name.length() > 0) {
            return name;
        }
        throw new IllegalArgumentException("name may not be empty".toString());
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3385equalsimpl(String str, Object obj) {
        return (obj instanceof DeviceFontFamilyName) && t.d(str, ((DeviceFontFamilyName) obj).m3389unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3386equalsimpl0(String str, String str2) {
        return t.d(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3387hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3388toStringimpl(String str) {
        return "DeviceFontFamilyName(name=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m3385equalsimpl(this.name, obj);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return m3387hashCodeimpl(this.name);
    }

    public String toString() {
        return m3388toStringimpl(this.name);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m3389unboximpl() {
        return this.name;
    }
}

package androidx.window.core;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: Version.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Version implements Comparable<Version> {

    @NotNull
    private static final Version CURRENT;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Version UNKNOWN = new Version(0, 0, 0, "");

    @NotNull
    private static final Version VERSION_0_1 = new Version(0, 1, 0, "");

    @NotNull
    private static final Version VERSION_1_0;

    @NotNull
    private static final String VERSION_PATTERN_STRING = "(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?";

    @NotNull
    private final l bigInteger$delegate;

    @NotNull
    private final String description;
    private final int major;
    private final int minor;
    private final int patch;

    /* JADX INFO: compiled from: Version.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final Version getCURRENT() {
            return Version.CURRENT;
        }

        @NotNull
        public final Version getUNKNOWN() {
            return Version.UNKNOWN;
        }

        @NotNull
        public final Version getVERSION_0_1() {
            return Version.VERSION_0_1;
        }

        @NotNull
        public final Version getVERSION_1_0() {
            return Version.VERSION_1_0;
        }

        @Nullable
        public final Version parse(@Nullable String str) {
            if (str == null || q.z(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile(Version.VERSION_PATTERN_STRING).matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            String strGroup = matcher.group(1);
            Integer numValueOf = strGroup == null ? null : Integer.valueOf(Integer.parseInt(strGroup));
            if (numValueOf == null) {
                return null;
            }
            int iIntValue = numValueOf.intValue();
            String strGroup2 = matcher.group(2);
            Integer numValueOf2 = strGroup2 == null ? null : Integer.valueOf(Integer.parseInt(strGroup2));
            if (numValueOf2 == null) {
                return null;
            }
            int iIntValue2 = numValueOf2.intValue();
            String strGroup3 = matcher.group(3);
            Integer numValueOf3 = strGroup3 == null ? null : Integer.valueOf(Integer.parseInt(strGroup3));
            if (numValueOf3 == null) {
                return null;
            }
            int iIntValue3 = numValueOf3.intValue();
            String description = matcher.group(4) != null ? matcher.group(4) : "";
            t.h(description, "description");
            return new Version(iIntValue, iIntValue2, iIntValue3, description, null);
        }
    }

    static {
        Version version = new Version(1, 0, 0, "");
        VERSION_1_0 = version;
        CURRENT = version;
    }

    public /* synthetic */ Version(int i10, int i11, int i12, String str, k kVar) {
        this(i10, i11, i12, str);
    }

    private final BigInteger getBigInteger() {
        Object value = this.bigInteger$delegate.getValue();
        t.h(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    @Nullable
    public static final Version parse(@Nullable String str) {
        return Companion.parse(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        return this.major == version.major && this.minor == version.minor && this.patch == version.patch;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public int hashCode() {
        return ((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.major) * 31) + this.minor) * 31) + this.patch;
    }

    @NotNull
    public String toString() {
        return this.major + '.' + this.minor + '.' + this.patch + (q.z(this.description) ^ true ? t.r("-", this.description) : "");
    }

    private Version(int i10, int i11, int i12, String str) {
        this.major = i10;
        this.minor = i11;
        this.patch = i12;
        this.description = str;
        this.bigInteger$delegate = n.a(new Version$bigInteger$2(this));
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull Version other) {
        t.i(other, "other");
        return getBigInteger().compareTo(other.getBigInteger());
    }
}

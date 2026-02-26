package androidx.room.util;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.room.Room;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.r;

/* JADX INFO: compiled from: StringUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class StringUtil {

    @NotNull
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static final void appendPlaceholders(@NotNull StringBuilder builder, int i10) {
        t.i(builder, "builder");
        for (int i11 = 0; i11 < i10; i11++) {
            builder.append("?");
            if (i11 < i10 - 1) {
                builder.append(",");
            }
        }
    }

    @Nullable
    public static final String joinIntoString(@Nullable List<Integer> list) {
        if (list != null) {
            return d0.r0(list, ",", null, null, 0, null, null, 62, null);
        }
        return null;
    }

    @NotNull
    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    @Nullable
    public static final List<Integer> splitToIntList(@Nullable String str) {
        List listB0;
        Integer numValueOf;
        if (str == null || (listB0 = r.B0(str, new char[]{','}, false, 0, 6, null)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = listB0.iterator();
        while (it.hasNext()) {
            try {
                numValueOf = Integer.valueOf(Integer.parseInt((String) it.next()));
            } catch (NumberFormatException e10) {
                Log.e(Room.LOG_TAG, "Malformed integer list", e10);
                numValueOf = null;
            }
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }
}
